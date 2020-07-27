package canvas;

import estrada.visitor.IVisitor;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface IVisitable {

    void accept(IVisitor object);
}
