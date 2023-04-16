import edu.princeton.cs.algs4.StdIn;

public class NPlusEvenFilter {
    public static void main(String[] args){
        while (!StdIn.isEmpty()) {
            double eingabe = StdIn.readDouble();
            if (eingabe > 0 && eingabe%2 == 0){
                System.out.print((int) eingabe + " ");
            }
        }

    }
}
