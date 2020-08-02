/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Point;
import mutex.factory.IMutex;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class AbstractEstradaDecorator implements IEstrada {

    private IEstrada estrada;

    public AbstractEstradaDecorator(IEstrada estrada) {
        this.estrada = estrada;
    }

    public EstradaType getType() {
        return estrada.getType();
    }

    public Point getPoint() {
        return estrada.getPoint();
    }

    public void accept(IVisitor visitor) throws Exception {
        estrada.accept(visitor);
    }

    @Override
    public void render(Graphics g) {
        estrada.render(g);
    }

    @Override
    public void setPossuiAnterior(boolean b) {
        estrada.setPossuiAnterior(b);
    }

    @Override
    public void setMutex(IMutex mutex) {
        estrada.setMutex(mutex);
    }

}
