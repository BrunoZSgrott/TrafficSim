/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.strategy;

import canvas.Spritesheet;
import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class VehicleStrategyRight extends VehicleStrategy {

    public VehicleStrategyRight(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(2, 0);
    }

    @Override
    public void move(AbstractEstrada estrada) {
    }
}
