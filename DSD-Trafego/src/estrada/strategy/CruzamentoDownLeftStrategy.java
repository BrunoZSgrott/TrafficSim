/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada.strategy;

import canvas.Spritesheet;
import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class CruzamentoDownLeftStrategy implements IEstradaStrategy {

    private AbstractEstrada estrada;

    public CruzamentoDownLeftStrategy(AbstractEstrada estrada) {
        this.estrada = estrada;
    }

    @Override
    public AbstractEstrada getEstrada() {
        return this.estrada;
    }
    
    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSpriteCruzamentoDownLeft();
    }
}
