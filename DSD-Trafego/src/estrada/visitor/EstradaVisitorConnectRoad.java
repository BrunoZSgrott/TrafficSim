package estrada.visitor;

import estrada.factory.EstradaCruzamentoMovementFactory;
import canvas.Field;
import estrada.AbstractEstrada;
import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import estrada.IEstrada;
import estrada.factory.EstradaNormalMovementFactory;
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
        IEstrada proximaEstrada;
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
        List<IEstrada> proximas;
        try {
            proximas = field.getEstrada(nextPoints);
            for (IEstrada estradaProxima : proximas) {
                estradaProxima.setPossuiAnterior(true);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            proximas = null;
        }
        estrada.setProximas(proximas);
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {

    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
        return;
    }

}
