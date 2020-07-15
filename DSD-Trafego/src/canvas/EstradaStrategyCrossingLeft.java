/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaStrategyCrossingLeft extends EstradaStrategy {

    public EstradaStrategyCrossingLeft(Estrada estrada) {
        super(estrada);
    }

    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(2, 1);
    }
    
}
