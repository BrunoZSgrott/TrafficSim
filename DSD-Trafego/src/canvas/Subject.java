package canvas;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public interface Subject {

    void addObservador(Observer obs);

    void removerObservador(Observer obs);
}
