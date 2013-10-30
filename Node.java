public class Node {
    Object node;
    Node nextNode;

    public Node(Object node) {
	this.node = node;
	nextNode = null;
    }

    public Object getNode() {
	return node;
    }

    public Node getNext() {
	return nextNode;
    }

    public void setNext(Node node) {
	this.nextNode = node;
    }
}
