package canvas;

import canvas.Display;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import roadMap.RoadMap;
import roadMap.RoadMapFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno Zilli Sgrott
 */
class ControllerConfig {

    private List<ConfigView> observados;
    private RoadMap roadMap;

    public ControllerConfig() {
        observados = new ArrayList<>();
    }

    public void addObservador(ConfigView obs) {
        observados.add(obs);
    }

    public void removerObservador(ConfigView obs) {
        observados.remove(obs);
    }

    void start(String veiculos, String interval) {
        new Display(new Configuracao(this.roadMap, Integer.parseInt(veiculos), Integer.parseInt(interval))).start();
    }

    void setRoadMapData(File selectedFile) throws FileNotFoundException {
        RoadMapFactory RoadMapFactory = new RoadMapFactory();
        this.roadMap = RoadMapFactory.create(new BufferedReader(new FileReader(selectedFile)));
        notificaCamposLivres(roadMap.getCount());
    }
    
    void notificaCamposLivres(int count){
        observados.forEach((n)-> n.notificaEstradasLivres(count));
    }

}
