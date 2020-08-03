package mutex.factory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MessageMutex implements IMutex {

//    private ServerSocket server;

    public MessageMutex() {
//        try {
//            server = new ServerSocket(56000);
//        } catch (IOException ex) {
//            Logger.getLogger(MessageMutex.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void execute(ICommand command) throws Exception {
//        Socket socket = server.accept();
        command.execute();
//        socket.close();
    }

}
