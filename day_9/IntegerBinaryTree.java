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
        return getLeftMostValue(head);
    }

    public int getMin() {
        return getRightMostValue(head);
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
        if(node.getValue() < num) {
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

        for(int i = 0; i< nums.length; i++) {
            ibt.add(nums[i]);
        }

        System.out.println("Min: " + ibt.getMin());
        System.out.println("Max: " + ibt.getMax());
    }
}
