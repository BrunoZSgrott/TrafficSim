/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import roadMap.RoadMapFactory;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Display extends Canvas implements Observer, Runnable {

    public static final int PIXELSIZE = 32;
    public static JFrame frame;
    private final int SCALE = 1;
    private BufferedImage image;

    private MainController controller;

    private int WIDTH;
    private int HEIGHT;
    private RoadMapFactory mapFactory;

    public Display() {
        mapFactory = new RoadMapFactory();
        controller = new MainController();
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
        Graphics g = image.getGraphics();
        g.setColor(new Color(19, 19, 19));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
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
        HEIGHT = PIXELSIZE * x;
        WIDTH = PIXELSIZE * (y - 1);
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void run() {
        controller.run();
    }

    public synchronized void start() {
        controller.start();
    }

}
