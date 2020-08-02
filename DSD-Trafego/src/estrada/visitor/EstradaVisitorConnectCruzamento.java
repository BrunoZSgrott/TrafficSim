package estrada.visitor;

import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import estrada.IEstrada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaVisitorConnectCruzamento implements IVisitor {

    private List<IEstrada> caminhos;
    private EstradaCaminho caminhoAtual;

    public EstradaVisitorConnectCruzamento(List<IEstrada> caminhos) {
        this.caminhos = caminhos;
        this.caminhoAtual = new EstradaCaminho();
        this.caminhoAtual.setEstradas(new ArrayList<>());
    }

    public EstradaVisitorConnectCruzamento(List<IEstrada> caminhos, EstradaCaminho caminho) {
        this.caminhos = caminhos;
        this.caminhoAtual = caminho;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) {
        caminhoAtual.adicionaEstrada(estrada);
        caminhos.add(caminhoAtual);
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws CloneNotSupportedException, Exception {
        if (caminhoAtual.getEstradas().contains(estrada)) {
            return;
        }
        caminhoAtual.adicionaEstrada(estrada);
        for (IEstrada estradaProxima : estrada.getProximas()) {
            estradaProxima.accept(new EstradaVisitorConnectCruzamento(caminhos, caminhoAtual.clone()));
        }
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
        return;
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
        return;
    }

}
