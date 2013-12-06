public class SinglyLinkedList<T> {
    private Node<T> head;

    public void add(T value) {
        if(head == null) {
            head = new Node<T>(value);
        } else {
            Node<T> node = new Node<T>(value);
            node.setNext(head);
            head = node;
        }
    }

    public void remove(T value) {
	head = delete(value, head);
    }

    public String toString() {
        return toString(head);
    }

    private Node<T> delete(T value, Node<T> node) {
	if(node != null) {
	    if(node.getValue().equals(value)) {
		Node<T> oldNode = node;
		node = node.getNext();
		oldNode.setNext(null);
	    } else {
		node.setNext(delete(value, node.getNext()));
	    }
	}
	return node;
    }

    private String toString(Node<T> node) {
        StringBuffer buffer = new StringBuffer();
        if(node != null) {
            buffer.append(toString(node.getNext()));
            if(node == head) {
                buffer.append(head);
            } else {
                buffer.append(node).append(", ");
            }
        }
        return buffer.toString();
    }
}
