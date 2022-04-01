import java.util.Arrays;

public class Heap implements Sorting{
    private Integer[] a;
    private int size;

    public Heap(){}

    public Heap(int size){
        this.a = new Integer[size];
        this.size = 0;
    }

    public Heap(Integer[] array){
        buildMaxHeap(array);
    }

    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int getLargest(int i){
        //System.out.println(this + "\n" + "i = " + i);
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

    private void buildMaxHeap(Integer[] b){
        this.a = b;
        this.size = a.length;
        for(int i = size/2; i >= 0; i--){
            maxHeapify(i);
        }
    }

    private void heapIncreaseKey(int i, Integer key) throws Exception {
        if(key.compareTo(a[i]) < 0){
            throw new Exception("New key is smaller than current key.");
        }
        a[i] = key;
        while((i > 0) && (a[parent(i)].compareTo(a[i]) < 0)){
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public void maxHeapInsert(Integer key) throws Exception {
        if(size+1 > a.length){
            Integer[] copy = new Integer[a.length*2];
            System.arraycopy(a, 0, copy, 0, a.length);
            this.a = copy;
        }
        a[size] = Integer.MIN_VALUE;
        this.size++;
        heapIncreaseKey(size-1, key);
    }

    public Integer heapExtractMax(){
        Integer max = this.a[0];
        a[0] = a[--size];
        maxHeapify(0);
        return max;
    }

    public Integer[] sort(Integer[] b){
        buildMaxHeap(b);
        for(int i = size-1; i >= 1; i--){
            swap(0, i);
            size--;
            maxHeapify(0);
        }
        return a;
    }

    private void swap(int i, int j){
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Heap{");
        for(int i = 0; i < size-1; i++){
            str.append(a[i]).append(", ");
        }
        str.append(a[size - 1]).append("}");
        str.append(", size = ").append(size);
        return str.toString();
    }
}
