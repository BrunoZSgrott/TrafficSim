package estrada.factory;

import estrada.EstradaNormal;
import java.awt.Point;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaNormalMovementFactory {

    private static EstradaNormalMovementFactory instance;

    public static EstradaNormalMovementFactory getInstance() {
        if (instance == null) {
            instance = new EstradaNormalMovementFactory();
        }
        return instance;
    }

    public Point create(EstradaNormal estrada) {
        Point point = (Point) estrada.getPoint().clone();
        switch (estrada.getType()) {
            case ESTRADA_UP:
                point.translate(-1, 0);
                break;
            case ESTRADA_RIGHT:
                point.translate(0, 1);
                break;
            case ESTRADA_DOWN:
                point.translate(1, 0);
                break;
            case ESTRADA_LEFT:
                point.translate(0, -1);
                break;
        }
        return point;
    }
}
