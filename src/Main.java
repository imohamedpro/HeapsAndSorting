import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Integer[] array = {5,13,2,25,7,17,20,8,4};
        array = new Quick<Integer>().sort(array);
        System.out.println(Arrays.toString(array));
    }
}