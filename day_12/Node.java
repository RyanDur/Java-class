public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
	this.value = value;
    }

    public void setValue(T value) {
	this.value = value;
    }

    public T getValue() {
	return value;
    }

    public void setNext(Node<T> node) {
	next = node;
    }

    public Node<T> getNext() {
	return next;
    }

    public String toString() {
	return getValue().toString();
    }
}
