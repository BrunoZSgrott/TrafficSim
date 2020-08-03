package estrada.strategy.factory;

import estrada.AbstractEstrada;
import estrada.strategy.IEstradaStrategy;
import estrada.EstradaType;
import estrada.strategy.*;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaStrategyFactory {

    public IEstradaStrategy create(AbstractEstrada estrada) {
        IEstradaStrategy strategy = null;
        switch (estrada.getType()) {
            case ESTRADA_UP:
                strategy = new EstradaUpStrategy(estrada);
                break;
            case CROSS_UP:
                strategy = new CruzamentoUpStrategy(estrada);
                break;
            case ESTRADA_DOWN:
                strategy = new EstradaDownStrategy(estrada);
                break;
            case CROSS_DOWN:
                strategy = new CruzamentoDownStrategy(estrada);
                break;
            case ESTRADA_LEFT:
                strategy = new EstradaLeftStrategy(estrada);
                break;
            case CROSS_LEFT:
                strategy = new CruzamentoLeftStrategy(estrada);
                break;
            case ESTRADA_RIGHT:
                strategy = new EstradaRightStrategy(estrada);
                break;
            case CROSS_RIGHT:
                strategy = new CruzamentoRightStrategy(estrada);
                break;
            case CROSS_DOWN_LEFT:
                strategy = new CruzamentoDownLeftStrategy(estrada);
                break;
            case CROSS_DOWN_RIGHT:
                strategy = new CruzamentoDownRightStrategy(estrada);
                break;
            case CROSS_UP_RIGHT:
                strategy = new CruzamentoUpRightStrategy(estrada);
                break;
            case CROSS_UP_LEFT:
                strategy = new CruzamentoUpLeftStrategy(estrada);
                break;
        }
        return strategy;
    }
}
