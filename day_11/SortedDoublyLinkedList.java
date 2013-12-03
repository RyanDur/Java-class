public class SortedDoublyLinkedList<T extends Comparable<T>> extends DoublyLinkedListImpl<T> {

    public void add(T value) {
        if(head == null) {
            head = new BiNode<T>(value);
        } else {
            sortedAddNode(new BiNode<T>(value), head);
            if(head.getLeft() != null) {
                head = head.getLeft();
            }
        }
    }

    private void sortedAddNode(BiNode<T> node, BiNode<T> head) {
        if(node != null) {
            if(canInsert(node, head)) {
                setBefore(node, head);
            } else if(head.getRight() == null) {
                head.setRight(node);
                node.setLeft(head);
            } else {
                sortedAddNode(node, head.getRight());
            }
        }
    }

    private boolean canInsert(BiNode<T> node, BiNode<T> head) {
        return node.lessThan(head) && (head.getLeft() == null || !node.lessThan(head.getLeft()));
    }

    private void setBefore(BiNode<T> node, BiNode<T> head) {
        node.setRight(head);
        node.setLeft(head.getLeft());
        head.setLeft(node);
        if(node.getLeft() != null) {
            node.getLeft().setRight(node);
        }
    }
}
