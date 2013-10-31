public class NodeDbl extends Node {
    NodeDbl lastNode;

    public NodeDbl(Object node) {
	super(node);
	lastNode = null;
    }

    public NodeDbl getNext() {
	return (NodeDbl) super.getNext();
    }

    public void setNext(NodeDbl node) {
        super.setNext(node);
    }

    public NodeDbl getLast() {
	return lastNode;
    }

    public void setLast(NodeDbl node) {
	lastNode = node;
    }

    public Object getNode() {
        return super.getNode();
    }
}
