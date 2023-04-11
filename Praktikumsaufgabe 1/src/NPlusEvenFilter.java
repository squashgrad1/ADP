import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdIn.readInt;

public class NPlusEvenFilter {
    public static void main(String[] args){
        while (!StdIn.isEmpty()) {
            int eingabe = StdIn.readInt();
            if (eingabe < 0 && eingabe%2 == 0){
                System.out.print(eingabe + " ");
            }
        }

    }
}
