package mutex.factory;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MessageMutexFactory implements IMutexFactory {

    public MessageMutexFactory() {
    }

    @Override
    public IMutex create() {
        return new MessageMutex();
    }

}
