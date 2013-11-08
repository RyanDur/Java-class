public class DoublyLinkedList {
    private NodeDbl head = null;

    public void add(NodeDbl node) {
        if (head == null) {
            head = node;
        } else {
            addNode(node, head);
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
        System.out.println(head.getValue());
        if(head.getNext() == null) {
            System.out.println();
            System.out.println(head.getValue());
            return;
        }
        head = head.getNext();
        printList();
        head = head.getLast();
        System.out.println(head.getValue());
    }

    public int size() {
        return countNodes(head);
    }

    public NodeDbl getHead() {
        return head;
    }

    private void addNode(NodeDbl node, NodeDbl head) {
        if(head.getNext() == null) {
            head.setNext(node);
            node.setLast(head);
            return;
        }
        addNode(node, head.getNext());
    }

    private int countNodes(NodeDbl node) {
        if(node == null) {
            return 0;
        }
        if(node.getNext() == null) {
            return 1;
        }
        return 1 + countNodes(node.getNext());
    }

    public static void main(String []args) {
        DoublyLinkedList manager = new DoublyLinkedList();
        PatientNodeDbl patient1 = new PatientNodeDbl(new Patient("John", 33, "Tuberculosis"));
        PatientNodeDbl patient2 = new PatientNodeDbl(new Patient("Fliss", 21, "Video Game Addiction"));
        PatientNodeDbl patient3 = new PatientNodeDbl(new Patient("Keimi", 21, "Recursion"));
        PatientNodeDbl patient4 = new PatientNodeDbl(new Patient("David", 56, "Essixosis"));
        PatientNodeDbl patient5 = new PatientNodeDbl(new Patient("Joe", 3, "Governmental politics"));
        PatientNodeDbl patient6 = new PatientNodeDbl(new Patient("Ludovic", 99, "French"));
        PatientNodeDbl patient7 = new PatientNodeDbl(new Patient("Sergio", 10, "Teaching"));
        PatientNodeDbl patient8 = new PatientNodeDbl(new Patient("Kieth", 15, "Fell down"));
        PatientNodeDbl patient9 = new PatientNodeDbl(new Patient("Oded", 9, "Helping"));
        PatientNodeDbl patient10 = new PatientNodeDbl(new Patient("Sokratis", 12, "Java script"));

        System.out.println(manager.size());

        manager.add(patient1);
        manager.add(patient2);
        manager.add(patient3);
        manager.add(patient4);
        manager.add(patient5);
        manager.add(patient6);
        manager.add(patient7);
        manager.add(patient8);
        manager.add(patient9);
        manager.add(patient10);

        manager.printList();
        System.out.println(manager.size());

        manager.delete(patient2);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient6);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient3);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient10);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient1);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient4);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient7);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.add(new PatientNodeDbl(new Patient("Ryan", 34, "Too tall")));
        System.out.println(" ");
        manager.printList();
        System.out.println(manager.size());

    }
}
