import org.apache.commons.lang3.time.StopWatch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WeigthedQuickUnion extends UFBase{
    private int[] sz; // Groeße der Bauume

    public WeigthedQuickUnion(int count) {
        super(count);
        sz = new int[count];
        for (int i=0; i < count; i++){
            sz[i]=1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot==qRoot) return;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];}
        else {id[qRoot] = pRoot; sz[pRoot]+=sz[qRoot];}
        count--;
    }

    @Override
    public int find(int p) {
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File tinyUFFile = new File("C:\\Users\\Thomas\\Desktop\\ADP\\Praktimumsaufgabe2\\src\\mediumUF.txt");
        StopWatch timer = new StopWatch();
        Scanner scanner = new Scanner(tinyUFFile);
        int [] tinyUF = new int [4000003];
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
