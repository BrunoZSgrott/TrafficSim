package canvas;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @since 13/07/2020
 * @version
 * @author Bruno Zilli Sgrott
 */
public class Spritesheet {

    private static BufferedImage spritesheet;
    private static Spritesheet object;

    public static Spritesheet getInstance() {
        if (object == null) {
            object = new Spritesheet();
        }
        return object;
    }

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("/resources/spritesheet.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y) {
        return spritesheet.getSubimage(x * Display.PIXELSIZE, y * Display.PIXELSIZE, Display.PIXELSIZE, Display.PIXELSIZE);
    }

    public BufferedImage getSprite(int x, int y, int width, int heigth) {
        return spritesheet.getSubimage(x, y, width, heigth);
    }

}
