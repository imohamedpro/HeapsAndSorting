public class Heap<T extends Comparable<T>> implements Sorting<T>{
    private T[] a;
    private int size;

    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    private int getLargest(int i){
        int l = left(i), r = right(i), largest = -1;
        if(l < this.size && a[l].compareTo(a[i]) > 0)
            largest = l;
        else
            largest = i;

        if(r < this.size && a[r].compareTo(a[largest]) > 0)
            largest = r;

        return largest;
    }

    private void maxHeapify(int i){
        int largest = getLargest(i);
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap(T[] b){
        this.a = b;
        this.size = a.length;
        for(int i = size/2; i >= 0; i--){
            maxHeapify(i);
        }
    }

    public T[] sort(T[] b){
        buildMaxHeap(b);
        for(int i = size-1; i >= 1; i--){
            swap(0, i);
            size--;
            maxHeapify(0);
        }
        return a;
    }

    private void swap(int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
