public class Quick <T extends Comparable<T>> implements Sorting<T> {

    private void qSort(T arr[],int start,int end){
            if(start>=end) return;
            T pivot = arr[end];
            int i = (start - 1);
            for (int j = start; j < end; j++) {
                if (arr[j].compareTo(pivot) <= 0) {
                    i++;
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            T temp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = temp;
            int partitionIndex = i + 1;
            qSort(arr, start, partitionIndex - 1);
            qSort(arr, partitionIndex + 1, end);
    }
    @Override
    public T[] sort(T[] array) {
        qSort(array, 0, array.length-1);
        return array;
    }
    
}
