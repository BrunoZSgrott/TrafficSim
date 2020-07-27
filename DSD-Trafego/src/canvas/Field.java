/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import estrada.AbstractEstrada;
import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class Field implements IVisitable, IRenderable {

    HashMap<Point, AbstractEstrada> list;

    public Field() {
        list = new HashMap<Point, AbstractEstrada>();
    }

    public void add(AbstractEstrada estrada) {
        list.put(estrada.getPoint(), estrada);
    }

    public void accept(IVisitor visitor) {
        list.forEach((point, estrada) -> {
            estrada.accept(visitor);
        }
        );
    }

    AbstractEstrada getEstrada(Point point) throws ArrayIndexOutOfBoundsException, NullPointerException {
        return list.get(point);
    }

    List<AbstractEstrada> getEstrada(List<Point> points) {
        List<AbstractEstrada> find = new ArrayList<>();
        for (Point point : points) {
            find.add(getEstrada(point));
        }
        return find;
    }

    @Override
    public void render(Graphics g) {
        list.forEach((point, estrada) -> {
            estrada.render(g);
        });
    }
}
