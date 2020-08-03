package canvas;

import estrada.AbstractEstrada;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import mutex.factory.IMutexFactory;
import mutex.factory.MonitorMutexFactory;
import mutex.factory.MutexFactoryCreator;
import mutex.factory.SemaphoreMutexFactory;
import vehicle.IVehicleMovementObserver;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MainController implements IDisplayController, Runnable, IVehicleMovementObserver {

    private Thread thread;
    public static Field field;
    public static final double FPS = 60.0;
    private boolean spawn;
    private boolean isRunning;
    public static boolean paused = false;
    private int carrosSpawnados = 0;
    private IVehicleController vehicleController;
    private ExecutorService vehicleControl;

    private Configuracao config;

    public MainController(Configuracao config) {
        this.config = config;
        IMutexFactory mutexFactory = MutexFactoryCreator.create(config.getThreadControl());
        vehicleController = new VehicleController(mutexFactory.create());

        FieldFactory fieldFactory = new FieldFactory(mutexFactory);
        field = fieldFactory.create(config.getRoadMap());
        this.vehicleControl = Executors.newFixedThreadPool(config.getNumCarros());
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObservador(Observer obs) {
        observers.add(obs);
        notifyViewSize();
        notifyViewStart();
        notifyNewRenderable(field);
    }

    @Override
    public void removerObservador(Observer obs) {
        observers.remove(obs);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
        spawn = true;
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    protected void notifyViewSize() {
        observers.forEach((o) -> {
            o.setSize(field.getLinha(), field.getColuna());
        });
    }

    protected void notifyNewRenderable(IRenderable render) {
        observers.forEach((o) -> {
            o.addRenderable(render);
        });
    }

    protected void notifyViewStart() {
        observers.forEach((o) -> {
            o.init();
        });
    }

    public void tick() {
        try {
            if (config.getNumCarros() > carrosSpawnados && spawn) {
                spawnNewCar();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double nanoseconds = 1000000000 / FPS;
        double delta = 0;
        int currentFrame = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoseconds;
            lastTime = now;
            if (delta >= 1) {
                currentFrame++;
                if (currentFrame == config.calcOffsetAsFrames()) {
                    tick();
                    currentFrame = 0;
                }
                notifyRender();
                delta--;
            }
        }
        stop();
    }

    public void spawnNewCar() {
        Vehicle vehicle = new Vehicle();
        vehicle.setObserver(this);
        vehicle.setProximaEstrada(field.getRandomEntrada());
        carrosSpawnados++;
        vehicleControl.execute(vehicle);
        notifyNewRenderable(vehicle);
    }

    public void notifyRender() {
        observers.forEach((o) -> {
            o.render();
        });
    }

    @Override
    public void updateVehicle(Vehicle vehicle, Point point, Point newCell) {
        try {
            if (vehicleController != null) {
                vehicleController.onUpdateVehicle(vehicle, point, newCell);
            }
            if (field.saidas.contains(newCell) || field.saidas.contains(point)) {
                field.list.forEach((P, e) -> {
                    if (((AbstractEstrada) e).getVehicle() == vehicle) {
                        ((AbstractEstrada) e).setVehicle(null);
                    }
                });
                carrosSpawnados--;
                if (carrosSpawnados == 0 && !spawn) {
                    spawn = false;
                }
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public void pause() {
        paused = !paused;
    }

    @Override
    public void end() {
        isRunning = false;
    }

    @Override
    public void endAndWait() {
        this.spawn = false;
    }
}
