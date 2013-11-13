public class IntegerBinaryTree {
    private IntegerTreeNode head;

    public void add(int num) {
        if(head == null) {
            head = new IntegerTreeNode(num);
        } else {
            addNode(num, head);
        }
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
        IntegerTreeNode node = head;
        while(node.getRight() != null) {
            node = node.getRight();
        }
        return node.getValue();
    }

    public void remove(int num) {
        if(head == null) {
            return;
        }
        if(head.getValue() == num) {
            if(head.getLeft() == null && head.getRight() == null) {
                head = null;
            } else {
                if(head.getLeft() != null) {
                    swap(head, head.getLeft());
                    //                    removeNode(head.getLeft());
                } else {
                    IntegerTreeNode temp = head;
                    head = head.getRight();
                    temp.setRight(null);
                }
            }
        }
    }

    private void swap(IntegerTreeNode nodeOne, IntegerTreeNode nodeTwo) {
        int temp = nodeOne.getValue();
        nodeOne.setValue(nodeTwo.getValue());
        nodeTwo.setValue(temp);
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
        if(node.getValue() < num) {
            if(node.getRight() == null) {
                node.setRight(new IntegerTreeNode(num));
            } else {
                addNode(num, node.getRight());
            }
        } else {
            if(node.getLeft() == null) {
                node.setLeft(new IntegerTreeNode(num));
            } else {
                addNode(num, node.getLeft());
            }
        }

    }

    private int treeDepth(IntegerTreeNode node) {
	if(node == null || (node.getLeft() == null && node.getRight() == null)) {
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

        ibtOne.add(1);

        System.out.println();
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.remove(1);

        System.out.println();
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.add(2);
        ibtOne.add(3);

        System.out.println();
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.remove(2);

        System.out.println();
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.remove(3);

        System.out.println();
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        ibtOne.add(4);
        ibtOne.add(5);
        ibtOne.add(3);

        System.out.println();
        System.out.println("Min: " + ibtOne.getMin());
        System.out.println("Max: " + ibtOne.getMax());
        System.out.println(ibtOne);
        System.out.println("Tree Depth: " + ibtOne.depth());

        // ibtOne.remove(4);

        // System.out.println();
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
