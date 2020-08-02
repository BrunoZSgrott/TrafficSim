/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada.visitor;

import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import java.util.ArrayList;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class CruzamentoVisitorConnect implements IVisitor {

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        estrada.setCaminho(new ArrayList<>());
        estrada.accept(new EstradaVisitorConnectCruzamento(estrada.getCaminho()));
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
    }

}
