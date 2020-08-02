/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrada;

import java.net.Socket;
import mutex.factory.ICommand;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public class MessageCommand implements ICommand {

    @Override
    public void execute() throws Exception {
        new Socket("0.0.0.0", 56000);

    }

}
