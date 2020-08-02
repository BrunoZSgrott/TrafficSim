package mutex.factory;

import java.util.concurrent.Semaphore;

public class SemaphoreMutex implements IMutex {
    
    private Semaphore mutex;
    
    public SemaphoreMutex() {
        this.mutex = new Semaphore(1);
    }

    @Override
    public void execute(ICommand command) throws Exception {
        try {
            mutex.acquire();
            command.execute();
        } catch (InterruptedException e) {  
            throw e;
        } finally {  
            mutex.release();
        }
    }
}
