/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada.factory;

import estrada.AbstractEstrada;
import estrada.EstradaType;
import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author Vinicius Catafesta
 */
public class EstradaFactory {

    private static EstradaFactory instance;
    private HashMap<EstradaType, IEstradaFactory> fabricas;
    public static synchronized EstradaFactory getInstance() {
        if (instance == null) {
            instance = new EstradaFactory();
        }
        return instance;
    }

    private EstradaFactory() {
        fabricas = new HashMap<>();
        fabricas.put(EstradaType.ESTRADA_EMPTY, new EstradaEmptyFactory());
        fabricas.put(EstradaType.ESTRADA_UP, new EstradaUpFactory());
        fabricas.put(EstradaType.ESTRADA_RIGHT, new EstradaRightFactory());
        fabricas.put(EstradaType.ESTRADA_DOWN, new EstradaDownFactory());
        fabricas.put(EstradaType.ESTRADA_LEFT, new EstradaLeftFactory());
        fabricas.put(EstradaType.CROSS_UP, new CruzamentoUpFactory());
        fabricas.put(EstradaType.CROSS_RIGHT, new CruzamentoRightFactory());
        fabricas.put(EstradaType.CROSS_DOWN, new CruzamentoDownFactory());
        fabricas.put(EstradaType.CROSS_LEFT, new CruzamentoLeftFactory());
        fabricas.put(EstradaType.CROSS_UP_RIGHT, new CruzamentoUpRightFactory());
        fabricas.put(EstradaType.CROSS_UP_LEFT, new CruzamentoUpLeftFactory());
        fabricas.put(EstradaType.CROSS_DOWN_RIGHT, new CruzamentoDownRightFactory());
        fabricas.put(EstradaType.CROSS_DOWN_LEFT, new CruzamentoDownLeftFactory());
    }

    public AbstractEstrada create(EstradaType tipo, Point point) {
        try {
            return fabricas.get(tipo).create(point);
        } catch (Exception ex) {
            return null;
        }
    }

}
