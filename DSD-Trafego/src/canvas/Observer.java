/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

import roadMap.RoadMapFactory;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface Observer {

    public RoadMapFactory getLevel();

    public void setSize(int x, int y);

    public void init();

    public void render();

    public void addRenderable(IRenderable render);
}
