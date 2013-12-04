public class Entry<K,V> {
    private final K key;
    private V value;
    private Entry<K,V> next;

    public Entry(K key, V value) {
	this.key = key;
	setValue(value);
    }

    public K getKey() {
	return key;
    }

    public void setValue(V value) {
	this.value = value;
    }

    public V getValue() {
	return value;
    }

    public void setNext(Entry<K,V> node) {
	next = node;
    }

    public Entry<K,V> getNext() {
	return next;
    }
}
