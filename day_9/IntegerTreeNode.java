public class IntegerTreeNode {
    int value;
    IntegerTreeNode left;
    IntegerTreeNode right;
    IntegerTreeNode parent;

    public IntegerTreeNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
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

    public void setParent(IntegerTreeNode node) {
	parent = node;
    }

    public IntegerTreeNode getParent() {
	return parent;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[" + getValue() + " ");
        if(getLeft() == null) {
            builder.append("L[]");
        } else {
            builder.append("L" + getLeft());
        }
        if(getRight() == null) {
            builder.append("R[]");
        } else {
            builder.append("R" + getRight());
        }
	builder.append("]");
        return builder.toString();
    }
}
