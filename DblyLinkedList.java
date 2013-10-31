public class DblyLinkedList {
    private NodeDbl head = null;

    public void add(NodeDbl node) {
        if (head == null) {
            head = node;
        } else if(head.getNext() == null) {
            head.setNext(node);
            node.setLast(head);
            resetHead();
        } else {
            head = head.getNext();
            add(node);
        }
    }

    public void delete(NodeDbl node) {
	if(head == node) {
	    head = head.getNext();
	}
        if(node.getNext() != null) {
            node.getNext().setLast(node.getLast());
        }
        if(node.getLast() != null) {
            node.getLast().setNext(node.getNext());
        }
        node.setNext(null);
        node.setLast(null);
    }

    public void printList() {
        System.out.println(head.getNode());
        if(head.getNext() == null) {
            resetHead();
        } else {
            head = head.getNext();
            printList();
        }
    }

    public int size() {
        if(head == null) {
            return 0;
        }
        if(head.getNext() == null) {
            resetHead();
            return 1;
        }
        head = head.getNext();
        return 1 + size();
    }

    private void resetHead() {
	if(head.getLast() != null) {
	    head = head.getLast();
	    resetHead();
	}
    }
}
