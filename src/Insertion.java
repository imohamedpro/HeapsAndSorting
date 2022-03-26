public class Insertion<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public T[] sort(T[] array) {
        for(int i = 1; i < array.length; i++){
            int j = i;
            T temp = array[j];
            while(j >= 1 && temp.compareTo(array[j-1]) < 0){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }
    
}
