package estrada.strategy;

import canvas.Spritesheet;
import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class CruzamentoUpLeftStrategy implements IEstradaStrategy {

    private AbstractEstrada estrada;

    public CruzamentoUpLeftStrategy(AbstractEstrada estrada) {
        this.estrada = estrada;
    }

    @Override
    public AbstractEstrada getEstrada() {
        return this.estrada;
    }

    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSpriteCruzamentoUpLeft();
    }
}
