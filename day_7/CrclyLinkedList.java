public class CrclyLinkedList {
    private Node head = null;

    public void add(Node node) {
        if (head == null) {
	    node.setNext(node);
            head = node;
        }
        node.setNext(head.getNext());
        head.setNext(node);
    }

    public void delete(Node node) {
        if(head == node) {
            head = node.getNext();
        }
        Node last = last(node, node.getNext());
        last.setNext(node.getNext());
        node.setNext(null);
    }

    public void printList() {
        printEach(head, head);
    }

    public int size() {
        return sumEach(head, head);
    }

    private Node last(Node head, Node next) {
        if(next.getNext() == head) {
            return next;
        }
        return last(head, next.getNext());
    }

    private void printEach(Node head, Node next) {
        System.out.println(next.getNode());
        if(next.getNext() == head) {
            return;
        }
        printEach(head, next.getNext());
    }

    private int sumEach(Node head, Node next) {
        if(head == null) {
            return 0;
        }
        if(next.getNext() == head) {
            return 1;
        }
        return 1 + sumEach(head, next.getNext());
    }
}
