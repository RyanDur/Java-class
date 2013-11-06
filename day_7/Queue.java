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

    public static void main(String []args) {
        Queue queue = new Queue();
        IntegerNode in1 = new IntegerNode(5);
        IntegerNode in2 = new IntegerNode(8);
        IntegerNode in3 = new IntegerNode(12);
        IntegerNode in4 = new IntegerNode(13);

        System.out.println("There are " + queue.size() + " requests in the queue.");

        queue.insert(in1);
        System.out.println("Inserting request " + in1.getValue() + "...");
        queue.insert(in2);
        System.out.println("Inserting request " + in2.getValue() + "...");
        queue.insert(in3);
        System.out.println("Inserting request " + in3.getValue() + "...");

        System.out.println("There are " + queue.size() + " requests in the queue.");

        System.out.println("Retrieving request " + queue.retrieve().getValue() + "... done");
        queue.insert(in4);
        System.out.println("Inserting request " + in4.getValue() + "...");

        System.out.println("There are " + queue.size() + " requests in the queue.");

        System.out.println("Retrieving request " + queue.retrieve().getValue() + "... done");
        System.out.println("Retrieving request " + queue.retrieve().getValue() + "... done");

        System.out.println("There are " + queue.size() + " requests in the queue.");
    }
}
