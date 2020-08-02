package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaCruzamento;
import estrada.EstradaType;
import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class CruzamentoUpFactory implements IEstradaFactory {

    @Override
    public AbstractEstrada create(Point point) {
        EstradaCruzamento estrada = new EstradaCruzamento(EstradaType.CROSS_UP);
        estrada.setPoint(point);
        return estrada;
    }

}
