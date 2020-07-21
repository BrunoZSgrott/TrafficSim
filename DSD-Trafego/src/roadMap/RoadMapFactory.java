package roadMap;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @since 14/03/2019
 * @version
 * @author Bruno Zilli Sgrott
 */
public class RoadMapFactory {

    private String initialFilename = "src/resources/malha-exemplo-";
    private String format = ".txt";

    public RoadMap create(BufferedReader reader) {
        RoadMap roadMap = new RoadMap(0, 0);
        try {
            if (reader.ready()) {
                roadMap = new RoadMap(Integer.parseInt(reader.readLine().trim()), Integer.parseInt(reader.readLine().trim()));
                int i = 0;
                int j = 0;
                while (reader.ready()) {
                    String currentLine = reader.readLine();
                    String type = "";
                    for (char c : currentLine.toCharArray()) {
                        if (c == '\t') {
                            roadMap.add(i, j, Integer.parseInt(type));
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
        } catch (IOException e) {
            System.out.println("Erro ao ler a linha");
        } catch (Exception e) {
            throw e;
        }
        return roadMap;
    }

    public String getPathForLevel(int i) {
        return initialFilename.concat(i + "").concat(format);
    }

}
