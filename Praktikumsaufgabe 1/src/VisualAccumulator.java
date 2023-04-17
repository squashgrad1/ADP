import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class VisualAccumulator extends SimpleAccumulator{

    private int N=0;
    private double total=0.0;
    double max;

    public VisualAccumulator(int trials, double max){
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(0.005);
    }

    @Override
    public void addDataValue(double d) {
        N++;
        total += d;
        StdDraw.setPenColor(Color.DARK_GRAY);
        StdDraw.point(N,d);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(N,total/N);
    }

    @Override
    public String toString() {
        return String.format("Mean (%d values): %7.5f", N,total/N);
    }
}
