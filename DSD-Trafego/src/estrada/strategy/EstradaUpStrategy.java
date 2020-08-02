package estrada.strategy;

import canvas.Spritesheet;
import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaUpStrategy implements IEstradaStrategy {

    private AbstractEstrada estrada;

    public EstradaUpStrategy(AbstractEstrada estrada) {
        this.estrada = estrada;
    }

    @Override
    public AbstractEstrada getEstrada() {
        return this.estrada;
    }
    
    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSpriteEstradaUp();
    }
}
