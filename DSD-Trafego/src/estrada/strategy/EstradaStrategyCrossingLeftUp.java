/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada.strategy;

import estrada.Estrada;
import canvas.Spritesheet;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaStrategyCrossingLeftUp extends EstradaStrategy {

    public EstradaStrategyCrossingLeftUp(Estrada estrada) {
        super(estrada);
    }

    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(0, 2);
    }

}
