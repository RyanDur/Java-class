public class IntegerBinaryTree {
    private IntegerTreeNode head;

    public void add(int num) {
        if(head == null) {
            head = new IntegerTreeNode(num);
        } else {
            addNode(num, head);
            if(unbalanced(head)) {
                rebalance(head);
            }
        }
    }

    private void rebalance(IntegerTreeNode tree) {
        if(tree == null) {
            return;
        }
        if(tree.getLeft() == null && tree.getRight() == null) {
            return;
        }
        rebalance(tree.getLeft());
        rebalance(tree.getRight());
        rotate(tree);
    }

    private void rotate(IntegerTreeNode tree) {
        IntegerTreeNode head = tree;
        if(treeDepth(tree.getLeft()) > treeDepth(tree.getRight())) {
            tree = tree.getLeft();

            tree.setParent(head.getParent());
            head.setParent(tree);
            if(tree.getRight() != null) {
                tree.getRight().setParent(head);
            }

            tree.setRight(head);
        } else {
            tree = tree.getRight();

            tree.setParent(head.getParent());
            head.setParent(tree);
            if(tree.getLeft() != null) {
                tree.getLeft().setParent(head);
            }

            tree.setLeft(head);
        }
    }

    private boolean unbalanced(IntegerTreeNode node) {
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        return (Math.abs(left - right) > 1);
    }

    public Integer getMin() {
        if(head == null) {
            return null;
        }
        IntegerTreeNode node = head;
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    public Integer getMax() {
        if(head == null) {
            return null;
        }
        return getMax(head).getValue();
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
        return treeDepth(head);
    }

    public String toString() {
        if(head == null) {
            return "Empty";
        }
        return head.toString();
    }

    private void addNode(int num, IntegerTreeNode node) {
        IntegerTreeNode newNode = new IntegerTreeNode(num);
        newNode.setParent(node);

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
        } else if(node.getLeft() == null && node.getRight() == null) {
            return 0;
        } else {
            int left = treeDepth(node.getLeft());
            int right = treeDepth(node.getRight());
            return left > right ? left + 1 : right + 1;
        }
    }

    public static void main(String []args) {
        int[] nums = {1,2,3,3,4,5,6,7,7,8,9};
        IntegerBinaryTree ibt = new IntegerBinaryTree();
        IntegerBinaryTree ibtOne = new IntegerBinaryTree();

        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.add(1);

        System.out.println();
        System.out.println("Add 1");
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        // ibtOne.remove(1);

        // System.out.println();
        // System.out.println("Remove 1");
        // System.out.println("Min: " + ibtOne.getMin());
        // System.out.println("Max: " + ibtOne.getMax());
        // System.out.println(ibtOne);
        // System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.add(2);
        ibtOne.add(3);

        System.out.println();
        System.out.println("Add 2 3");
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        // ibtOne.remove(2);

        // System.out.println();
        // System.out.println("Remove 2");
        // System.out.println("Min: " + ibtOne.getMin());
        // System.out.println("Max: " + ibtOne.getMax());
        // System.out.println(ibtOne);
        // System.out.println("Tree Depth: " + ibtOne.depth());

        // ibtOne.remove(3);

        // System.out.println();
        // System.out.println("Remove 3");
        // System.out.println("Min: " + ibtOne.getMin());
        // System.out.println("Max: " + ibtOne.getMax());
        // System.out.println(ibtOne);
        // System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.add(4);
        ibtOne.add(5);
        ibtOne.add(3);

        System.out.println();
        System.out.println("Add 4 5 3");
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        // ibtOne.remove(4);

        // System.out.println();
        // System.out.println("Remove 4");
        // System.out.println("Min: " + ibtOne.getMin());
        // System.out.println("Max: " + ibtOne.getMax());
        // System.out.println(ibtOne);
        // System.out.println("Tree Depth: " + ibtOne.depth());

        // System.out.println("Tree Depth: " + ibt.depth());
        // for(int i = 0; i< nums.length; i++) {
        //     ibt.add(nums[i]);
        // }

        // for(int i = 0; i< nums.length; i++) {
        //     System.out.println(ibt.contains(nums[i]) + ": " + nums[i]);
        // }
        // System.out.println("Min: " + ibt.getMin());
        // System.out.println("Max: " + ibt.getMax());
        // System.out.println(ibt);
        // System.out.println("Tree Depth: " + ibt.depth());

        // ibt.remove(9);
        // ibt.remove(33);
        // ibt.remove(1);

        // for(int i = 0; i< nums.length; i++) {
        //     System.out.println(ibt.contains(nums[i]) + ": " + nums[i]);
        // }
        // System.out.println("Min: " + ibt.getMin());
        // System.out.println("Max: " + ibt.getMax());
        // System.out.println(ibt);
        // System.out.println("Tree Depth: " + ibt.depth());

        // ibt.remove(5);

        // for(int i = 0; i< nums.length; i++) {
        //     System.out.println(ibt.contains(nums[i]) + ": " + nums[i]);
        // }
        // System.out.println("Min: " + ibt.getMin());
        // System.out.println("Max: " + ibt.getMax());
        // System.out.println(ibt);
        // System.out.println("Tree Depth: " + ibt.depth());
    }
}
