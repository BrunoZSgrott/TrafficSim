package vehicle.strategy;

import canvas.Spritesheet;
import estrada.AbstractEstrada;
import java.awt.image.BufferedImage;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class VehicleStrategyDown extends VehicleStrategy {

    public VehicleStrategyDown(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(1, 0);
    }

    @Override
    public void move(AbstractEstrada estrada) {
    }

}
