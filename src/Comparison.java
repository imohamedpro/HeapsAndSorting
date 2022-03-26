import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Comparison{
    List<Sorting<Integer>> methods;
    String header;
    Comparison(List<Sorting<Integer>> methods, String header){
        this.methods = methods;
        this.header = header;
    }
    public void start(int step, int n){
        int size = step;
        for(int i = 0; i < n; i++){
            Integer[] source = Randomizer.generate(size);
            int[] scores = new int[methods.size() + 1];
            scores[0] = i;
            int j = 1;
            for(Sorting<Integer> method: methods){
                Integer[] copy = Arrays.copyOf(source, source.length);
                long time = System.nanoTime();
                method.sort(copy);
                scores[j] = (int)(Math.floor(((System.nanoTime() - time) / 1000))/ 1000);
            }
            appendToCsv(scores);
        }
    }

    private void appendToCsv(int[] scores){
        try {
            FileWriter fw = new FileWriter(new File("result.csv"));
            String str = "";
            for(Integer x: scores){
                str += x + ", ";
            }
            fw.append(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
