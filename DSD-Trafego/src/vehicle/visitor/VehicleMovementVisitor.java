package vehicle.visitor;

import estrada.AbstractEstrada;
import estrada.EstradaCaminho;
import estrada.EstradaCruzamento;
import estrada.EstradaEmpty;
import estrada.EstradaNormal;
import estrada.IEstrada;
import estrada.visitor.IVisitor;
import java.util.List;
import java.util.Random;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class VehicleMovementVisitor implements IVisitor {

    private Vehicle vehicle;
    private Random random;
    private boolean defineTrajetoriaCruzamento;

    public VehicleMovementVisitor(Vehicle vehicle) {
        this(vehicle, true);
    }

    public VehicleMovementVisitor(Vehicle vehicle, boolean defineTrajetoriaCruzamento) {
        this.vehicle = vehicle;
        this.random = new Random();
        this.defineTrajetoriaCruzamento = defineTrajetoriaCruzamento;
    }

    @Override
    public void visitEstradaNormal(EstradaNormal estrada) throws Exception {
        if (estrada.possuiVehicle() && estrada.getVehicle() != vehicle) {
            collision(vehicle, estrada.getVehicle());
        }
        IEstrada estradaAnterior = vehicle.getEstrada();

        estrada.setVehicle(vehicle);
        vehicle.setEstrada(estrada);
        vehicle.setProximaEstrada(estrada.getProxima());

        if (estradaAnterior != null) {
            ((AbstractEstrada) estradaAnterior).setIgnoreMutex(true);
            estradaAnterior.accept(new VehicleRemoverVisitor(vehicle));
            ((AbstractEstrada) estradaAnterior).setIgnoreMutex(false);
        }
    }

    @Override
    public void visitCruzamento(EstradaCruzamento estrada) throws Exception {
        if (defineTrajetoriaCruzamento) {
            List<IEstrada> caminhos = estrada.getProximas();
            IEstrada caminho = caminhos.get(random.nextInt(caminhos.size()));
            vehicle.setProximaEstrada(caminho);
        } else {
            if (estrada.possuiVehicle() && estrada.getVehicle() != vehicle) {
                collision(vehicle, estrada.getVehicle());
            }
            IEstrada estradaAnterior = vehicle.getEstrada();

            estrada.setVehicle(vehicle);
            vehicle.setEstrada(estrada);

            if (estradaAnterior != null) {
                ((AbstractEstrada) estradaAnterior).setIgnoreMutex(true);
                estradaAnterior.accept(new VehicleRemoverVisitor(vehicle));
                ((AbstractEstrada) estradaAnterior).setIgnoreMutex(false);
            }
        }
    }

    @Override
    public void visitEstradaVazia(EstradaEmpty estrada) throws Exception {
    }

    @Override
    public void visitEstradaCaminho(EstradaCaminho estrada) throws Exception {
        if (estrada.possuiVehicle() && estrada.getVehicle() != vehicle) {
            collision(vehicle, estrada.getVehicle());
        }
        boolean reserved = estrada.tentarReserva();
        if (reserved) {
            estrada.setVehicle(vehicle);
            IEstrada estradaAtual = estrada.getEstradaAtual();

            estradaAtual.accept(new VehicleMovementVisitor(vehicle, false));
            vehicle.setProximaEstrada(estrada.getProximaEstrada());

            if (vehicle.getProximaEstrada() != estrada) {
                ((AbstractEstrada) estrada).setIgnoreMutex(true);
                estrada.accept(new VehicleRemoverVisitor(vehicle));
                ((AbstractEstrada) estrada).setIgnoreMutex(true);
            }
        } else {
            estrada.removerReserva();
        }
    }

    private void collision(Vehicle carro, Vehicle carroEstrada) throws Exception {
//        throw new Exception(carro.getId() + " tentou ocupar a estrada do veiculo " + carroEstrada.getId());
    }
}
