public class Node {
    Object value;
    Node nextNode;

    public Node(Object value) {
	this.value = value;
	nextNode = null;
    }

    public Object getValue() {
	return value;
    }

    public void setValue(Object value) {
	this.value = value;
    }

    public Node getNext() {
	return nextNode;
    }

    public void setNext(Node node) {
	this.nextNode = node;
    }

    public boolean compare(Node node) {
	return value == node.getValue();
    }
}
