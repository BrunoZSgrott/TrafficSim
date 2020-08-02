package estrada.visitor;

import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public interface IVisitor {

    void visitEstradaNormal(EstradaNormal estrada) throws Exception;

    void visitCruzamento(EstradaCruzamento estrada) throws Exception;

    void visitEstradaVazia(EstradaEmpty estrada) throws Exception;

    void visitEstradaCaminho(EstradaCaminho estrada) throws Exception;
}
