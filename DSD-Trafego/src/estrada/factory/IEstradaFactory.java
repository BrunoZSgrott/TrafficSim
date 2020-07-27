package estrada.factory;

import estrada.AbstractEstrada;
import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface IEstradaFactory {

    AbstractEstrada create(Point point);
}
