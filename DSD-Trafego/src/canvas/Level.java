package canvas;

import canvas.Coordenada;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @since 14/03/2019
 * @version
 * @author Bruno Zilli Sgrott
 */
public class Level {

    private BufferedReader reader;
//    private ArrayList<String> currentLine;

    private HashSet<Estrada> estradas;

    private int numeroLinhas;
    private int numeroColunas;

    public boolean finished;

    public Level(int level) {
        String pathname = "src/res/malha-exemplo-".concat(String.valueOf(level)).concat(".txt");
        try {
            reader = new BufferedReader(new FileReader(pathname));
            estradas = new HashSet<>();
            this.montarNivel();
        } catch (Exception e) {
            System.out.println(pathname + "\n Não reconhecido como arquivo");
        }
    }

    public void tick(int hChoice) {
    }

    protected void montarNivel() {
        try {
            if (reader.ready()) {
                numeroLinhas = Integer.parseInt(reader.readLine().trim());
                numeroColunas = Integer.parseInt(reader.readLine().trim());
                int i = 0;
                int j = 0;
                while (reader.ready()) {
                    String currentLine = reader.readLine();
                    String type = "";
                    for (char c : currentLine.toCharArray()) {
                        if (c == '\t') {
                            estradas.add(new Estrada(i, j, Integer.parseInt(type)));
                            j++;
                            type = "";
                            continue;
                        } else {
                            type += c;
                        }
                    }
                    type = "";
                    j = 0;
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler a linha");
        }

    }

    public void render(Graphics g) {
        if (estradas.size() > 0) {
            estradas.forEach((estrada) -> {
                estrada.render(g);
            });
        }
    }

    public void tick() {
    }

    public int getLinhas() {
        return numeroLinhas;
    }

    public int getColunas() {
        return numeroColunas;
    }
}
