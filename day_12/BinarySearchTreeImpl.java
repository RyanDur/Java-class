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
                    deleteLeaf(subTree, retrieveParent(subTree, root));
                } else {
                    deleteNode(subTree);
                }
            }
        }
        root = rebalance(root);
    }

    @Override
    public boolean contains(T value) {
        return retrieveNode(value, root) != null;
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

    private BinaryTreeNode<T> getLeftMost(BinaryTreeNode<T> node, BinaryTreeNode<T> condition) {
        BinaryTreeNode<T> result = null;
        if(node != null) {
            if(node.getLeft() == condition) {
                result = node;
            } else {
                result = getLeftMost(node.getLeft(), condition);
            }
        }
        return result;
    }

    private BinaryTreeNode<T> getRightMost(BinaryTreeNode<T> node, BinaryTreeNode<T> condition) {
        BinaryTreeNode<T> result = null;
        if(node != null) {
            if(node.getRight() == condition) {
                result = node;
            } else {
                result = getRightMost(node.getRight(), condition);
            }
        }
        return result;
    }

    private void deleteNode(BinaryTreeNode<T> tree) {
        if(tree.getLeft() != null) {
            if(tree.getLeft().isLeaf()) {
                tree.swap(tree.getLeft());
                deleteLeaf(tree.getLeft(), tree);
            } else {
                BinaryTreeNode<T> node = tree;
                node = getRightMost(node.getLeft(), null);
                tree.swap(node);
                tree = getRightMost(tree.getLeft(), node);
                if(node.isLeaf()) {
                    deleteLeaf(node, tree);
                } else {
                    tree = node;
                    deleteNode(tree);
                }
            }
        } else {
            if(tree.getRight().isLeaf()) {
                tree.swap(tree.getRight());
                deleteLeaf(tree.getRight(), tree);
            } else {
                BinaryTreeNode<T> node = tree;
                node = getLeftMost(node.getRight(), null);
                tree.swap(node);
                tree = getLeftMost(tree.getRight(), node);
                if(node.isLeaf()) {
                    deleteLeaf(node, tree);
                } else {
                    tree = node;
                    deleteNode(tree);
                }
            }
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

    private void deleteLeaf(BinaryTreeNode<T> child, BinaryTreeNode<T> parent) {
        if(child.isLeaf()) {
            if(parent.getLeft() == child) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
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
