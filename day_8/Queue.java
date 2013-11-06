public class Queue extends SinglyLinkedList {

    public void insert(Node node) {
        super.add(node);
    }

    public Node retrieve() {
	Node head = getHead();
        if(head == null) {
            return null;
        } else {
	    delete(head);
            return head;
        }
    }

    public int size() {
        return super.size();
    }
}
