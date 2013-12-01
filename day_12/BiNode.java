public class BiNode<T> extends Node<T> {
    private BiNode prev;

    public BiNode(T value) {
	super(value);
    }

    public void setValue(T value) {
	super.setValue(value);
    }

    public T getValue() {
	return super.getValue();
    }

    public void setNext(BiNode<T> node) {
	super.setNext(node);
    }

    public BiNode<T> getNext() {
	return (BiNode<T>) super.getNext();
    }

    public void setPrev(BiNode<T> node) {
	prev = node;
    }

    public BiNode<T> getPrev() {
	return prev;
    }
}
