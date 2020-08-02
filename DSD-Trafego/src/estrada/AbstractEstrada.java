/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import canvas.Display;
import estrada.strategy.IEstradaStrategy;
import canvas.IRenderable;
import canvas.MainController;
import estrada.strategy.factory.EstradaStrategyFactory;
import java.awt.Graphics;
import java.awt.Graphics2D;
import vehicle.Vehicle;
import java.awt.Point;
import java.awt.image.BufferedImage;
import mutex.factory.IMutex;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class AbstractEstrada implements IEstrada, IRenderable {

    private Point coordenada;
    private Vehicle vehicle;
    private EstradaType tipo;
    private boolean possuiAnterior;
    private boolean canRender;
    private IMutex controle;
    private IEstradaStrategy strategy;
    private EstradaCaminho reserva;
    private int count;
    private IMutex mutex;
    protected boolean ignoreMutex = false;
    public AbstractEstrada(EstradaType type) {
        this.tipo = type;
        this.canRender = true;
        count = 0;
    }

    @Override
    public void render(Graphics g) {
        if (count == MainController.FPS * 10) {
            count = 0;
            this.canRender = true;
        }
        Graphics2D g2 = (Graphics2D) g;
        if (getImage() != null && this.canRender) {
            g2.drawImage(getImage(), this.getPoint().y * Display.PIXELSIZE, this.getPoint().x * Display.PIXELSIZE, null);
            this.canRender = false;
        }
        count++;
    }

    public void canRender(boolean b) {
        this.canRender = b;
    }

    abstract BufferedImage getImage();

    @Override
    public EstradaType getType() {
        return tipo;
    }

    @Override
    public Point getPoint() {
        return coordenada;
    }

    public void setPoint(Point point) {
        coordenada = point;
    }

    public void setPossuiAnterior(boolean b) {
        this.possuiAnterior = b;
    }

    public boolean getPossuiAnterior() {
        return this.possuiAnterior;
    }

    public IEstradaStrategy getStrategy() {
        if (this.strategy == null) {
            this.strategy = new EstradaStrategyFactory().create(this);
        }
        return this.strategy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean possuiVehicle() {
        return vehicle != null;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.canRender = true;
    }

    EstradaCaminho getReserva() {
        return this.reserva;
    }

    void setReserva(EstradaCaminho caminho) {
        this.reserva = caminho;
    }

    boolean possuiReserva() {
        return this.reserva != null;
    }

    public IMutex getControle() {
        return controle;
    }

    public void setControle(IMutex mutex) {
        this.controle = mutex;
    }

    public IMutex getMutex() {
        return mutex;
    }

    public void setMutex(IMutex mutex) {
        this.mutex = mutex;
    }

    public boolean isIgnoreMutex() {
        return ignoreMutex;
    }

    public void setIgnoreMutex(boolean ignoreMutex) {
        this.ignoreMutex = ignoreMutex;
    }

    
}
