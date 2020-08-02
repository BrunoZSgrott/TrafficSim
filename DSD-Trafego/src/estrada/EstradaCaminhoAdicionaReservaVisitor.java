package estrada;

import estrada.visitor.IVisitor;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class EstradaCaminhoAdicionaReservaVisitor implements IVisitor {

    private boolean reservado;
    private EstradaCaminho caminho;

    EstradaCaminhoAdicionaReservaVisitor(EstradaCaminho caminho) {
        this.caminho = caminho;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        if (!estrada.possuiReserva()) {
            estrada.setReserva(caminho);
        }
        reservado = estrada.getReserva() == caminho;
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        if (!estrada.possuiReserva()) {
            estrada.setReserva(caminho);
        }
        reservado = estrada.getReserva() == caminho;
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
    }

    boolean reservado() {
        return reservado;
    }

}
