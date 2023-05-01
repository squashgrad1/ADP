public interface UF {
    /**
     * Anzahl der Komponenten
     */
    int count();
    /**
     * Vereinigt p und q in eine Komponente. Verringert die Anzahl der Komponenten um 1, wenn p und q in zwei verschiedenen Komponenten sind
     */
    void union(int p,int q);
    /**
     * liefert den Komponenten-Bezeichner
     */
    int find(int p);
    /**
     * Prüft, ob p und q in der gleichen Komponente sind
     */
    boolean connected(int p,int q);
}
