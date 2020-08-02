/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
