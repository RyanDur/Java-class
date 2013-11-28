public class TreeIntSet implements IntSet {
    IntegerTreeNode root;

    @Override
    public void add(int num) {
        if(root == null) {
            root = new IntegerTreeNode(num);
        } else {
            if(!contains(num)) {
                addNode(num, root);
                root = rebalance(root);
            }
        }
    }

    @Override
    public boolean contains(int num) {
        return contains(num, root);
    }

    @Override
    public boolean containsVerbose(int num) {
        return containsVerbose(num, root);
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	return toString(builder, root);
    }

    private String toString(StringBuilder builder, IntegerTreeNode tree) {
	if(tree == null) {
	    return builder.toString();
	}
	builder.append(toString(builder, tree.getLeft()));
	builder.append(toString(builder, tree.getRight()));

	return tree.toString();
    }

    private boolean containsVerbose(int num, IntegerTreeNode tree) {
        System.out.println(tree);
        if(tree == null) {
            return false;
        }
        if(tree.getValue() == num) {
            return true;
        }
        if(tree.getValue() < num) {
            return contains(num, tree.getRight());
        } else {
            return contains(num, tree.getLeft());
        }
    }

    private boolean contains(int num, IntegerTreeNode tree) {
        if(tree == null) {
            return false;
        }
        if(tree.getValue() == num) {
            return true;
        }
        if(tree.getValue() < num) {
            return contains(num, tree.getRight());
        } else {
            return contains(num, tree.getLeft());
        }
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

    private boolean unbalanced(IntegerTreeNode node) {
        if(node == null) {
            return false;
        }
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        return (Math.abs(left - right) > 1);
    }

    private int treeDepth(IntegerTreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = treeDepth(node.getLeft());
        int right = treeDepth(node.getRight());
        return left > right ? left + 1 : right + 1;
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

    public static void main(String []args) {
	TreeIntSet tis = new TreeIntSet();

	int[] nums = {1,1,2};
	for(int i = 0; i < nums.length; i++) {
	    tis.add(nums[i]);
	}

	System.out.println(tis.contains(1));
	System.out.println(tis.contains(2));
	System.out.println(tis);
    }
}
