package canvas;

import mutex.factory.MutexType;
import roadMap.RoadMap;

/**
 *
 * @author Bruno Zilli Sgrott
 */
class Configuracao {

    private final RoadMap roadMap;
    private int numCarros;
    private int spawnOffset;
    private MutexType ctrl;

    public Configuracao(RoadMap roadMap, int numCarros, int interval, int mutex) {
        this.numCarros = numCarros;
        this.spawnOffset = interval;
        this.roadMap = roadMap;
        this.ctrl = MutexType.getFromValue(mutex);
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

    public MutexType getThreadControl() {
        return ctrl;
    }
}
