/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import estrada.AbstractEstrada;
import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class Field {

    HashMap<Point, AbstractEstrada> list;

    public Field() {
        list = new HashMap<Point, AbstractEstrada>();
    }

    public void add(Point local, AbstractEstrada estrada) {
        list.put(local, estrada);
    }
}
