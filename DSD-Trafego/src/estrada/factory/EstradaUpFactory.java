/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaNormal;
import estrada.EstradaType;

/**
 *
 * @author Vinicius Catafesta
 */
public class EstradaUpFactory extends EstradaFactory {

    @Override
    public AbstractEstrada create() {
        EstradaNormal estrada = new EstradaNormal(EstradaType.ESTRADA_UP);

        return estrada;
    }

}
