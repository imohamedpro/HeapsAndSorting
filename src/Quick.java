public class Quick <T extends Comparable<T>> implements Sorting<T> {

    private void qSort(T arr[],int start,int end){
            if(start>=end) return;
            int p = start;
            int i = start, j = end;
            while(i < j){
                while(i < end && arr[i].compareTo(arr[p]) < 0)  
                  i++;
                while(j > start && arr[j].compareTo(arr[p]) >= 0) 
                  j--;
                if(i < j){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            T temp = arr[p];
            arr[p] = arr[j];
            arr[j] = temp;
            qSort(arr, start, j-1);
            qSort(arr, j+1, end);
        }
    @Override
    public T[] sort(T[] array) {
        qSort(array, 0, array.length-1);
        return array;
    }
    
}
