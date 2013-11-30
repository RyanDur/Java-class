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
        if(tree == null) {
            return false;
        }
        return Math.abs(treeDepth(tree.getLeft()) - treeDepth(tree.getRight())) > 1;
    }

    @Override
        public boolean contains(T value) {
        return false;
    }

    @Override
        public T getMin() {
        return null;
    }

    @Override
        public T getMax() {
        return null;
    }

    @Override
        public int depth() {
        return treeDepth(root);
    }

    @Override
        public String toString() {
        return toString(root);
    }

    private int treeDepth(BinaryTreeNode<T> tree) {
        if(tree == null) {
            return 0;
        }
        int left = treeDepth(tree.getLeft());
        int right = treeDepth(tree.getRight());
        return left > right ? left + 1 : right + 1;
    }

    private void addNode(BinaryTreeNode<T> child, BinaryTreeNode<T> parent) {
        if(parent == null) {
            return;
        }
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

    private String toString(BinaryTreeNode<T> tree) {
        if(tree == null) {
            return "";
        }
        String result = tree.toString();
        result += " L[" + toString(tree.getLeft()) + "]";
        result += " R[" + toString(tree.getRight()) + "]";
        return result;
    }
}
