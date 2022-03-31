public class Quick <T extends Comparable<T>> implements Sorting<T> {

    void qSort(T[] arr, int begin, int end) {
        if (begin < end) {
            T pivot = arr[end];
            int i = (begin - 1);
            for (int j = begin; j < end; j++) {
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    T swapTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                }
            }
            T swapTemp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = swapTemp;
            int partitionIndex = i + 1;
            qSort(arr, begin, partitionIndex - 1);
            qSort(arr, partitionIndex + 1, end);
        }
    }
    
    @Override
    public T[] sort(T[] array) {
        qSort(array, 0, array.length-1);
        return array;
    }
    
}
