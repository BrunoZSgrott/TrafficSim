/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import roadMap.RoadMapFactory;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Display extends Canvas implements Observer, Runnable {

    public static final int PIXELSIZE = 32;
    public static JFrame frame;
    private final int SCALE = 1;

    private List<IRenderable> renderable;
    private IDisplayController controller;

    private RoadMapFactory mapFactory;

    public Display() {
        mapFactory = new RoadMapFactory();
        controller = new MainController();
        renderable = new ArrayList<>();
        controller.addObservador(this);
    }

    public RoadMapFactory getLevel() {
        return mapFactory;
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(1);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        for (int i = 0; i < renderable.size(); i++) {
            renderable.get(i).render(g);
        }
        bs.show();
    }

    public void init() {
        frame = new JFrame();
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void setSize(int x, int y) {
        int HEIGHT = PIXELSIZE * x;
        int WIDTH = PIXELSIZE * (y - 1);
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    }

    @Override
    public void run() {
        controller.run();
    }

    public synchronized void start() {
        controller.start();
    }

    @Override
    public void addRenderable(IRenderable render) {
        renderable.add(render);
    }

}
