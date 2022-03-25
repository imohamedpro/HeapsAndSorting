import java.lang.reflect.Array;
import java.util.Arrays;

public class Merge<T extends Comparable<T>> implements Sorting<T>{
    @Override
    public T[] sort(T[] array) {
        if (array.length > 1) {
            int d = (array.length / 2);
            T[] left = Arrays.copyOfRange(array, 0, d);
            T[] right = Arrays.copyOfRange(array, d, array.length);
            left = sort(left);
            right = sort(right);
            return merge(left, right);
        } else {
            return array;
        }
    }

    public T[] merge(T[] left, T[] right) {
        T[] merged = (T[]) Array.newInstance(Integer.class, left.length + right.length);
        for (int i = 0, m1 = 0, m2 = 0; i < merged.length; i++) {
            if (left.length > m1 && right.length > m2) {
                if (left[m1].compareTo(right[m2]) <= 0)
                    merged[i] = left[m1++];
                else {
                    merged[i] = right[m2++];
                }
            } else {
                merged[i] = (left.length == m1) ? right[m2++] : left[m1++];
            }
        }
        return merged;
    }

}
