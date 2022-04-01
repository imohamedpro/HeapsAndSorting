import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Integer[] array = {5,13,2,25,7,17,20,8,4};
        array = new Quick().sort(array);
        System.out.println(Arrays.toString(array));
        Heap heap = new Heap(new Integer[]{-140, -246, 97, 61, -323, 103, 691, 394, 591, 174, -811, 227, -194, 799, -687, 380, 521, -686, -360, -985, -777, -712, -959, 727, 352});
        System.out.println(heap);
        try {
            heap.maxHeapInsert(12345);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(heap);
        System.out.println("Max = " + heap.heapExtractMax());
        System.out.println(heap);
        ArrayList<Sorting> methods = new ArrayList<Sorting>();
        methods.add(new Heap());
        methods.add(new Insertion());
        methods.add(new Selection());
        methods.add(new Merge());
        methods.add(new Quick());
        Comparison c = new Comparison(methods, "n, Heap Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort");
        try {
            c.start(100, 100);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}