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
        return head;
    }

    public void swap(NodeDbl first, NodeDbl second) {
	Object temp = first.getValue();
	first.setValue(second.getValue());
	second.setValue(temp);
    }
}
