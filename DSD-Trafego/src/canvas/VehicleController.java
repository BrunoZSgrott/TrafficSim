package canvas;

import java.awt.Point;
import java.util.HashMap;
import mutex.factory.ICommand;
import mutex.factory.IMutex;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class VehicleController implements IVehicleController {

    private HashMap<Point, Vehicle> points;
    private IMutex renderMutex;

    public VehicleController(IMutex mutex) {
        renderMutex = mutex;
        points = new HashMap<>();
    }

    @Override
    public void onUpdateVehicle(Vehicle vehicle, Point point, Point newCell) throws Exception {
        renderMutex.execute(() -> {
            if (point != null) {
                points.remove(point);
            }
            if (newCell != null) {
                points.put(newCell, vehicle);
            }
        });
    }

}
