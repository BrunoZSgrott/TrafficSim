package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaNormal;
import estrada.EstradaType;
import java.awt.Point;

/**
 *
 * @author Vinicius Catafesta
 */
class EstradaLeftFactory implements IEstradaFactory {

    @Override
    public AbstractEstrada create(Point point) {
        EstradaNormal estrada = new EstradaNormal(EstradaType.ESTRADA_LEFT);
        estrada.setPoint(point);
        return estrada;
    }

}
