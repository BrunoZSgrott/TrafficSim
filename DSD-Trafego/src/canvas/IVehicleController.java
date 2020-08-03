package canvas;

import java.awt.Point;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface IVehicleController {

    void onUpdateVehicle(Vehicle vehicle, Point point, Point newCell) throws Exception;
}
