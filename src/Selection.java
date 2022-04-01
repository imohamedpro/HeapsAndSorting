public class Selection implements Sorting{
    @Override
    public Integer[] sort(Integer[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(array[j].compareTo(array[min]) < 0)
                    min = j;
            }
            Integer temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
