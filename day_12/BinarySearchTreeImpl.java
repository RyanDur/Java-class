public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    private BinaryTreeNode<T> root;

    @Override
    public void add(T value) {
        if(root == null) {
            root = new BinaryTreeNode<>(value);
        } else {
            addNode(new BinaryTreeNode<>(value), root);
            root = rebalance(root);
        }
    }

    @Override
    public void delete(T value) {
        if(contains(value)) {
            if(root.isLeaf()) {
                root = null;
            } else {
                BinaryTreeNode<T> subTree = retrieveNode(value, root);
                if(subTree.isLeaf()) {
                    retrieveParent(subTree, root).deleteLeaf(subTree);
                } else {
                    deleteNode(subTree);
                }
                root = rebalance(root);
            }
        }
    }

    @Override
    public boolean contains(T value) {
        return retrieveNode(value, root) != null;
    }

    @Override
    public T getMin() {
        return root.getLeftMost().getValue();
    }

    @Override
    public T getMax() {
        return root.getRightMost().getValue();
    }

    @Override
    public int depth() {
        return treeDepth(root);
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private void deleteNode(BinaryTreeNode<T> tree) {
        if(tree.getLeft() != null) {
            if(tree.getLeft().isLeaf()) {
                tree.swap(tree.getLeft());
                tree.deleteLeaf(tree.getLeft());
            } else {
                BinaryTreeNode<T> node = tree;
                node = node.getLeft().getRightMost();
                tree.swap(node);
                tree = tree.getLeft().getRightMost(node);
                if(node.isLeaf()) {
                    tree.deleteLeaf(node);
                } else {
                    tree = node;
                    deleteNode(tree);
                }
            }
        } else {
            tree.swap(tree.getRight());
            tree.deleteLeaf(tree.getRight());
        }
    }

    private BinaryTreeNode<T> retrieveParent(BinaryTreeNode<T> child, BinaryTreeNode<T> parent) {
        BinaryTreeNode<T> result = null;
        if(parent != null) {
            if(parent.getLeft() == child || parent.getRight() == child) {
                result = parent;
            } else if(child.getValue().compareTo(parent.getLeft().getValue()) < 0) {
                result = retrieveParent(child, parent.getLeft());
            } else {
                result = retrieveParent(child, parent.getRight());
            }
        }
        return result;
    }

    private BinaryTreeNode<T> retrieveNode(T value, BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if(node != null) {
            if(value.equals(node.getValue())) {
                result = node;
            } else if(value.compareTo(node.getValue()) < 0) {
                result = retrieveNode(value, node.getLeft());
            } else {
                result = retrieveNode(value, node.getRight());
            }
        }
        return result;
    }

    private BinaryTreeNode<T> rebalance(BinaryTreeNode<T> tree) {
        if(tree != null) {
            tree.setLeft(rebalance(tree.getLeft()));
            tree.setRight(rebalance(tree.getRight()));
            if(unbalanced(tree)) {
                tree = rotate(tree);
            }
        }
        return tree;
    }

    private BinaryTreeNode<T> rotate(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> newRoot = root;
        if(root != null) {
            if(treeDepth(root.getLeft()) > treeDepth(root.getRight())) {
                newRoot = newRoot.getLeft();
                if(newRoot.getLeft() == null) {
                    newRoot = newRoot.getRight();
                    root.getLeft().setRight(newRoot.getLeft());
                    newRoot.setLeft(root.getLeft());
                    root.setLeft(newRoot.getRight());
                    newRoot.setRight(root);
                } else {
                    root.setLeft(newRoot.getRight());
                    newRoot.setRight(root);
                }
            } else {
                newRoot = newRoot.getRight();
                if(newRoot.getRight() == null) {
                    newRoot = newRoot.getLeft();
                    root.getRight().setLeft(newRoot.getRight());
                    newRoot.setRight(root.getRight());
                    root.setRight(newRoot.getLeft());
                    newRoot.setLeft(root);
                } else {
                    root.setRight(newRoot.getLeft());
                    newRoot.setLeft(root);
                }
            }
        }
        return newRoot;
    }

    private boolean unbalanced(BinaryTreeNode<T> tree) {
        boolean result = false;
        if(tree != null) {
            result = Math.abs(treeDepth(tree.getLeft()) - treeDepth(tree.getRight())) > 1;
        }
        return result;
    }

    private int treeDepth(BinaryTreeNode<T> tree) {
        int result = 0;
        if(tree != null) {
            int left = treeDepth(tree.getLeft());
            int right = treeDepth(tree.getRight());
            result = left > right ? left + 1 : right + 1;
        }
        return result;
    }

    private void addNode(BinaryTreeNode<T> child, BinaryTreeNode<T> parent) {
        if(parent != null) {
            if(child.lessThan(parent)) {
                if(parent.getLeft() == null) {
                    parent.setLeft(child);
                } else {
                    addNode(child, parent.getLeft());
                }
            } else {
                if(parent.getRight() == null) {
                    parent.setRight(child);
                } else {
                    addNode(child, parent.getRight());
                }
            }
        }
    }

    private String toString(BinaryTreeNode<T> tree) {
        StringBuffer result = new StringBuffer();
        if(tree != null) {
            result.append(tree.toString())
		.append(" L[").append(toString(tree.getLeft())).append("]")
		.append(" R[").append(toString(tree.getRight())).append("]");
        }
        return result.toString();
    }
}
