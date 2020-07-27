/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import canvas.Spritesheet;
import estrada.visitor.IVisitor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaCruzamento extends AbstractEstrada {

    private List<AbstractEstrada> proximas;

    public EstradaCruzamento(EstradaType type) {
        super(type);
        proximas = new ArrayList<>();
    }

    public void accept(IVisitor visitor) {
        try {
            visitor.visitCruzamento(this);
        } catch (Exception ex) {
            Logger.getLogger(EstradaCruzamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setProximas(List<AbstractEstrada> estrada) {
        this.proximas = estrada;
    }

    @Override
    BufferedImage getImage() {
        return Spritesheet.getInstance().getSprite(0, 1);
    }

}
