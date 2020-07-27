/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import vehicle.strategy.VehicleStrategyDown;
import vehicle.strategy.VehicleStrategy;
import canvas.IRenderable;
import canvas.Display;
import estrada.AbstractEstrada;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Vehicle implements IRenderable {

    private AbstractEstrada estrada;
    private VehicleStrategy strategy;

    public Vehicle() {
        this.strategy = new VehicleStrategyDown(this);
    }

    @Override
    public void render(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.drawImage(getImage(), estrada.getColuna() * Display.PIXELSIZE, estrada.getLinha() * Display.PIXELSIZE, null);
    }

    private BufferedImage getImage() {
        return this.strategy.getImage();
    }

    public void tick(int currentFrame) {
        move();
    }

    private void move() {
//        this.strategy.move(this.estrada);
    }

}
