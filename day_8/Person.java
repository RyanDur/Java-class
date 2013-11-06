public class Person extends Node {

    public Person(String name) {
	super(name);
    }

    public String getValue() {
	return (String) super.getValue();
    }

    public void setValue(Object value) {
	super.setValue(value);
    }

    public Node getNext() {
	return super.getNext();
    }

    public void setNext(Node node) {
	super.setNext(node);
    }

    public String toString() {
	return getValue();
    }
}
