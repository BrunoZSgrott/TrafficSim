/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.visitor;

import estrada.EstradaType;
import vehicle.Vehicle;
import vehicle.strategy.VehicleStrategy;
import vehicle.strategy.VehicleStrategyDown;
import vehicle.strategy.VehicleStrategyLeft;
import vehicle.strategy.VehicleStrategyRight;
import vehicle.strategy.VehicleStrategyUp;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class VehicleStrategyFactory {

    public VehicleStrategy create(EstradaType type, Vehicle vehicle) {
        VehicleStrategy strategy = null;
        switch (type) {
            case ESTRADA_UP:
            case CROSS_UP:
            case CROSS_UP_LEFT:
            case CROSS_UP_RIGHT:
                strategy = new VehicleStrategyUp(vehicle);
                break;
            case ESTRADA_LEFT:
            case CROSS_LEFT:
                strategy = new VehicleStrategyLeft(vehicle);
                break;
            case CROSS_RIGHT:
            case ESTRADA_RIGHT:
                strategy = new VehicleStrategyRight(vehicle);
                break;
            case ESTRADA_DOWN:
                strategy = new VehicleStrategyDown(vehicle);
                break;
            case CROSS_DOWN:
            case CROSS_DOWN_LEFT:
            case CROSS_DOWN_RIGHT:
                strategy = new VehicleStrategyDown(vehicle);
                break;
        }
        return strategy;
    }
}
