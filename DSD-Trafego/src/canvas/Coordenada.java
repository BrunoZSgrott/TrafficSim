package canvas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Coordenada{

    public int linha;
    public int coluna;

    public Coordenada(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public int hashCode() {
        return linha * 1000 + coluna;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Coordenada c = (Coordenada) object;
        if (this.hashCode() == c.hashCode()) {
            return true;
        }
        return ((this.linha == c.linha) && (this.coluna == c.coluna));
    }

    public void render(Graphics g, BufferedImage image){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, this.coluna*32, this.linha*32, null);        
    }
    
    public Coordenada move(String s){
        switch(s){
            case "u":
                linha--;
                break;
            case "d":
                linha++;
                break;
            case "r":
                coluna++;
                break;
            case "l":
                coluna--;
                break;
            default:
                break;
        }
        return this;
    }
    
}
