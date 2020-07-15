/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Main extends Canvas implements Runnable, Observer {

    public static final int PIXELSIZE = 32;
    public static JFrame frame;
    private Thread thread;
    private boolean isRunning;
    private final int SCALE = 1;
    private final double FPS = 60.0;
    private BufferedImage image;

    private MainController controller;

    private int WIDTH;
    private int HEIGHT;
    private Level level;

    public Main() {
        level = new Level(3);

        controller = new MainController();
        controller.addObservador(this);

        WIDTH = PIXELSIZE * (level.getColunas() - 1);
        HEIGHT = PIXELSIZE * level.getLinhas();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
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
            Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void tick() {
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        g.setColor(new Color(19, 19, 19));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (level != null) {
            level.render(g);
        }
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        bs.show();
    }

    @Override
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
                render();
            }
        }
        stop();
    }

    public void initFrame() {
        frame = new JFrame();
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
