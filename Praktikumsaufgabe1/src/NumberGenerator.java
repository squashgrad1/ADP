import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class NumberGenerator {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        for (int i = 0; i <= N-1; i++){
            if (StdRandom.uniform() <= 0.5){
                StdOut.print(StdRandom.uniform((int)min, (int)max+1)+" ");
            }
            else{
                StdOut.print(StdRandom.uniform(min, max+1)+" ");
            }
        }
    }

}
