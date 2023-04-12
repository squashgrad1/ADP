import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdRandom;

public class main {
    public static void main(String[] args){

        Accumulator acc = new VisualAccumulator(1000, 5);
        for(int i = 0; i <= 1000; i++){
            acc.addDataValue(StdRandom.uniform(0.0,5.0));
        }

    }
}
