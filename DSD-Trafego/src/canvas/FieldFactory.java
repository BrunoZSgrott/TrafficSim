package canvas;

import estrada.EstradaMutexDecorator;
import estrada.visitor.EstradaVisitorConnectRoad;
import estrada.visitor.EstradaVisitorFindExits;
import estrada.visitor.EstradaVisitorFindEntries;
import estrada.EstradaType;
import estrada.factory.EstradaFactory;
import estrada.visitor.CruzamentoVisitorConnect;
import java.awt.Point;
import mutex.factory.IMutexFactory;
import roadMap.RoadMap;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class FieldFactory {

    private IMutexFactory factory;

    public FieldFactory(IMutexFactory factory) {
        this.factory = factory;
    }

    public Field create(RoadMap roadmap) {
        Field field = new Field(roadmap.getLinha(), roadmap.getColuna());
        for (int i = 0; i < roadmap.getLinha(); i++) {
            for (int j = 0; j < roadmap.getColuna(); j++) {
                field.add(EstradaFactory.getInstance().create(EstradaType.getTypeFromInt(roadmap.getValue(i, j)), new Point(i, j)));
            }
        }

        field.accept(new EstradaVisitorConnectRoad(field));
        field.accept(new EstradaVisitorFindEntries(field));
        field.accept(new EstradaVisitorFindExits(field));
        field.accept(new CruzamentoVisitorConnect());
        field.accept(new EstradaMutexVisitor(field, factory));

        return field;
    }
}
