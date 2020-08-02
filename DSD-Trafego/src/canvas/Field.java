package canvas;

import estrada.IEstrada;
import estrada.visitor.IVisitor;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class Field implements IVisitable, IRenderable {

    private int linha;
    private int coluna;
    private Random random;

    HashMap<Point, IEstrada> list;
    List<Point> entradas;
    List<Point> saidas;

    public Field(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        list = new HashMap<>();
        entradas = new ArrayList<>();
        saidas = new ArrayList<>();
        random = new Random();
    }

    public void add(IEstrada estrada) {
        list.put(estrada.getPoint(), estrada);
    }

    public void accept(IVisitor visitor) {
        list.forEach(
            (point, estrada) -> {
                try {
                    estrada.accept(visitor);
                } catch (Exception ex) {
                }
            }
        );
    }

    public IEstrada getEstrada(Point point) throws ArrayIndexOutOfBoundsException, NullPointerException {
        return list.get(point);
    }

    public List<IEstrada> getEstrada(List<Point> points) throws ArrayIndexOutOfBoundsException, NullPointerException {
        List<IEstrada> find = new ArrayList<>();
        for (Point point : points) {
            find.add(getEstrada(point));
        }
        return find;
    }

    @Override
    public void render(Graphics g) {
        list.forEach((point, estrada) -> {
            estrada.render(g);
        });
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void addEntrada(IEstrada estrada) {
        entradas.add(estrada.getPoint());
    }

    public void addSaida(IEstrada estrada) {
        saidas.add(estrada.getPoint());
    }

    public IEstrada getRandomEntrada() {
        return list.get(entradas.get(random.nextInt((entradas.size()))));
    }

    void setEstrada(IEstrada estrada, Point point) {
        list.put(point, estrada);
    }

}
