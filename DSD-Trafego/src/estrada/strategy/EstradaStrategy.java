/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada.strategy;

import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class EstradaStrategy implements InterfaceEstradaStrategy {

    private AbstractEstrada estrada;

    public EstradaStrategy(AbstractEstrada estrada) {
        this.estrada = estrada;
    }

}
