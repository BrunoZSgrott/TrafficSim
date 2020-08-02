package mutex.factory;

public class MutexFactoryCreator {

    public static IMutexFactory create(MutexType threadControl) {
        if (threadControl == MutexType.MONITOR) {
            return new MonitorMutexFactory();
        } else if (threadControl == MutexType.SEMAFORO) {
            return new SemaphoreMutexFactory();
        } else if (threadControl == MutexType.MESSAGE) {
            return new MessageMutexFactory();
        }
        return null;
    }

}
