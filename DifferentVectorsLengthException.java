import java.util.ArrayList;

public class DifferentVectorsLengthException extends Exception {

    private Integer[] vectorLengths;
    private ArrayList<MyVector> vectorArray;

    public DifferentVectorsLengthException(String messsage) {
        super(messsage);

    }

    public DifferentVectorsLengthException(String messsage, Integer[] arr) {
        super(messsage);

        vectorLengths = arr;
    }

    public DifferentVectorsLengthException(String messsage, ArrayList<MyVector> vectorArray) {
        super(messsage);

        this.vectorArray = vectorArray;
        countLengths();
    }

    private void countLengths() {

        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (MyVector vector : vectorArray) {
            temp = vector.getSize();
            list.add(temp);
        }
        Integer[] arr = new Integer[list.size()];
        vectorLengths = list.toArray(arr);

    }

    public void val() {
        for (Integer integer : vectorLengths) {
            System.out.println(integer);
        }
    }

    public int sum() {
        int sum = 0;
        for (Integer length : vectorLengths) {
            sum += length;
        }
        return sum;
    }

}
