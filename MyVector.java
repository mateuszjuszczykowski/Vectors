import java.util.ArrayList;

public class MyVector {
    private ArrayList<Double> vector = new ArrayList<Double>();
    private int size;

    public MyVector() {
    }

    public MyVector(ArrayList<Double> src) {
        vector = src;
        size = vector.size();
    }

    public void addElement(double elem) {
        vector.add(elem);
    }

    public ArrayList<Double> getVector() {
        return vector;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return getVector().toString();
    }
}