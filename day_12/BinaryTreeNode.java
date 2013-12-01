public class BinaryTreeNode<T extends Comparable<T>> extends BiNode<T> {

    public BinaryTreeNode(T value) {
	super(value);
    }

    public void setValue(T value) {
	super.setValue(value);
    }

    public T getValue() {
	return super.getValue();
    }

    public void setLeft(BinaryTreeNode<T> node) {
	super.setPrev(node);
    }

    public BinaryTreeNode<T> getLeft() {
	return (BinaryTreeNode<T>) super.getPrev();
    }

    public void setRight(BinaryTreeNode<T> node) {
	super.setNext(node);
    }

    public BinaryTreeNode<T> getRight() {
	return (BinaryTreeNode<T>) super.getNext();
    }

    public boolean lessThan(BinaryTreeNode<T> node) {
	return  getValue().compareTo(node.getValue()) < 0;
    }

    public boolean isLeaf() {
	return getLeft() == null && getRight() == null;
    }

    public void swap(BinaryTreeNode<T> node) {
	T temp = getValue();
	setValue(node.getValue());
	node.setValue(temp);
    }

    public String toString() {
	return getValue().toString();
    }
}
