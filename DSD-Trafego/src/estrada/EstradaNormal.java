/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import canvas.Spritesheet;
import estrada.visitor.IVisitor;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Catafesta
 */
public class EstradaNormal extends AbstractEstrada {

    private AbstractEstrada proxima;

    public EstradaNormal(EstradaType type) {
        super(type);
    }

    @Override
    public void accept(IVisitor visitor) {
        try {
            visitor.visitEstradaNormal(this);
        } catch (Exception ex) {
            Logger.getLogger(EstradaNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setProxima(AbstractEstrada proximaEstrada) {
        this.proxima = proximaEstrada;
    }

    @Override
    BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(1, 1);
    }

}
