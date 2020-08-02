package mutex.factory;

public class MonitorMutexFactory implements IMutexFactory {

    @Override
    public IMutex create() {
        return new MonitorMutex();
    }

}
