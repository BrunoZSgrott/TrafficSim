package estrada.visitor;

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

    void visitEStradaVazia(EstradaEmpty estrada) throws Exception;
}
