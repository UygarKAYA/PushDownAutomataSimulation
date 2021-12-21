package InputOutput;

import java.io.*;

public class OutputFile {
    private FileWriter fileWriter;

    public void WriteFile(String routeValidation) {
        try {
            fileWriter = new FileWriter("../OutputFile.txt");
            fileWriter.write(routeValidation);
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("File is not written");
        }
    }
}
