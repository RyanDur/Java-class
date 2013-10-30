public class SinglyLinkedList {
    private Node nodeListStart = null;
    private Node helper = null;

    public void add(Node node) {
        if (nodeListStart == null) {
            nodeListStart = node;
            helper = node;
        } else if(helper.getNext() == null) {
            helper.setNext(node);
            helper = nodeListStart;
        } else {
            helper = helper.getNext();
            add(node);
        }
    }

    public void delete(Node node) {
        Node temp = node.getNext();
        if(nodeListStart == node) {
            node.setNext(null);
            nodeListStart = temp;
            helper = nodeListStart;
        } else if(helper.getNext() == node) {
            node.setNext(null);
            helper.setNext(temp);
            helper = nodeListStart;
        } else {
            helper = helper.getNext();
            delete(node);
        }
    }

    public void printList() {
        System.out.println(helper.getNode());
        if(helper.getNext() == null) {
            helper = nodeListStart;
            return;
        }
        helper = helper.getNext();
        printList();
    }

    public int size() {
        if(helper.getNext() == null) {
            helper = nodeListStart;
            return 1;
        }
        helper = helper.getNext();
        return 1 + size();
    }
}
