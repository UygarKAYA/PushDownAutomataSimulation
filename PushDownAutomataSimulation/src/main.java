import InputOutput.InputFile;

public class main {
    public static void main(String[] args) {
        String filePath = "../InputFile.txt";

        InputFile inputFile = new InputFile();
        inputFile.ReadFile(filePath);
    }
}
