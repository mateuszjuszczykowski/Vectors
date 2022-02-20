import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void write(String filename, MyVector data) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(data.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}