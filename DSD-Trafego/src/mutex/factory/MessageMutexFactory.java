/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
