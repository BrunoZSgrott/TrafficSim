/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.strategy;

import estrada.Estrada;
import java.awt.image.BufferedImage;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class VehicleStrategy {

    private Vehicle vehicle;

    public VehicleStrategy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract BufferedImage getImage();

    public abstract void move(Estrada estrada);
}
