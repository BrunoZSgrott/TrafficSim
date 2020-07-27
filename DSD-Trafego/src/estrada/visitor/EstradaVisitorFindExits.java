package estrada.visitor;

import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaVisitorFindExits implements IVisitor {

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
    }

    @Override
    public void visitEStradaVazia(EstradaEmpty estrada) throws Exception {
    }

}
