package canvas;

import estrada.AbstractEstrada;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import estrada.visitor.IVisitor;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaVisitorConnectRoad implements IVisitor {

    private Field field;

    public EstradaVisitorConnectRoad(Field field) {
        this.field = field;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        Point point = new EstradaNormalMovementFactory().getInstance().create(estrada);
        AbstractEstrada proximaEstrada;
        try {
            proximaEstrada = field.getEstrada(point);
            proximaEstrada.setPossuiAnterior(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
            proximaEstrada = null;
        } catch (NullPointerException ex) {
            proximaEstrada = null;
        }
        estrada.setProxima(proximaEstrada);
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        List<Point> nextPoints = new EstradaCruzamentoMovementFactory().getInstance().create(estrada);
        List<AbstractEstrada> nextCells;
        try {
            nextCells = field.getEstrada(nextPoints);
            for (AbstractEstrada nextCell : nextCells) {
                nextCell.setPossuiAnterior(true);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            nextCells = null;
        }
        estrada.setProximas(nextCells);
    }

    @Override
    public void visitEStradaVazia(EstradaEmpty estrada) throws Exception {

    }

}
