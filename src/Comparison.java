import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Comparison{
    List<Sorting> methods;
    String header;
    Comparison(List<Sorting> methods, String header){
        this.methods = methods;
        this.header = header;
    }
    public void start(int step, int n) throws Exception{
        FileWriter fw = new FileWriter(new File("result.csv"));
        fw.append(header + "\n");
        int size = step;
        for(int i = 0; i < n; i++){
            Integer[] source = Randomizer.generate(size);
            double[] scores = new double[methods.size() + 1];
            scores[0] = size;
            int j = 1;
            for(Sorting method: methods){
                //Integer[] copy = Arrays.copyOf(source, source.length);
                double score = 0;
                for(int k = 0; k < 50; k++){
                    long time = System.nanoTime();
                    method.sort(Arrays.copyOf(source, source.length));
                    score += (Math.floor(((System.nanoTime() - time))) / 1000);
                }
                scores[j++] = score / 50;
            }
            System.out.println("finished sorting " + size);
            appendToCsv(scores, fw);
            size += step;
        }

        fw.close();

    }

    private void appendToCsv(double[] scores, FileWriter fw){
        try {
            String str = "";
            for(Double x: scores){
                str += x + ", ";
            }
            str += "\n";
            fw.append(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
