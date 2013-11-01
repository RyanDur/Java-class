public class IntegerNode extends Node {

    public IntegerNode(Integer num) {
	super(num);
    }

    public Integer getNode() {
	return (Integer) super.getNode();
    }

    public Node getNext() {
	return (IntegerNode) super.getNext();
    }

    public void setNext(IntegerNode node) {
	super.setNext(node);
    }
}
