package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaNormal;
import estrada.EstradaType;
import java.awt.Point;

/**
 *
 * @author Vinicius Catafesta
 */
class EstradaUpFactory implements IEstradaFactory {

    @Override
    public AbstractEstrada create(Point point) {
        EstradaNormal estrada = new EstradaNormal(EstradaType.ESTRADA_UP);
        estrada.setPoint(point);
        return estrada;
    }

}
