import edu.princeton.cs.algs4.StdOut;

public class TestPipelineing {
    public static void main (String[] args){

        int zaehler = Integer.parseInt(args[0]);
        int nenner = Integer.parseInt(args[1]);
        StdOut.print((double) zaehler/nenner);
        //System.out.println((double) zaehler/nenner);
    }
}
