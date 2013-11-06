public class IntegerNode extends Node {

    public IntegerNode(Integer num) {
	super(num);
    }

    public Integer getValue() {
	return (Integer) super.getValue();
    }

    public Node getNext() {
	return (IntegerNode) super.getNext();
    }

    public void setNext(IntegerNode node) {
	super.setNext(node);
    }

    public boolean compare(Node node) {
	return getValue() > (Integer) node.getValue();
    }
}
