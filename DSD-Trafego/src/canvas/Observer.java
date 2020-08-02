package canvas;

import roadMap.RoadMapFactory;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface Observer extends Runnable{

    public void setSize(int x, int y);

    public void init();

    public void render();

    public void addRenderable(IRenderable render);
}
