package estrada;

import canvas.Spritesheet;
import estrada.visitor.IVisitor;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaEmpty extends AbstractEstrada {

    public EstradaEmpty() {
        super(EstradaType.ESTRADA_EMPTY);
    }

    @Override
    public void accept(IVisitor visitor) {
        try {
            visitor.visitEStradaVazia(this);
        } catch (Exception ex) {
            Logger.getLogger(EstradaEmpty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(3, 3);
    }

}
