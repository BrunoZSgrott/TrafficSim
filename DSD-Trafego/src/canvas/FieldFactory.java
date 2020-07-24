/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import java.awt.Point;
import roadMap.RoadMap;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class FieldFactory {

    public Field create(RoadMap roadmap) {
        Field field = new Field();
//        EstradaFactory estradaFactory = new EstradaFactory();
//        for (int i = 0; i < roadmap.getColuna(); i++) {
//            for (int j = 0; j < roadmap.getLinha(); j++) {
//                field.add(new Point(i, j), estradaFactory.create(roadmap.getValue(i, j)));
//            }
//        }

        return field;
    }
}
