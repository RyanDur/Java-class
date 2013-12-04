public class Node<T> {
    private Node<T> next;
    private T value;

    public Node(T value) {
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
}
