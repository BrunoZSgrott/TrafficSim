/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import estrada.visitor.EstradaVisitorFindExits;
import estrada.visitor.EstradaVisitorFindEntries;
import estrada.EstradaType;
import estrada.factory.EstradaFactory;
import java.awt.Point;
import roadMap.RoadMap;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class FieldFactory {

    public Field create(RoadMap roadmap) {
        Field field = new Field();
        for (int i = 0; i < roadmap.getColuna(); i++) {
            for (int j = 0; j < roadmap.getLinha(); j++) {
                field.add(EstradaFactory.getInstance().create(EstradaType.getTypeFromInt(roadmap.getValue(i, j)), new Point(i, j)));
            }
        }

        field.accept(new EstradaVisitorConnectRoad(field));
        field.accept(new EstradaVisitorFindEntries());
        field.accept(new EstradaVisitorFindExits());

        return field;
    }
}
