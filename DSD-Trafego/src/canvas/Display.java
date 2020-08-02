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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import roadMap.RoadMap;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Display extends Canvas implements Observer, Runnable, KeyListener {

    public static final int PIXELSIZE = 32;
    public static JFrame frame;
    private final int SCALE = 1;

    private List<IRenderable> renderable;
    private IDisplayController controller;

    public Display(Configuracao config) {
        controller = new MainController(config);
        renderable = new ArrayList<>();
        controller.addObservador(this);
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
        int HEIGHT = PIXELSIZE * (x);
        int WIDTH = PIXELSIZE * (y);
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
        renderable.sort((o1, o2) -> {
            if (o1 instanceof Vehicle) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'z'){
            controller.pause();
        }
        if(e.getKeyChar() == 'x'){
            
        }
        if(e.getKeyChar() == 'c'){
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
