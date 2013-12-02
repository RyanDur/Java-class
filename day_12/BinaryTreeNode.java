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

    public BinaryTreeNode<T> getRightMost() {
        return getRightMost(null);
    }

    public BinaryTreeNode<T> getLeftMost() {
	BinaryTreeNode<T> result = this;
        if(getLeft() != null) {
            result = getLeft().getLeftMost();
        }
        return result;
    }

    public BinaryTreeNode<T> getRightMost(BinaryTreeNode<T> condition) {
        BinaryTreeNode<T> result = this;
        if(getRight() != null && getRight() != condition) {
            result = getRight().getRightMost(condition);
        }
        return result;
    }

    public void deleteLeaf(BinaryTreeNode<T> child) {
        if(child.isLeaf()) {
            if(getLeft() == child) {
                setLeft(null);
            } else {
                setRight(null);
            }
        }
    }

    public String toString() {
        return getValue().toString();
    }
}
