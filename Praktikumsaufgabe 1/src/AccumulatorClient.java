import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AccumulatorClient {
    public static void main(String[] args){

        int modi = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double max = Double.parseDouble(args[2]);

        Accumulator acc;
        if(modi == 0){
            acc = new SimpleAccumulator();
        }
        else{
            acc = new VisualAccumulator(T, max);
        }

        while (!StdIn.isEmpty()) {
            acc.addDataValue(StdIn.readDouble());
        }
        StdOut.println(acc);

    }
}
