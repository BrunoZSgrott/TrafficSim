package estrada;

import canvas.Display;
import canvas.IRenderable;
import canvas.Spritesheet;
import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaEmpty extends AbstractEstrada implements IRenderable {

    public EstradaEmpty() {
        super(EstradaType.ESTRADA_EMPTY);
    }

    @Override
    public void accept(IVisitor visitor) {
        try {
            if (getMutex() != null) {
                getMutex().execute(() -> {
                    visitor.visitEstradaVazia(this);
                });
            } else {
                visitor.visitEstradaVazia(this);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstradaEmpty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(3, 3);
    }

}
