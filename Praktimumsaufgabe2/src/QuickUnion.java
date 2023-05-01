public class QuickUnion extends UFBase{

    public QuickUnion(int count) {
        super(count);
    }

    @Override
    public int find(int p) {
        int node = p;
        while (id[node]!=node) node = id[node];
        return node;
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
}

//Ein Best-Case-Szenario für ein QuickUnion der Größe 5 wäre:    3 ∗ (N−1)
//              [0,1,2,3,4]                 4
//union(0,3) -> [3,1,2,3,4]                / \
//union(3,4) -> [3,1,2,4,4]               2   3
//union(1,2) -> [3,2,2,4,4]               |   |
//union(2,4) -> [3,2,4,4,4]               1   0

//Ein Worst-Case-Szenario für ein QuickUnion der Größe 5 wäre:    2 + (N−1) ∗ 2 + N
//              [0,1,2,3,4]                 4
//union(0,1) -> [1,1,2,3,4]                 |
//union(0,2) -> [1,2,2,3,4]                 3
//union(0,3) -> [1,2,3,3,4]                 |
//union(0,4) -> [1,2,3,4,4]                 2
//                                          |
//                                          1
//                                          |
//                                          0