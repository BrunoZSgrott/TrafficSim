package mutex.factory;

public class SemaphoreMutexFactory implements IMutexFactory {

    @Override
    public IMutex create() {
        return new SemaphoreMutex();
    }

}
