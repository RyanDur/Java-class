public class SortedLinkedList extends SinglyLinkedList {

    public void add(Node node) {
	super.add(node);
    }

    public void delete(Node node) {
	super.delete(node);
    }

    public void printList() {
	super.printList();
    }

    public int size() {
	return super.size();
    }

    public void insert(Node node) {
	if(start == null) {
	    add(node);
	} else if(start.compare(node)) {
	    node.setNext(start);
	    head = start = node;
	} else if(head.getNext() == null){
	    add(node);
	} else if(head.getNext().compare(node)) {
	    node.setNext(head.getNext());
	    head.setNext(node);
	    head = start;
	} else {
	    head = head.getNext();
	    insert(node);
	}
    }
}
