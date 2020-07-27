package canvas;

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
        Point pointUp, pointDown, pointLeft, pointRight;
        switch (estrada.getType()) {
            case CROSS_UP:
                pointUp = (Point) estrada.getPoint().clone();

                break;
            case CROSS_UP_LEFT:
                pointUp = (Point) estrada.getPoint().clone();
                pointUp.translate(0, -1);
                pointLeft = (Point) estrada.getPoint().clone();
                pointLeft.translate(-1, 0);

                break;
            case CROSS_UP_RIGHT:
                pointUp = (Point) estrada.getPoint().clone();
                pointRight = (Point) estrada.getPoint().clone();

                break;
            case CROSS_DOWN:
                pointDown = (Point) estrada.getPoint().clone();

                break;
            case CROSS_DOWN_LEFT:
                pointDown = (Point) estrada.getPoint().clone();
                pointLeft = (Point) estrada.getPoint().clone();

                break;
            case CROSS_DOWN_RIGHT:
                pointDown = (Point) estrada.getPoint().clone();
                pointRight = (Point) estrada.getPoint().clone();

                break;
        }
        return pontos;
    }
}
