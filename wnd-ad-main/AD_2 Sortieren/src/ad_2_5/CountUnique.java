package ad_2_5;

import ad_2_3.Quick;
import edu.princeton.cs.algs4.In;

public class CountUnique {

    public static void main(String[] args) {
        String[] a = new In().readAllStrings();
        countUnique(a);
    }

    private static int countUnique(String[] a) {
        int count =0;
        Quick.sort(a);
        for (int i =1; i < a.length; i++){
            if (a[i].compareTo(a[i-1])!=0)
                count++;
        }
        return count;
    }
}
