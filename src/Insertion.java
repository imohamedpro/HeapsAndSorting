public class Insertion implements Sorting {

    @Override
    public Integer[] sort(Integer[] array) {
        for(int i = 1; i < array.length; i++){
            int j = i;
            Integer temp = array[j];
            while(j >= 1 && temp.compareTo(array[j-1]) < 0){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }
    
}
