/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MainController implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObservador(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removerObservador(Observer obs) {
        observers.remove(obs);
    }

}
