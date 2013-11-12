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
                    removeNode(num, node);
                }
            }
        }
    }

    public String toString() {
        return head.toString();
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

    private void removeNode(int num, IntegerTreeNode node) {
        if(node.getLeft() != null) {
            swap(node, node.getLeft());
            removeNode(num, node.getLeft());
        } else if(node.getRight() != null) {
            swap(node, node.getRight());
            removeNode(num, node.getRight());
        } else if(node.getLeft() == null && node.getRight() == null) {
            IntegerTreeNode parent = node.getParent();
            node.setParent(null);
            if(parent.getLeft() == node) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
    }

    private void swap(IntegerTreeNode node1, IntegerTreeNode node2) {
        int temp = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(temp);
    }

    private boolean contains(int num, IntegerTreeNode node) {
        if(node == null) {
            return false;
        }
        if(num == node.getValue()) {
            return true;
        }
        if(num < node.getValue()) {
            return contains(num, node.getLeft());
        }
        return contains(num, node.getRight());
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

        ibt.remove(9);
        ibt.remove(33);
        ibt.remove(1);

        System.out.println("Min: " + ibt.getMin());
        System.out.println("Max: " + ibt.getMax());

    }
}
