public class SinglyLinkedList {
    private Node head = null;

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
	    Node temp = head;
	    while(temp.getNext() != null) {
		temp = temp.getNext();
	    }
	    temp.setNext(node);
        }
    }

    public void delete(Node node) {
        if(head == null) {
            return;
        }
        if(head == node) {
	    head = head.getNext();
            node.setNext(null);
        }else {
	    Node temp = head;
	    while(temp.getNext() != null && temp.getNext() != node) {
		temp = temp.getNext();
	    }
	    temp.setNext(node.getNext());
	    node.setNext(null);
	}
    }

    public void printList() {
	printEach(head);
    }

    public int size() {
        return countNodes(head);
    }

    public Node getHead() {
	return head;
    }

    private void printEach(Node node) {
	System.out.println(node.getValue());
        if(node.getNext() == null) {
            return;
        }
        printEach(node.getNext());
    }

    private int countNodes(Node node) {
	if(node == null) {
            return 0;
        }
        if(node.getNext() == null) {
            return 1;
        }
	return 1 + countNodes(node.getNext());
    }
}
