public class StackImpl<T> implements Stack<T> {
    private Node<T> head;

    @Override
    public void push(T value) {
	if(isEmpty()) {
	    head = new Node<T>(value);
	} else {
	    Node<T> newNode = new Node<T>(value);
	    newNode.setNext(head);
	    head = newNode;
	}
    }

    @Override
    public T pop() {
	Node<T> oldHead = head;
	head = head.getNext();
	oldHead.setNext(null);
	return oldHead.getValue();
    }

    @Override
    public T peek() {
	return head.getValue();
    }

    @Override
    public boolean isEmpty() {
	return head == null;
    }
}
