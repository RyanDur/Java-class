public class DoublyLinkedListImpl<T extends Comparable<T>> implements DoublyLinkedList<T> {
    BiNode<T> head = null;

    @Override
    public void add(T value) {
        if(head == null) {
            head = new BiNode<>(value);
        } else {
            addNode(new BiNode<>(value), head);
        }
    }

    @Override
    public void delete(T value) {
        BiNode<T> node = retrieve(value, head);

        if(head == node) {
            head = head.getRight();
        }
        if(node.getRight() != null) {
            node.getRight().setLeft(node.getLeft());
        }
        if(node.getLeft() != null) {
            node.getLeft().setRight(node.getRight());
        }
        node.setRight(null);
        node.setLeft(null);
    }

    @Override
    public int size() {
        return nodeCount(head);
    }

    @Override
    public String toString() {
        return toString(head);
    }

    private BiNode<T> retrieve(T value, BiNode<T> node) {
        if(node == null) {
            return null;
        }
        if(node.getValue().equals(value)) {
            return node;
        }
        return retrieve(value, node.getRight());
    }

    private int nodeCount(BiNode<T> node) {
        if(node == null) {
            return 0;
        }
        return 1 + nodeCount(node.getRight());
    }

    private String toString(BiNode<T> node) {
        StringBuffer buffer = new StringBuffer();
        if(node != null) {
            buffer.append(node);
            if(node.getRight() != null) {
                buffer.append(" ");
            }
            buffer.append(toString(node.getRight()));
        }
        return buffer.toString();
    }

    private void addNode(BiNode<T> node, BiNode<T> head) {
        if(head.getRight() == null) {
            head.setRight(node);
            node.setLeft(head);
        } else {
            addNode(node, head.getRight());
        }
    }
}
