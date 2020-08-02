/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mutex.factory.IMutex;
import vehicle.Vehicle;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaCaminho extends AbstractEstrada implements Cloneable {

    private List<IEstrada> estradas;
    private int atual;
    private Vehicle vehicle;

    public EstradaCaminho() {
        super(null);
    }

    @Override
    public void accept(IVisitor visitor) throws Exception {
        if (getMutex() != null) {
            getMutex().execute(() -> {
                visitor.visitEstradaCaminho(this);
            });
        } else {
            visitor.visitEstradaCaminho(this);
        }
    }

    @Override
    public EstradaType getType() {
        return null;
    }

    @Override
    public Point getPoint() {
        return null;
    }

    public EstradaCaminho clone() {
        try {
            return (EstradaCaminho) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(EstradaCaminho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<IEstrada> getEstradas() {
        return estradas;
    }

    public void setEstradas(List<IEstrada> cells) {
        this.estradas = cells;
    }

    public void adicionaEstrada(IEstrada cell) {
        estradas.add(cell);
    }

    public int getAtual() {
        return atual;
    }

    public void setAtual(int current) {
        this.atual = current;
    }

    public IMutex getMutex() {
        return null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public IEstrada getEstradaAtual() {
        return estradas.get(atual);
    }

    public IEstrada getProximaEstrada() {
        atual++;
        if (atual + 1 >= estradas.size()) {
            return estradas.get(atual);
        } else {
            return this;
        }
    }

    public boolean hasVehicle() {
        return vehicle != null;
    }

    public boolean tentarReserva() {
        EstradaCaminhoAdicionaReservaVisitor visitor = new EstradaCaminhoAdicionaReservaVisitor(this);
        int i = 0;
        for (IEstrada cell : estradas) {
            if (i >= atual) {
                try {
                    cell.accept(visitor);
                } catch (Exception e) {
                }

                if (!visitor.reservado()) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public void removerReserva() {
        EstradaCaminhoRemoveReservaVisitor visitor = new EstradaCaminhoRemoveReservaVisitor(this);
        for (IEstrada estrada : estradas) {
            try {
                estrada.accept(visitor);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (vehicle != null) {
            vehicle.render(g);
        }
    }

    @Override
    BufferedImage getImage() {
        return null;
    }

}
