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
enum MutexType {
    SEMAFORO(1, "Semáforo"),
    MONITOR(2, "Monitor"),
    MESSAGE(3, "Mensagens");

    private String name;
    private int codigo;

    private MutexType(int codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }
}
