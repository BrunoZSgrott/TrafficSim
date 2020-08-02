package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaCruzamento;
import estrada.EstradaType;
import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class CruzamentoDownLeftFactory implements IEstradaFactory {

    @Override
    public AbstractEstrada create(Point point) {
        EstradaCruzamento estrada = new EstradaCruzamento(EstradaType.CROSS_DOWN_LEFT);
        estrada.setPoint(point);
        return estrada;
    }

}
