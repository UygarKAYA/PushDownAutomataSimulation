package InputOutput;

import java.util.*;
import java.io.*;

import Algorithm.SeparateData;

public class InputFile {
    private File file;
    private Scanner scanner;
    private ArrayList<String> arrayList;

    public void ReadFile(String filePath) {
        try {
            file = new File(filePath);
            scanner = new Scanner(file);
            arrayList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                arrayList.add(data);
            }

            SeparateData separateData = new SeparateData();
            separateData.SplitData(arrayList);

        } catch (FileNotFoundException exception) {
            System.out.println("File is not found");
        }
    }
}
