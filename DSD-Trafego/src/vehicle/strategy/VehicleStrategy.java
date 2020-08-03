package vehicle.strategy;

import estrada.AbstractEstrada;
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

    public abstract void move(AbstractEstrada estrada);
}
