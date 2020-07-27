package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaEmpty;
import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaEmptyFactory implements IEstradaFactory {

    private EstradaEmpty onlyInstance;

    public EstradaEmptyFactory() {
    }

    @Override
    public AbstractEstrada create(Point point) {
        onlyInstance = new EstradaEmpty();
        onlyInstance.setPoint(point);
        return onlyInstance;
    }

}
