public class SortList extends DoublyLinkedList {

    public void add(NodeDbl node) {
        super.add(node);
    }

    public void delete(NodeDbl node) {
        super.delete(node);
    }

    public void printList() {
        super.printList();
    }

    public int size() {
        return super.size();
    }

    public NodeDbl getHead() {
        return super.getHead();
    }

    public void swap(NodeDbl first, NodeDbl second) {
	Object temp = first.getValue();
	first.setValue(second.getValue());
	second.setValue(temp);
    }

    public void addAll(SortList list) {
	copy(list.getHead());
    }

    private void copy(NodeDbl head) {
	if(head == null) {
	    return;
	}
	add(new NodeDbl(head.getValue()));
	copy(head.getNext());
    }
}
