package estrada.visitor;

import canvas.Field;
import estrada.AbstractEstrada;
import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaVisitorFindExits implements IVisitor {

    private Field field;

    public EstradaVisitorFindExits(Field field) {
        this.field = field;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        if (estrada.getPossuiAnterior()) {
            adicionaBordaSeForSaida(estrada);
        }
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        if (estrada.getPossuiAnterior()) {
            adicionaBordaSeForSaida(estrada);
        }
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
    }

    private void adicionaBordaSeForSaida(AbstractEstrada estrada) {
        Point point = estrada.getPoint();
        int x = (int) point.getX();
        int y = (int) point.getY();
        if (x == 0 || y == 0 || x == field.getLinha() - 1 || y == field.getColuna() - 1) {
            field.addSaida(estrada);
        }
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
        return;
    }

}
