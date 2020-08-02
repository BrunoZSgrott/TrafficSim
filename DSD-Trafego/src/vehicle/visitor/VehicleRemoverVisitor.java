package vehicle.visitor;

import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import estrada.visitor.IVisitor;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class VehicleRemoverVisitor implements IVisitor {

    private Vehicle vehicle;

    public VehicleRemoverVisitor(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        if (estrada.getVehicle() == vehicle) {
            estrada.setVehicle(null);
        }
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        if (estrada.getVehicle() == vehicle) {
            estrada.setVehicle(null);
        }
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
        if (estrada.getVehicle() == vehicle) {
            estrada.setVehicle(null);
            estrada.removerReserva();
            estrada.setAtual(0);
        }
    }

}
