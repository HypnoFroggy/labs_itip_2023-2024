import java.util.ArrayList;

class HashTable<Key,Value> {
    private int size;
    private ArrayList<Integer> index;
    private ArrayList<ArrayList<Value>> collection;
    private ArrayList<ArrayList<Key>> keys;

    HashTable() {
        size = 0;
        index = new ArrayList<Integer>();
        collection = new ArrayList<ArrayList<Value>>();
        keys = new ArrayList<ArrayList<Key>>();
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public static int hash(String k) {;
        int res = 0;
        for (char c : k.toCharArray()) {
            res = res * 100 + Character.getNumericValue(c);
        }
        return res;
    }
    private int hash(Key k) {
        String str = k.toString();
        int res = 0;
        for (char c : str.toCharArray()) {
            res = res * 100 + Character.getNumericValue(c);
        }
        return res;
    }
    public void put(Key k, Value value) {
        int hash = hash(k);
        if (!index.contains(hash)) {
            index.add(hash);
            ArrayList<Value> val = new ArrayList<Value>();
            val.add(value);
            ArrayList<Key> key = new ArrayList<Key>();
            key.add(k);
            collection.add(val);
            keys.add(key);
            // val = null;
            // key = null;
            // System.gc();
        }
        else {
            if (keys.get(index.indexOf(hash)).contains(k)) {
                collection
                .get(index.indexOf(hash))
                .add(keys.get(index.indexOf(hash)).indexOf(k), value);
            }
            else {
                keys
                .get(index.indexOf(hash))
                .add(k);
                collection
                .get(index.indexOf(hash))
                .add(value);
            }
        }
        this.size++;
    }
    public void remove(Key k) {
        int hash = hash(k);
        if (collection.get(index.indexOf(hash)).size() == 1) {
            collection
            .get(index.indexOf(hash))
            .remove(0);
        }
        else {
            collection
            .get(index.indexOf(hash))
            .remove(keys.indexOf(k));
        }
        this.size--;
    }
    public Value get(Key k) {
        int hash = hash(k);
        if (collection.get(index.indexOf(hash)).size() == 1) {
            return 
            collection
            .get(index.indexOf(hash))
            .get(0);
        }
        return 
        collection
        .get(index.indexOf(hash))
        .get(keys
            .get(index.indexOf(hash))
            .indexOf(k));
    }
}
