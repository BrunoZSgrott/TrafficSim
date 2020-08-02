/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import canvas.Display;
import canvas.IRenderable;
import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaCruzamento extends AbstractEstrada implements IRenderable {

    private List<IEstrada> proximas;
    private List<IEstrada> caminho;

    public EstradaCruzamento(EstradaType type) {
        super(type);
        proximas = new ArrayList<>();
    }

    public void accept(IVisitor visitor) {
        try {
            if (getMutex() != null) {
                getMutex().execute(() -> {
                    visitor.visitCruzamento(this);
                });
            } else {
                visitor.visitCruzamento(this);
            }
        } catch (Exception ex) {
            Logger.getLogger(EstradaCruzamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setProximas(List<IEstrada> estrada) {
        this.proximas = estrada;
    }

    public List<IEstrada> getProximas() {
        return proximas;
    }

    public List<IEstrada> getCaminho() {
        return caminho;
    }

    public void setCaminho(List<IEstrada> caminho) {
        this.caminho = caminho;
    }

    BufferedImage getImage() {
        return this.getStrategy().getImage();
    }

}
