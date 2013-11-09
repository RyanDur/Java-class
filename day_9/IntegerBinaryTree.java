public class IntegerBinaryTree {
    private IntegerTreeNode head;

    public void add(int num) {
        if(head == null) {
            head = new IntegerTreeNode(num);
        } else {
            addNode(num, head);
        }
    }

    public int getMax() {
        return getRightMostValue(head);
    }

    public int getMin() {
        return getLeftMostValue(head);

    }

    public int depth() {
	return treeDepth(head);
    }

    public String toString() {
        return head.toString();
    }

    private int treeDepth(IntegerTreeNode node) {
	if(node == null) {
	    return 0;
	}
	int left = treeDepth(node.getLeft());
	int right = treeDepth(node.getRight());
	return left > right ? left + 1 : right + 1;
    }

    private int getLeftMostValue(IntegerTreeNode node) {
        if(node.getLeft() == null) {
            return node.getValue();
        }
        return getLeftMostValue(node.getLeft());
    }

    private int getRightMostValue(IntegerTreeNode node) {
        if(node.getRight() == null) {
            return node.getValue();
        }
        return getRightMostValue(node.getRight());
    }

    private void addNode(int num, IntegerTreeNode node) {
        if(node.getValue() > num) {
            if(node.getLeft() == null) {
                node.setLeft(new IntegerTreeNode(num));
            } else {
                addNode(num, node.getLeft());
            }
        } else {
            if(node.getRight() == null) {
                node.setRight(new IntegerTreeNode(num));
            } else {
                addNode(num, node.getRight());
            }
        }
    }

    public static void main(String []args) {
        int[] nums = {7,3,9,1,3,7,2,4,2,7};
        IntegerBinaryTree ibt = new IntegerBinaryTree();

	System.out.println("Tree Depth: " + ibt.depth());

        for(int i = 0; i< nums.length; i++) {
            ibt.add(nums[i]);
        }

        System.out.println("Min: " + ibt.getMin());
        System.out.println("Max: " + ibt.getMax());

        System.out.println(ibt);

	System.out.println("Tree Depth: " + ibt.depth());
    }
}
