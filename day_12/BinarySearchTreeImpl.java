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
    public boolean contains(T value) {
        return containsNode(value, root);
    }

    @Override
    public T getMin() {
        T result = null;
        if(root != null) {
            BinaryTreeNode<T> node = root;
            while(node.getLeft() != null) {
                node = node.getLeft();
            }
            result = node.getValue();
        }
        return result;
    }

    @Override
    public T getMax() {
        T result = null;
        if(root != null) {
            BinaryTreeNode<T> node = root;
            while(node.getRight() != null) {
                node = node.getRight();
            }
            result = node.getValue();
        }
        return result;
    }

    @Override
    public int depth() {
        return treeDepth(root);
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private boolean containsNode(T value, BinaryTreeNode<T> tree) {
        boolean result = false;
        if(tree != null) {
            if(value.equals(tree.getValue())) {
                result = true;
            } else if(value.compareTo(tree.getValue()) < 0) {
                result = containsNode(value, tree.getLeft());
            } else {
                result = containsNode(value, tree.getRight());
            }
        }
        return result;
    }

    private BinaryTreeNode<T> rebalance(BinaryTreeNode<T> tree) {
        if(tree != null && unbalanced(tree)) {
            tree.setLeft(rebalance(tree.getLeft()));
            tree.setRight(rebalance(tree.getRight()));
            tree = rotate(tree);
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
        String result = "";
        if(tree != null) {
            result = tree.toString();
            result += " L[" + toString(tree.getLeft()) + "]";
            result += " R[" + toString(tree.getRight()) + "]";
        }
        return result;
    }
}
