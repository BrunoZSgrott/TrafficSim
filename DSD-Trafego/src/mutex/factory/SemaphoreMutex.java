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
            System.out.println("Entrou");
            command.execute();
        } catch (InterruptedException e) {  
            throw e;
        } finally {  
            System.out.println("Liberou");
            mutex.release();
        }
    }
}
