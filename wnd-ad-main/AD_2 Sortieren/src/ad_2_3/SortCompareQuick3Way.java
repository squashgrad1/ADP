package ad_2_3;

import ad_2.ReflectionException;
import ad_2.SortClassWrapper;
import ad_2.Sorter;
import ad_2.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

public class SortCompareQuick3Way {

    public static void main(String[] args) throws ReflectionException {
        Sorter alg1 = Sorter.QUICK3WAY;
        Sorter alg2 = Sorter.valueOf(args[0]);
        int N = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        if (k<=0) {
            compare(alg1, alg2, N);
        } else compare(alg1, alg2, N, k);
    }

    private static void compare(Sorter alg1, Sorter alg2, int length) throws ReflectionException {

        double t1 = 0.0;
        double t2 = 0.0;
        int[] steps = {500, 100, 50, 20, 10, 1};
        for (int multiples : steps) {
            compare(alg1,alg2,length,multiples);
        }
    }

    private static void compare(Sorter alg1, Sorter alg2, int length, int multiples) throws ReflectionException {

        double t1 = 0.0;
        double t2 = 0.0;
        t1 += timeRandomInput(alg1, length, multiples);
        t2 += timeRandomInput(alg2, length, multiples);
        StdOut.printf("For %d random Doubles with %d different values %s is %.1f times faster on average than %s\n", length, multiples, alg1, t2 / t1, alg2);

    }

    private static double timeRandomInput(Sorter alg, int N, int k) throws ReflectionException {
           Double[] a = generateData(N, k);
           return time(alg, a);
    }

    private static double time(Sorter alg, Double[] a) throws ReflectionException {
        Stopwatch timer = new Stopwatch();
        SortClassWrapper.doSort(alg,a);
        return timer.elapsedTime();
    }


    private static Double[] generateData(int n, int k) {
        Double[] a = new Double[n];
        int MAX = 1000;
        Set<Double> control = new HashSet<>();
        for (int i = 0; i < k; i++) {
            double val = StdRandom.uniform(0, MAX * 1.0);
            while (!control.add(val)) {
                val = StdRandom.uniform(0, MAX * 1.0);
            }
            a[i] = val;
        }
        for (int i = k; i < n; i++) {
            a[i] = a[i % k];
        }
        return a;
    }
}
