package mutex.factory;

public interface IMutex {

    void execute(ICommand command) throws Exception;

}
