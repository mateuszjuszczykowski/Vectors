import java.util.Scanner;
import java.util.ArrayList;

public class InputReader {
    private static Scanner scn = new Scanner(System.in);

    public static String getElement() {
        String element = scn.nextLine();
        return element;
    }

    public static ArrayList<Double> readData() {
        String data = getElement();
        String[] dataArr = data.split(" ");

        ArrayList<Double> finData = new ArrayList<Double>();
        for (String elem : dataArr) {
            if (elem.matches("([+-]\\d+)|(\\d+)"))
                finData.add(Double.parseDouble(elem.trim()));
        }
        return finData;
    }
}
