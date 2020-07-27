package estrada.visitor;

import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaVisitorFindEntries implements IVisitor {

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitEStradaVazia(EstradaEmpty estrada) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
