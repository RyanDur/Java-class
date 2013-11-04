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

    public void insertBefore(NodeDbl before, NodeDbl toInsert) {
        if(before.getNext() != null) {
            toInsert.setNext(before.getNext());
            before.getNext().setLast(toInsert);
        }
        toInsert.setLast(before);
        before.setNext(toInsert);
    }
}
