/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import canvas.Display;
import vehicle.Vehicle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public abstract class AbstractEstrada implements IEstrada {

    private Vehicle vehicle;
    private EstradaType tipo;
    private boolean possuiAnterior;
    private Point coordenada;

    public AbstractEstrada(EstradaType type) {
        this.tipo = type;
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(getImage(), this.getPoint().y * Display.PIXELSIZE, this.getPoint().x * Display.PIXELSIZE, null);
        if (vehicle != null) {
            vehicle.render(g);
        }
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

}
