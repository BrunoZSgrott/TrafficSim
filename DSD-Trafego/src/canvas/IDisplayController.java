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
