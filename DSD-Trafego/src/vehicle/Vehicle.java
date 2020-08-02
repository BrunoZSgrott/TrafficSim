package vehicle;

import vehicle.visitor.VehicleMovementVisitor;
import vehicle.visitor.VehicleStrategyFactory;
import canvas.IRenderable;
import canvas.Display;
import canvas.MainController;
import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.IEstrada;
import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;
import javafx.application.Application;
import vehicle.strategy.VehicleStrategy;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Vehicle extends Thread implements IRenderable {

    @Override
    public synchronized void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (estrada != null) {
            g2.drawImage(getImage(), estrada.getPoint().y * Display.PIXELSIZE, estrada.getPoint().x * Display.PIXELSIZE, null);
            if (estrada != null) {
                estrada.render(g);
            }
            if (nextEstrada != null) {
                nextEstrada.render(g);
            }
        }
    }

    private BufferedImage getImage() {
        return this.getStrategy().getImage();
    }

    protected VehicleStrategy getStrategy() {
        return new VehicleStrategyFactory().create(estrada.getType(), this);
    }

    private static final int BASE_VELOCITY = 400;
    private IEstrada estrada;
    private IEstrada nextEstrada;
    private IVehicleMovementObserver observer;
    private int velocity;
    private int turnVelocity;

    public Vehicle() {
        super();
        velocity = calculateVelocity();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && (estrada != null || nextEstrada != null)) {
            if (!MainController.paused) {
                if (nextEstrada != null) {
                    move(new VehicleMovementVisitor(this), nextEstrada);
                } else {
                    move(new VehicleMovementVisitor(this), estrada);
                    notifyUpdateEstrada(estrada.getPoint(), null);
                    estrada = null;
                }
                try {
                    sleep(turnVelocity);
                } catch (Exception e) {
                } finally {
                    turnVelocity = velocity;
                }
            }
        }
    }

    private void move(IVisitor moveVisitor, IEstrada moveEstrada) {
        try {
            IEstrada lastEstrada = estrada;
            moveEstrada.accept(moveVisitor);
            if (estrada != lastEstrada) {
                notifyUpdateEstrada((lastEstrada != null) ? lastEstrada.getPoint() : null, (estrada != null) ? estrada.getPoint() : null);
            }
        } catch (Exception e) {
        }
    }

    private int calculateVelocity() {
        Random random = new Random();
        int variancia = (int) (BASE_VELOCITY / 2);
        return (BASE_VELOCITY - variancia) + random.nextInt(variancia * 2);
    }

    public IEstrada getEstrada() {
        return estrada;
    }

    public void setEstrada(IEstrada Estrada) {
        this.estrada = Estrada;
    }

    public IEstrada getProximaEstrada() {
        return nextEstrada;
    }

    public void setProximaEstrada(IEstrada nextEstrada) {
        this.nextEstrada = nextEstrada;
    }

    public IVehicleMovementObserver getObserver() {
        return observer;
    }

    public void setObserver(IVehicleMovementObserver observer) {
        this.observer = observer;
    }

    public int getVelocity() {
        return velocity;
    }

    private void notifyUpdateEstrada(Point point, Point newEstrada) {
        observer.updateVehicle(this, point, newEstrada);
    }

    public void setTurnVelocity(int turnVelocity) {
        this.turnVelocity = turnVelocity;
    }

}
