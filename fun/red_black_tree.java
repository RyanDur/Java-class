public class red_black_tree {
    private rbNode root;

    public void add(int index) {
	if(root == null) {
	    root = new rbNode(index);
	} else {
	    addNode(root, new rbNode(index));
	}
    }

    private void addNode(rbNode parent, rbNode child) {
	if(parent == null) {
	    return;
	}
	if(parent.getIndex() < child.getIndex()) {
	    if(parent.getRight() == null) {
		parent.setRight(child);
	    } else {
		addNode(parent.getRight(), child);
	    }
	} else {
	    if(parent.getLeft() == null) {
		parent.setLeft(child);
	    } else {
		addNode(parent.getLeft(), child);
	    }
	}
    }
}
