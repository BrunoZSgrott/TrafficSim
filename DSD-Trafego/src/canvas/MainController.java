/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import roadMap.RoadMapFactory;
import roadMap.RoadMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MainController implements IDisplayController, Runnable {

    private Thread thread;
    private Field field;
    private RoadMap roadMap;
    private final double FPS = 60.0;
    private boolean isRunning;

    public MainController() {
        try {
            FieldFactory fieldFactory = new FieldFactory();
            RoadMapFactory RoadMapFactory = new RoadMapFactory();
            this.roadMap = RoadMapFactory.create(new BufferedReader(new FileReader(RoadMapFactory.getPathForLevel(3))));
            field = fieldFactory.create(this.roadMap);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void tick(int currentFrame) {
    }

    protected void notifyViewSize() {
        observers.forEach((o) -> {
            o.setSize(roadMap.getLinha(), roadMap.getColuna());
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

    }

    public void run() {
        long lastTime = System.nanoTime();
        double nanoseconds = 1000000000 / FPS;
        double delta = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nanoseconds;
            lastTime = now;
            if (delta >= 1) {
                tick();
                notifyRender();
            }
        }
        stop();

    }

    public void notifyRender() {
        observers.forEach((o) -> {
            o.render();
        });
    }

}
