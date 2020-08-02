/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
