package estrada;

import canvas.IRenderable;
import estrada.visitor.IVisitor;
import java.awt.Point;
import mutex.factory.IMutex;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public interface IEstrada extends IRenderable {

    EstradaType getType();

    Point getPoint();

    void accept(IVisitor visitor) throws Exception;

    public void setPossuiAnterior(boolean b);

    public void setMutex(IMutex mutex);
}
