/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import canvas.Display;
import canvas.IRenderable;
import canvas.MainController;
import canvas.Spritesheet;
import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Catafesta
 */
public class EstradaNormal extends AbstractEstrada implements IRenderable {

    private IEstrada proxima;

    public EstradaNormal(EstradaType type) {
        super(type);
    }

    @Override
    public void accept(IVisitor visitor) {
        try {
            if (getMutex() != null && !isIgnoreMutex()) {
                getMutex().execute(() -> {
                    visitor.visitEstradaNormal(this);
                });
            } else {
                visitor.visitEstradaNormal(this);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstradaNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setProxima(IEstrada proximaEstrada) {
        this.proxima = proximaEstrada;
    }

    public IEstrada getProxima() {
        if (proxima != null) {
            return MainController.field.getEstrada(proxima.getPoint());
        }
        return null;
    }

    BufferedImage getImage() {
        return getStrategy().getImage();
    }
}
