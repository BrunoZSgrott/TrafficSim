package mutex.factory;

/**
 *
 * @author Bruno Zilli Sgrott
 */
public enum MutexType {
    SEMAFORO(1, "Semáforo"),
    MONITOR(2, "Monitor"),
    MESSAGE(3, "Mensagens");

    public static MutexType getFromValue(int mutex) {
        for (MutexType type : values()) {
            if (type.codigo == mutex + 1) {
                return type;
            }
        }
        return null;
    }

    private String name;
    private int codigo;

    private MutexType(int codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }
}
