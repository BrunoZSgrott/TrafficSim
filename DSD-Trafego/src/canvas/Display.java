package canvas;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
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
        addKeyListener(this);
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
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'z') {
            controller.pause();
        }
        if (e.getKeyChar() == 'x') {
            controller.endAndWait();
        }
        if (e.getKeyChar() == 'c') {
            controller.end();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
