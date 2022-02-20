import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static final int numberOfVectors = 3;
    private static ArrayList<MyVector> vectors = new ArrayList<MyVector>();
    private static String filename = "answer.txt";

    public static void populateVectors() {
        clearArray();
        System.out.println("Enter vector values separated by spaces, vectors by enter");
        for (int i = 0; i < numberOfVectors; i++) {
            MyVector tempVec = new MyVector(InputReader.readData());
            vectors.add(tempVec);
        }
    }

    public static void addVectors() {
        // if size matches add, save to file
        try {
            FileHandler.write(filename, sum());
        } catch (DifferentVectorsLengthException e) {
            System.out.println(e);
            System.out.println("you entered " + e.sum() + " values in total\n");
            // System.out.println("you entered " + e.val() + "\n");
            e.val();
            populateVectors();
            addVectors();
        }

    }

    private static MyVector sum()
            throws DifferentVectorsLengthException {
        if (!checkVectorSize())
            throw new DifferentVectorsLengthException("Make sure vectors are the same length\n", vectors);
        ArrayList<Double> sum = new ArrayList<Double>();
        for (int i = 0; i < vectors.get(0).getSize(); i++) {
            double temp = 0;
            for (MyVector vector : vectors) {
                temp += vector.getVector().get(i);
            }
            sum.add(temp);
        }
        return new MyVector(sum);
    }

    private static boolean checkVectorSize() {
        ArrayList<Integer> list = new ArrayList<>();
        for (MyVector vector : vectors) {
            list.add(vector.getSize());
        }
        if (new HashSet<Integer>(list).size() <= 1)
            return true;
        return false;
    }

    private static int sumSizes() {
        int sum = 0;
        for (MyVector vector : vectors) {
            sum += vector.getSize();
        }
        return sum;
    }

    private static void clearArray() {
        vectors.clear();
    }

    private static Integer[] countVectorsLen() {
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (MyVector vector : vectors) {
            temp = vector.getSize();
            list.add(temp);
        }
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {

        populateVectors();
        addVectors();
    }
}
