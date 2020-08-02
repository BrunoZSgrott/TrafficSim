/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import roadMap.RoadMap;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class Configuracao {

    private final RoadMap roadMap;
    private int numCarros;
    private int spawnOffset;

    public Configuracao(RoadMap roadMap, int numCarros, int interval) {
        this.numCarros = numCarros;
        this.spawnOffset = interval;
        this.roadMap = roadMap;
    }

    public int getNumCarros() {
        return numCarros;
    }

    public int getSpawnOffset() {
        return spawnOffset;
    }

    public int calcOffsetAsFrames() {
        double math = (new Integer(1000).doubleValue() / spawnOffset);
        return (int) Math.floor(MainController.FPS / math);
    }

    public RoadMap getRoadMap() {
        return roadMap;
    }

}
