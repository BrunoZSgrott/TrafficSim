package estrada.strategy;

import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public interface IEstradaStrategy {

    AbstractEstrada getEstrada();

    BufferedImage getImage();
}
