public class CrclyLinkedList {
    private Node start = null;
    private Node head = null;

    public void add(Node node) {
        if (start == null) {
            node.setNext(node);
            start = node;
            head = node;
        } else {
            Node last = last(start, start.getNext());
            node.setNext(last.getNext());
            last.setNext(node);
        }
    }

    public void delete(Node node) {
        if(start == node) {
            start = node.getNext();
            head = start;
        }
        Node last = last(node, node.getNext());
        last.setNext(node.getNext());
        node.setNext(null);
    }

    public void printList() {
        System.out.println(head.getNode());
        if(head.getNext() == start) {
            head = start;
        } else {
            head = head.getNext();
            printList();
        }
    }

    public int size() {
        if(head == null) {
            return 0;
        }
        if(head.getNext() == start) {
            head = start;
            return 1;
        }
        head = head.getNext();
        return 1 + size();
    }

    private Node last(Node first, Node next) {
        if(next.getNext() == first) {
            return next;
        }
        return last(first, next.getNext());
    }
}
