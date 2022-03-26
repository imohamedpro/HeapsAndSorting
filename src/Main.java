import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Integer[] array = {5,13,2,25,7,17,20,8,4};
        array = new Quick<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
        ArrayList<Sorting<Integer>> methods = new ArrayList<Sorting<Integer>>();
        methods.add(new Heap<Integer>());
        methods.add(new Insertion<Integer>());
        methods.add(new Selection<Integer>());
        methods.add(new Merge<Integer>());
        methods.add(new Quick<Integer>());
        Comparison c = new Comparison(methods, "n, Heap Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort");
        c.start(100, 100);
    }
}