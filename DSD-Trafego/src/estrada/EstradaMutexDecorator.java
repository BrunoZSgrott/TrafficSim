package estrada;

import estrada.visitor.IVisitor;
import mutex.factory.ICommand;
import mutex.factory.IMutex;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class EstradaMutexDecorator extends AbstractEstradaDecorator {

    private final IMutex mutex;

    public EstradaMutexDecorator(IEstrada estrada, IMutex mutex) {
        super(estrada);
        this.mutex = mutex;
    }

    @Override
    public void accept(IVisitor visitor) throws Exception {
        mutex.execute(new ICommand() {
            @Override
            public void execute() throws Exception {
                EstradaMutexDecorator.super.accept(visitor);
            }
        });
    }

    public IMutex getMutex() {
        return mutex;
    }
}
