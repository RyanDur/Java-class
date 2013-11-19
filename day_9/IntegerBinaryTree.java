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

    public void delete(int num) {
        if(root == null) {
            return;
        }
        if(root.getValue() == num && isLeaf(root)) {
            root = null;
            return;
        }
        if(contains(num)) {
            IntegerTreeNode child;
            IntegerTreeNode parent;
            if(root.getValue() == num) {
                if(root.getLeft() != null) {
                    swap(root, root.getLeft());
                    child = root.getLeft();
                } else {
                    swap(root, root.getRight());
                    child = root.getRight();
                }
                parent = root;
            } else {
                child = get(num, root);
                parent = getParent(child, root);
            }
            if(parent.getLeft() == child) {
                deleteLeft(child, parent);
            } else {
                deleteRight(child, parent);
            }
        }
        root = rebalance(root);;
    }

    public boolean contains(int num) {
        return get(num, root) != null;
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

    private boolean deleteLeft(IntegerTreeNode child, IntegerTreeNode parent) {
        if(child == null || parent == null) {
            return false;
        }
        if(isLeaf(child)) {
            if(deleteLeaf(child, parent)) {
                return true;
            }
        } else if(child.getRight() != null) {
            parent = child;
            while(child.getRight() != null) {
                child = child.getRight();
            }
            swap(child, parent);
            while(parent.getRight() != child) {
                parent = parent.getRight();
            }
            return deleteLeft(child, parent);
        }
        swap(child, child.getLeft());
        return deleteLeft(child.getLeft(), parent.getLeft());
    }

    private boolean deleteRight(IntegerTreeNode child, IntegerTreeNode parent) {
        if(isLeaf(child)) {
            if(deleteLeaf(child, parent)) {
                return true;
            }
        } else if(child.getLeft() != null) {
            parent = child;
            while(child.getLeft() != null) {
                child = child.getLeft();
            }
            swap(child, parent);
            while(parent.getLeft() != child) {
                parent = parent.getLeft();
            }
            return deleteLeft(child, parent);
        }
        swap(child, child.getRight());
        return deleteLeft(child.getRight(), parent.getRight());
    }

    private IntegerTreeNode get(int num, IntegerTreeNode tree) {
        if(tree == null) {
            return null;
        }
        if(tree.getValue() == num) {
            return tree;
        }
        if(tree.getValue() < num) {
            return get(num, tree.getRight());
        } else {
            return get(num, tree.getLeft());
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
        IntegerBinaryTree ibtTwo = new IntegerBinaryTree();

        //{8,1,4,2,2,7,4,5,99,23,4,78};
        int[] nums = {20,10,30,25,27};

        // System.out.println("Min: " + ibtOne.getMin());
        // System.out.println("Max: " + ibtOne.getMax());
        // System.out.println(ibtOne);
        // System.out.println("Tree Depth: " + ibtOne.depth());
        // System.out.println(ibtOne.contains(1));

        // for(int i = 1; i < 17; i++) {
        //     System.out.println();
        //     System.out.println("Add " + i);
        //     ibtOne.add(i);
        //     System.out.println("Min: " + ibtOne.getMin());
        //     System.out.println("Max: " + ibtOne.getMax());
        //     System.out.println(ibtOne);
        //     System.out.println("Tree Depth: " + ibtOne.depth());
        // }

        // for(int i = 0; i < 18; i++) {
        //     System.out.println(ibtOne.contains(i));
        // }

        for(int i = 0; i < nums.length; i++) {
            System.out.println();
            System.out.println("Add " + nums[i]);
            ibtTwo.add(nums[i]);
            System.out.println("Min: " + ibtTwo.getMin());
            System.out.println("Max: " + ibtTwo.getMax());
            System.out.println(ibtTwo);
            System.out.println("Tree Depth: " + ibtTwo.depth());
        }

        System.out.println();
        System.out.println(ibtTwo.contains(27));
        ibtTwo.delete(27);
        System.out.println(ibtTwo);
        System.out.println(ibtTwo.contains(27));

        System.out.println();
        System.out.println(ibtTwo.contains(25));
        ibtTwo.delete(25);
        System.out.println(ibtTwo);
        System.out.println(ibtTwo.contains(25));
    }
}
