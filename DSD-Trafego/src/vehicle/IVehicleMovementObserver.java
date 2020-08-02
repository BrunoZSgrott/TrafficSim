package vehicle;

import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public interface IVehicleMovementObserver {

    void updateVehicle(Vehicle vehicle, Point point, Point newCell);

}
