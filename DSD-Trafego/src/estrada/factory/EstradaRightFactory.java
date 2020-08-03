package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaNormal;
import estrada.EstradaType;
import java.awt.Point;

/**
 *
 * @author Vinicius Catafesta
 */
class EstradaRightFactory implements IEstradaFactory {

    @Override
    public AbstractEstrada create(Point point) {
        EstradaNormal estrada = new EstradaNormal(EstradaType.ESTRADA_RIGHT);
        estrada.setPoint(point);
        return estrada;
    }
}
