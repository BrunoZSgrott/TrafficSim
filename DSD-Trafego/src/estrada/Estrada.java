/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import estrada.strategy.EstradaStrategyDown;
import estrada.strategy.EstradaStrategyLeft;
import estrada.strategy.EstradaStrategyCrossingUp;
import estrada.strategy.EstradaStrategyCrossingRight;
import estrada.strategy.EstradaStrategyUp;
import estrada.strategy.EstradaStrategyCrossingLeftUp;
import estrada.strategy.EstradaStrategyEmpty;
import estrada.strategy.EstradaStrategyCrossingRightDown;
import estrada.strategy.EstradaStrategyCrossingUpRight;
import estrada.strategy.EstradaStrategyCrossingDownLeft;
import estrada.strategy.EstradaStrategyRight;
import estrada.strategy.EstradaStrategyCrossingDown;
import estrada.strategy.EstradaStrategy;
import estrada.strategy.EstradaStrategyCrossingLeft;
import canvas.IRenderable;
import canvas.Display;
import vehicle.Vehicle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Estrada implements IEstrada, IRenderable {

    private int linha;
    private int coluna;
    private int type;
    private Vehicle vehicle;

    private final EstradaStrategy strategy;

    public Estrada(int linha, int coluna, int type) {
        this.linha = linha;
        this.coluna = coluna;
        this.type = type;
        this.strategy = getStrategyFromType();
    }

    private EstradaStrategy getStrategyFromType() {
        EstradaStrategy strategy;
        switch (this.type) {
            case 1:
                strategy = new EstradaStrategyUp(this);
                break;
            case 2:
                strategy = new EstradaStrategyRight(this);
                break;
            case 3:
                strategy = new EstradaStrategyDown(this);
                break;
            case 4:
                strategy = new EstradaStrategyLeft(this);
                break;
            case 5:
                strategy = new EstradaStrategyCrossingUp(this);
                break;
            case 6:
                strategy = new EstradaStrategyCrossingRight(this);
                break;
            case 7:
                strategy = new EstradaStrategyCrossingDown(this);
                break;
            case 8:
                strategy = new EstradaStrategyCrossingLeft(this);
                break;
            case 9:
                strategy = new EstradaStrategyCrossingUpRight(this);
                break;
            case 10:
                strategy = new EstradaStrategyCrossingLeftUp(this);
                break;
            case 11:
                strategy = new EstradaStrategyCrossingDownLeft(this);
                break;
            case 12:
                strategy = new EstradaStrategyCrossingRightDown(this);
                break;
            case 0:
            default:
                strategy = new EstradaStrategyEmpty(this);
                break;
        }
        return strategy;
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(getImage(), this.coluna * Display.PIXELSIZE, this.linha * Display.PIXELSIZE, null);
        if (vehicle != null) {
            vehicle.render(g);
        }
    }

    protected BufferedImage getImage() {
        return this.strategy.getImage();
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

}
