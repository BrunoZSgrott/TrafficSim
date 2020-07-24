/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import canvas.IRenderable;
import estrada.AbstractEstrada;
import java.awt.Graphics;

/**
 *
 * @author Vinicius Catafesta
 */
public class Vehicle implements IRenderable {

    private AbstractEstrada estrada;

    public Vehicle() {
    }

    @Override
    public void render(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.drawImage(getImage(), estrada.getColuna() * Display.PIXELSIZE, estrada.getLinha() * Display.PIXELSIZE, null);
    }

    public void tick(int currentFrame) {
    }

}
