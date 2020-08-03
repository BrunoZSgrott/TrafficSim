package estrada;

/**
 *
 * @author Vinicius Catafesta
 */
public enum EstradaType {

    ESTRADA_EMPTY(0, "Nada"),
    ESTRADA_UP(1, "Cima"),
    ESTRADA_RIGHT(2, "Direita"),
    ESTRADA_DOWN(3, "Baixo"),
    ESTRADA_LEFT(4, "Esquerda"),
    CROSS_UP(5, "Cruzamento para Cima"),
    CROSS_RIGHT(6, "Cruzamento para Direita"),
    CROSS_DOWN(7, "Cruazamento para Baixo"),
    CROSS_LEFT(8, "Cruzamento para Esquerda"),
    CROSS_UP_RIGHT(9, "Cruzamento para Cima e Direita"),
    CROSS_UP_LEFT(10, "Cruzamento para Cima e Esquerda"),
    CROSS_DOWN_RIGHT(11, "Cruzamento para Baixo e Direita"),
    CROSS_DOWN_LEFT(12, "Cruzamento para Baixo e Esquerda");

    private String name;
    private int codigo;

    private EstradaType(int codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public static EstradaType getTypeFromInt(int i) {
        for (EstradaType type : values()) {
            if (type.getCodigo() == i) {
                return type;
            }
        }
        return null;
    }
}
