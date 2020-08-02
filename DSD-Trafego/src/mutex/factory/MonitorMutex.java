package mutex.factory;

public class MonitorMutex implements IMutex {

    @Override
    public synchronized void execute(ICommand command) throws Exception {
        command.execute();
    }

}
