package canvas;

import canvas.ConfigView;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigView().setVisible(true);
            }
        });
    }

}
