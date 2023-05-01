package ad_2_4.treelayouter;

class Entry<K> {
    K key;
    Entry(K key){
        this.key=key;
    }

    @Override
    public String toString() {
        return key.toString();
    }

}
