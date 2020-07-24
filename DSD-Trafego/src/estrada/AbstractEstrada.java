/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import estrada.strategy.*;
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

    private Point point;
    private Vehicle vehicle;
    private EstradaType tipo;
    private boolean previous;

    private Point coordenada;
    private int type;

    public AbstractEstrada(EstradaType type) {
        this.tipo = type;
    }

    public AbstractEstrada(int type) {
        this.type = type;
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
//        g2.drawImage(getImage(), this.coluna * Display.PIXELSIZE, this.linha * Display.PIXELSIZE, null);
        if (vehicle != null) {
            vehicle.render(g);
        }
    }

    @Override
    public EstradaType getType() {
        return tipo;
    }

    @Override
    public Point getPoint() {
        return coordenada;
    }

    @Override
    public void accept(IEstradaVisitor visitor) {

    }

}
