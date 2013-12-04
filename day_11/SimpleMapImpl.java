public class SimpleMapImpl<K,V> implements SimpleMap<K,V> {
    public static final int MAX_LENGTH_OF_ARRAY = 1000;
    @SuppressWarnings("unchecked")
    private V[] buckets = (V[])new Object[MAX_LENGTH_OF_ARRAY];

    @Override
    public void put(K key, V value) {
	buckets[generateIndex(key)] = value;
    }

    @Override
    public V get(K key) {
	return buckets[generateIndex(key)];
    }

    @Override
    public void remove(K key) {
	buckets[generateIndex(key)] = null;
    }

    private int generateIndex(K key) {
	return Math.abs(key.hashCode() % MAX_LENGTH_OF_ARRAY);
    }
}
