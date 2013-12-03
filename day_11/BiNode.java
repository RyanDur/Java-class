public class BiNode<T extends Comparable<T>> {
    private BiNode<T> left;
    private BiNode<T> right;
    private T value;

    public BiNode(T value) {
	this.value = value;
    }

    public T getValue() {
	return value;
    }

    public void setLeft(BiNode<T> node) {
	left = node;
    }

    public BiNode<T> getLeft() {
	return left;
    }

    public void setRight(BiNode<T> node) {
	right = node;
    }

    public BiNode<T> getRight() {
	return right;
    }

    public boolean lessThan(BiNode<T> node) {
	return getValue().compareTo(node.getValue()) < 0;
    }

    public String toString() {
	return value.toString();
    }
}
