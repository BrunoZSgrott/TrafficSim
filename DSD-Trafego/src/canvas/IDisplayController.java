/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

/**
 *
 * @author Bruno Zilli Sgrott
 */
interface IDisplayController extends Subject {

    void start();

    void run();

    void pause();

    public void end();

    public void endAndWait();
}
