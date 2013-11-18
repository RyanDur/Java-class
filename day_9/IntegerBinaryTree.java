public class IntegerBinaryTree {
    private IntegerTreeNode root;

    public void add(int num) {
        if(root == null) {
            root = new IntegerTreeNode(num);
        } else {
            addNode(num, root);
            root = rebalance(root);
        }
    }

    private IntegerTreeNode rebalance(IntegerTreeNode tree) {
        if(tree == null) {
            return null;
        }
        tree.setLeft(rebalance(tree.getLeft()));
        tree.setRight(rebalance(tree.getRight()));

        if(unbalanced(tree)) {
            tree = rotate(tree);
        }
	return tree;
    }

    private IntegerTreeNode rotate(IntegerTreeNode tree) {
        if(tree == null) {
            return null;
        }
        IntegerTreeNode head = tree;
        int leftTree = treeDepth(tree.getLeft());
        int rightTree = treeDepth(tree.getRight());
        if(leftTree > rightTree) {
            tree = tree.getLeft();
            head.setLeft(tree.getRight());
            tree.setRight(head);
        } else {
            tree = tree.getRight();
            head.setRight(tree.getLeft());
            tree.setLeft(head);
        }

        return tree;
    }

    private boolean unbalanced(IntegerTreeNode node) {
        if(node == null) {
            return false;
        }
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        return (Math.abs(left - right) > 1);
    }

    public Integer getMin() {
        if(root == null) {
            return null;
        }
        IntegerTreeNode node = root;
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    public Integer getMax() {
        if(root == null) {
            return null;
        }
        return getMax(root).getValue();
    }

    private IntegerTreeNode getMax(IntegerTreeNode node) {
        if(node == null) {
            return null;
        }
        if(node.getRight() == null) {
            return node;
        }
        return getMax(node.getRight());
    }

    public int depth() {
        return treeDepth(root);
    }

    public String toString() {
        if(root == null) {
            return "Empty";
        }
        return root.toString();
    }

    private void addNode(int num, IntegerTreeNode node) {
        IntegerTreeNode newNode = new IntegerTreeNode(num);

        if(node.getValue() > num) {
            if(node.getLeft() == null) {
                node.setLeft(newNode);
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

    private int treeDepth(IntegerTreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String []args) {
        int[] nums = {1,2,3,3,4,5,6,7,7,8,9};
        IntegerBinaryTree ibt = new IntegerBinaryTree();
        IntegerBinaryTree ibtOne = new IntegerBinaryTree();

        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        for(int i = 1; i < 17; i++) {
            System.out.println();
            System.out.println("Add " + i);
            ibtOne.add(i);
            System.out.println("Min: " + ibtOne.getMin());
            System.out.println("Max: " + ibtOne.getMax());
            System.out.println(ibtOne);
            System.out.println("Tree Depth: " + ibtOne.depth());
        }

    }
}
