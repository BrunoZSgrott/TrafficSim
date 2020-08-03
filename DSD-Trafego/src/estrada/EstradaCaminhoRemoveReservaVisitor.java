package estrada;

import estrada.visitor.IVisitor;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class EstradaCaminhoRemoveReservaVisitor implements IVisitor {

    private EstradaCaminho caminho;

    EstradaCaminhoRemoveReservaVisitor(EstradaCaminho estrada) {
        this.caminho = estrada;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        if (estrada.getReserva() == caminho) {
            estrada.setReserva(null);
        }
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        if (estrada.getReserva() == caminho) {
            estrada.setReserva(null);
        }
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
    }

}
