public class SimpleMapBucketsImpl<K,V> implements SimpleMap<K,V> {
    public static final int MAX_LENGTH_OF_ARRAY = 1000;
    @SuppressWarnings("unchecked")
    private Entry<K,V>[] buckets = new Entry[MAX_LENGTH_OF_ARRAY];

    @Override
    public void put(K key, V value) {
        int entryKey = generateIndex(key);
        if(buckets[entryKey] == null) {
            buckets[entryKey] = new Entry<K,V>(key, value);
        } else {
            Entry<K,V> entry = buckets[entryKey];
            while(entry.getNext() != null) {
                entry = entry.getNext();
            }
            entry.setNext(new Entry<K,V>(key, value));
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        Entry<K,V> entry = buckets[generateIndex(key)];
        if(entry != null) {
            while(entry != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if(entry != null) {
                result = entry.getValue();
            }
        }
        return result;
    }

    @Override
    public void remove(K key) {
        int entryKey = generateIndex(key);
        Entry<K,V> entry = buckets[entryKey];
        if(entry != null) {
            if(entry.getKey() == key) {
                Entry<K,V> oldEntry = entry;
                entry = entry.getNext();
                oldEntry.setNext(null);
                buckets[entryKey] = entry;
            } else {
                delete(key, entry);
                buckets[entryKey] = entry;
            }
        }
    }

    private void delete(K key, Entry<K,V> entry){
        if(entry != null) {
            if(entry.getNext().getKey() == key) {
                Entry<K,V> oldEntry = entry.getNext();
                entry.setNext(oldEntry.getNext());
                oldEntry.setNext(null);
            } else {
                delete(key, entry.getNext());
            }
        }
    }


    private int generateIndex(K key) {
        return Math.abs(key.hashCode() % MAX_LENGTH_OF_ARRAY);
    }
}
