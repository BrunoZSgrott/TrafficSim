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

    void start(String veiculos, String interval, int Type) {
        new Display(new Configuracao(this.roadMap, Integer.parseInt(veiculos), Integer.parseInt(interval), Type)).start();
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
