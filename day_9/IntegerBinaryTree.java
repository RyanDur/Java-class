public class IntegerBinaryTree {
    private IntegerTreeNode head;

    public void add(int num) {
        if(head == null) {
            head = new IntegerTreeNode(num);
        } else {
            addNode(num, head);
            rebalance();
        }
    }

    public int getMax() {
        IntegerTreeNode searchNode = head;
        while(searchNode.getRight() != null) {
            searchNode = searchNode.getRight();
        }
        return searchNode.getValue();
    }

    public int getMin() {
        IntegerTreeNode searchNode = head;
        while(searchNode.getLeft() != null) {
            searchNode = searchNode.getLeft();
        }
        return searchNode.getValue();
    }

    public int depth() {
        return treeDepth(head);
    }

    public void remove(int num) {
        if(contains(num, head)) {
            if(head.getValue() == num && head.getLeft() == null && head.getRight() == null) {
                head = null;
            } else {
                IntegerTreeNode node = search(num, head);
                if(node != null) {
                    removeNode(node);
                }
            }
        }
    }

    public String toString() {
        return head.toString();
    }

    public void rebalance() {
        balance(head);
    }

    private void balance(IntegerTreeNode node) {

        if(isUnbalanced(node)) {
            int left = treeDepth(node.getLeft());
            int right = treeDepth(node.getRight());

            if(left > right) {
                IntegerTreeNode leftTree = node.getLeft();
                while(leftTree.getRight() != null) {
                    leftTree = leftTree.getRight();
                }
                swap(leftTree, node);
                addNode(leftTree.getValue(), node);
                removeNode(leftTree);
            } else {
                IntegerTreeNode rightTree = node.getRight();
                while(rightTree.getLeft() != null) {
                    rightTree = rightTree.getLeft();
                }
                swap(rightTree, node);
                addNode(rightTree.getValue(), node);
                removeNode(rightTree);
            }
        }
    }

    private boolean isUnbalanced(IntegerTreeNode node) {
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        int depthDifference = Math.abs(left - right);
        return depthDifference > 1;
    }

    private IntegerTreeNode search(int num, IntegerTreeNode node) {
        if(node == null || node.getValue() == num) {
            return node;
        }
        if(node.getValue() < num) {
            return search(num, node.getRight());
        }
        return search(num, node.getLeft());
    }

    private void removeNode(IntegerTreeNode node) {
        if(node.getLeft() != null) {
            swap(node, node.getLeft());
            removeNode(node.getLeft());
        } else if(node.getRight() != null) {
            swap(node, node.getRight());
            removeNode(node.getRight());
        } else if(node.getLeft() == null && node.getRight() == null) {
            IntegerTreeNode parent = node.getParent();
            node.setParent(null);
            if(parent.getLeft() == node) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            rebalance();
        }
    }

    private void swap(IntegerTreeNode node1, IntegerTreeNode node2) {
        int temp = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(temp);
    }

    public boolean contains(int num) {
        return contains(num, head);
    }

    private boolean contains(int num, IntegerTreeNode node) {
        if(node == null) {
            return false;
        }
        if(node.getValue() == num) {
            return true;
        }
        boolean left = contains(num, node.getLeft());
        boolean right = contains(num, node.getRight());
        return left || right;
    }

    private int treeDepth(IntegerTreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        return left > right ? left + 1 : right + 1;
    }

    private void addNode(int num, IntegerTreeNode node) {
        if(node.getValue() > num) {
            if(node.getLeft() == null) {
                node.setLeft(new IntegerTreeNode(num));
                node.getLeft().setParent(node);
            } else {
                addNode(num, node.getLeft());
            }
        } else {
            if(node.getRight() == null) {
                node.setRight(new IntegerTreeNode(num));
                node.getRight().setParent(node);
            } else {
                addNode(num, node.getRight());
            }
        }
    }

    public static void main(String []args) {
        int[] nums = {1,2,3,3,4,5,6,7,7,8,9};
        IntegerBinaryTree ibt = new IntegerBinaryTree();

        System.out.println("Tree Depth: " + ibt.depth());

        for(int i = 0; i< nums.length; i++) {
            ibt.add(nums[i]);
        }

        for(int i = 0; i< nums.length; i++) {
            System.out.println(ibt.contains(nums[i]) + ": " + nums[i]);
        }

        System.out.println("Min: " + ibt.getMin());
        System.out.println("Max: " + ibt.getMax());

        System.out.println(ibt);

        System.out.println("Tree Depth: " + ibt.depth());

        ibt.remove(9);
        ibt.remove(33);
        ibt.remove(1);

        for(int i = 0; i< nums.length; i++) {
            System.out.println(ibt.contains(nums[i]) + ": " + nums[i]);
        }

        System.out.println("Min: " + ibt.getMin());
        System.out.println("Max: " + ibt.getMax());

        System.out.println(ibt);

        System.out.println("Tree Depth: " + ibt.depth());

	ibt.remove(5);

        for(int i = 0; i< nums.length; i++) {
            System.out.println(ibt.contains(nums[i]) + ": " + nums[i]);
        }

        System.out.println("Min: " + ibt.getMin());
        System.out.println("Max: " + ibt.getMax());

        System.out.println(ibt);

        System.out.println("Tree Depth: " + ibt.depth());
    }
}
