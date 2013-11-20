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

    public boolean delete(int num) {
        boolean result = false;
        if(root == null) {
            result = false;
        } else if(root.getValue() == num && isLeaf(root)) {
            root = null;
            result = true;
        } else if(contains(num)) {
            IntegerTreeNode tree = getSubroot(num, root);
            if(isLeaf(tree)) {
                result = deleteLeaf(tree, getParent(tree, root));
            } else {
                if(isLeaf(tree.getRight())) {
                    swap(tree.getRight(), tree);
		    result = deleteLeaf(tree.getRight(), tree);
                } else {
		    result = delete(tree.getLeft(), tree);
		}
            }
        }
        root = rebalance(root);
        return result;
    }

    private boolean delete(IntegerTreeNode child, IntegerTreeNode parent) {
        boolean result = false;
        if(child == null || isLeaf(child)) {
            result = false;
        } else if(isLeaf(child)) {
            result = deleteLeaf(child, parent);
        } else {
            if(child.getRight() == null) {
                swap(parent,child);
                parent = child;
                result = delete(child.getLeft(), parent);
            } else {
                child = getRightMost(child, null);
                swap(child, parent);
                if(isLeaf(child)) {
                    result = deleteLeaf(child, getRightMost(parent.getLeft(), child));
                } else {
                    parent = child;
                    result = delete(child.getLeft(), parent);
                }
            }
        }
        return result;
    }

    private IntegerTreeNode getRightMost(IntegerTreeNode tree, IntegerTreeNode condition) {
        if(tree == null) {
            return null;
        }
        if(tree.getRight() == condition) {
            return tree;
        }
        return getRightMost(tree.getRight(), condition);
    }

    public boolean contains(int num) {
        return getSubroot(num, root) != null;
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
        IntegerTreeNode node = root;
        while(node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
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

    private boolean deleteLeaf(IntegerTreeNode child, IntegerTreeNode parent) {
        boolean result = false;
        if(parent.getLeft() == child) {
            parent.setLeft(null);
            result = true;
        } else if(parent.getRight() == child) {
            parent.setRight(null);
            result = true;
        }
        return result;
    }

    private boolean isLeaf(IntegerTreeNode tree) {
        return tree.getLeft() == null && tree.getRight() == null;
    }

    private IntegerTreeNode getSubroot(int num, IntegerTreeNode tree) {
        if(tree == null) {
            return null;
        }
        if(tree.getValue() == num) {
            return tree;
        }
        if(tree.getValue() < num) {
            return getSubroot(num, tree.getRight());
        } else {
            return getSubroot(num, tree.getLeft());
        }
    }

    private void swap(IntegerTreeNode nodeA, IntegerTreeNode nodeB) {
        int temp = nodeA.getValue();
        nodeA.setValue(nodeB.getValue());
        nodeB.setValue(temp);
    }

    private IntegerTreeNode getParent(IntegerTreeNode child, IntegerTreeNode parent) {
        if(child == null || parent == null) {
            return null;
        }
        if(parent == child) {
            return parent;
        }
        if(parent.getLeft() == child) {
            return parent;
        }
        if(parent.getRight() == child) {
            return parent;
        }
        if(parent.getValue() < child.getValue()) {
            return getParent(child, parent.getRight());
        } else {
            return getParent(child, parent.getLeft());
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
        if(treeDepth(tree.getLeft()) > treeDepth(tree.getRight())) {
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

    public static void main(String []args) {
        IntegerBinaryTree ibtOne = new IntegerBinaryTree();

        //{8,1,4,2,2,7,4,5,99,23,4,78};
        int[] nums = {20,10,30,25,27};

        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());
        System.out.println("contains 1: " + ibtOne.contains(1));
        System.out.println("delete 1: " + ibtOne.delete(1));

        System.out.println();

        for(int i = 1; i < 4; i++) {
            System.out.println("add "+ i);
            ibtOne.add(i);
            System.out.println("Min: " + ibtOne.getMin());
            System.out.println("Max: " + ibtOne.getMax());
            System.out.println(ibtOne);
            System.out.println("Tree Depth: " + ibtOne.depth());
            System.out.println("contains " + i + ": " + ibtOne.contains(i));
        }

        System.out.println();

        System.out.println("delete " + 1 + ": " + ibtOne.delete(1));
        System.out.println(ibtOne);

        System.out.println();

        System.out.println("delete " + 3 + ": " + ibtOne.delete(3));
        System.out.println(ibtOne);

        IntegerBinaryTree ibtTwo = new IntegerBinaryTree();
        int[] nums2 = {20,10,11,21};

        for(int i : nums2) {
            ibtTwo.add(i);
        }
        System.out.println(ibtTwo);
        System.out.println(ibtTwo.delete(20));
        System.out.println(ibtTwo);

        IntegerBinaryTree ibtThree = new IntegerBinaryTree();
        int[] nums3 = {20,30,40,50};

        for(int i : nums3) {
            ibtThree.add(i);
        }
        System.out.println(ibtThree);
        System.out.println(ibtThree.delete(40));
        System.out.println(ibtThree);


        // for(int i = 1; i < 17; i++) {
        //     System.out.println();
        //     System.out.println("Add " + i);
        //     ibtOne.add(i);
        //     System.out.println("Min: " + ibtOne.getMin());
        //     System.out.println("Max: " + ibtOne.getMax());
        //     System.out.println(ibtOne);
        //     System.out.println("Tree Depth: " + ibtOne.depth());
        // }

        // System.out.println();
        // System.out.println(ibtOne);
        // for(int i = 0; i < 18; i++) {
        //     System.out.println(i + ": " + ibtOne.contains(i));
        // }
        // System.out.println();
        // ibtOne.delete(4);
        // ibtOne.delete(13);
        // System.out.println(ibtOne);
        // for(int i = 0; i < 18; i++) {
        //     System.out.println(i + ": " + ibtOne.contains(i));
        // }
        // System.out.println();
        // ibtOne.delete(9);
        // System.out.println(ibtOne);
        // for(int i = 0; i < 18; i++) {
        //     System.out.println(i + ": " + ibtOne.contains(i));
        // }
        // System.out.println();
        // ibtOne.delete(7);
        // System.out.println(ibtOne);
        // for(int i = 0; i < 18; i++) {
        //     System.out.println(i + ": " + ibtOne.contains(i));
        // }

        // for(int i = 0; i < nums.length; i++) {
        //     System.out.println();
        //     System.out.println("Add " + nums[i]);
        //     ibtTwo.add(nums[i]);
        //     System.out.println("Min: " + ibtTwo.getMin());
        //     System.out.println("Max: " + ibtTwo.getMax());
        //     System.out.println(ibtTwo);
        //     System.out.println("Tree Depth: " + ibtTwo.depth());
        // }

        // System.out.println();
        // System.out.println(ibtTwo.contains(27));
        // ibtTwo.delete(27);
        // System.out.println(ibtTwo);
        // System.out.println(ibtTwo.contains(27));

        // System.out.println();
        // System.out.println(ibtTwo.contains(25));
        // ibtTwo.delete(25);
        // System.out.println(ibtTwo);
        // System.out.println(ibtTwo.contains(25));
    }
}
