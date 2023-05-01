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
}
