public class Stack extends SinglyLinkedList {

    public void push(Node node) {
        super.add(node);
    }

    public Node pop() {
        if(start == null) {
            return null;
        }

        Node found = removeLast(start);
        super.delete(found);
        return found;
    }

    public boolean empty() {
        return super.size() == 0;
    }

    private Node removeLast(Node node) {
        if(node.getNext() == null) {
            return node;
        }
        if(node.getNext().getNext() == null) {
            Node temp = node.getNext();
            node.setNext(null);
            return temp;
        }

        return removeLast(head.getNext());
    }

    public static void main(String []args) {
        Stack stack = new Stack();
        IntegerNode in1 = new IntegerNode(5);
        IntegerNode in2 = new IntegerNode(8);
        IntegerNode in3 = new IntegerNode(12);
        IntegerNode in4 = new IntegerNode(13);

        SinglyLinkedList sl = new SinglyLinkedList();

        stack.push(in1);
        System.out.println("Pushing " + in1.getValue() + "...");

        stack.push(in2);
        System.out.println("Pushing " + in2.getValue() + "...");

        stack.push(in3);
        System.out.println("Pushing " + in3.getValue() + "...");
        System.out.println("Popping... it's a " + stack.pop().getValue());

        stack.push(in4);
        System.out.println("Pushing " + in4.getValue() + "...");

        System.out.println("Popping... it's a " + stack.pop().getValue());
        System.out.println("Popping... it's a " + stack.pop().getValue());
        System.out.println("Popping... it's a " + stack.pop().getValue());
        if(stack.empty()) {
            System.out.println("Stack is empty");
        }
    }
}
