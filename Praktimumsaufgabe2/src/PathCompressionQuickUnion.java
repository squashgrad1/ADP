import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class PathCompressionQuickUnion extends UFBase{

    public PathCompressionQuickUnion(int count) {
        super(count);
    }

    @Override
    public int find(int p) {
        if(p == id[p]) return p;
        int root = find(id[p]);
        id[p] = root;
        return root;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
            count--;
        }
    }

    public void unionEverything(){
        int j = 0;
        for (int i = 1; i < id.length; i++) {
            union(i,j);
            j++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File tinyUFFile = new File("C:\\Users\\Thomas\\Desktop\\ADP\\Praktimumsaufgabe2\\src\\tinyUF.txt");
        StopWatch timer = new StopWatch();
        Scanner scanner = new Scanner(tinyUFFile);
        int [] tinyUF = new int [23];
        int i = 0;
        while(scanner.hasNextInt()){
            tinyUF[i++] = scanner.nextInt();
        }
        PathCompressionQuickUnion tinyUFunion = new PathCompressionQuickUnion(tinyUF.length);
        timer.start();
        tinyUFunion.unionEverything();
        timer.stop();
        System.out.println(timer.getTime(TimeUnit.NANOSECONDS));
    }
}
