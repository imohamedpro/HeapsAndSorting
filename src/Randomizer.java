public class Randomizer<T> {
    public static Integer[] generate(int size){
        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)(Math.random() * 10 * size) - 5 * size;
        }
        return arr;
    }
}
