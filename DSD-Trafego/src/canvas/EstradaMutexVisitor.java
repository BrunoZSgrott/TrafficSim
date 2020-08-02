/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaMutexDecorator;
import estrada.EstradaNormal;
import estrada.IEstrada;
import estrada.visitor.IVisitor;
import java.util.ArrayList;
import java.util.List;
import mutex.factory.IMutexFactory;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaMutexVisitor implements IVisitor {

    private Field field;
    private IMutexFactory factory;

    public EstradaMutexVisitor(Field field, IMutexFactory factory) {
        this.field = field;
        this.factory = factory;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        estrada.setMutex(factory.create());
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        estrada.setMutex(factory.create());

        for (IEstrada caminho : estrada.getCaminho()) {
            caminho.setMutex(factory.create());
        }
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
        estrada.setMutex(factory.create());
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
        estrada.setMutex(factory.create());
    }

}
