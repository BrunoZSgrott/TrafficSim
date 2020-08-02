package estrada.factory;

import estrada.EstradaCruzamento;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaCruzamentoMovementFactory {

    private static EstradaCruzamentoMovementFactory instance;

    public static EstradaCruzamentoMovementFactory getInstance() {
        if (instance == null) {
            instance = new EstradaCruzamentoMovementFactory();
        }
        return instance;
    }

    public List<Point> create(EstradaCruzamento estrada) {
        List<Point> pontos = new ArrayList<>();
        switch (estrada.getType()) {
            case CROSS_UP:
                pontos.add(getPointUp(estrada.getPoint()));
                break;
            case CROSS_UP_LEFT:
                pontos.add(getPointUp(estrada.getPoint()));
                pontos.add(getPointLeft(estrada.getPoint()));
                break;
            case CROSS_UP_RIGHT:
                pontos.add(getPointUp(estrada.getPoint()));
                pontos.add(getPointRight(estrada.getPoint()));
                break;
            case CROSS_DOWN:
                pontos.add(getPointDown(estrada.getPoint()));
                break;
            case CROSS_DOWN_LEFT:
                pontos.add(getPointDown(estrada.getPoint()));
                pontos.add(getPointLeft(estrada.getPoint()));
                break;
            case CROSS_RIGHT:
                pontos.add(getPointRight(estrada.getPoint()));
                break;
            case CROSS_LEFT:
                pontos.add(getPointLeft(estrada.getPoint()));
                break;
            case CROSS_DOWN_RIGHT:
                pontos.add(getPointDown(estrada.getPoint()));
                pontos.add(getPointRight(estrada.getPoint()));
                break;
        }
        return pontos;
    }

    protected Point getPointUp(Point point) {
        Point newPoint = getNewPoint(point);
        newPoint.translate(-1, 0);
        return newPoint;
    }

    protected Point getPointLeft(Point point) {
        Point newPoint = getNewPoint(point);
        newPoint.translate(0, -1);
        return newPoint;
    }

    protected Point getPointDown(Point point) {
        Point newPoint = getNewPoint(point);
        newPoint.translate(1, 0);
        return newPoint;
    }

    protected Point getPointRight(Point point) {
        Point newPoint = getNewPoint(point);
        newPoint.translate(0, 1);
        return newPoint;
    }
    
    protected Point getNewPoint(Point point){
        return new Point(point.x, point.y);
    }
}
