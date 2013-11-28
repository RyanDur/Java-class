public class IntegerTreeNode {
    Integer value;
    IntegerTreeNode left;
    IntegerTreeNode right;

    public IntegerTreeNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setLeft(IntegerTreeNode node) {
        left = node;
    }

    public IntegerTreeNode getLeft() {
        return left;
    }

    public void setRight(IntegerTreeNode node) {
        right = node;
    }

    public IntegerTreeNode getRight() {
        return right;
    }

    public String toString() {
	return "" + getValue();
    }
}
