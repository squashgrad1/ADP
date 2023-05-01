public abstract class UFBase implements UF{
    protected int count;

    protected int[] id;

    public UFBase(int count){
        id = new int[count];
        this.count = count;
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {return find(p) == find(q);}

    public int count() {
        return count;
    }

    public abstract void union(int p, int q);
    public abstract int find(int p);
}
