public class StackImpl<T extends Number> implements Stack<T> {
    private Node<T> head;

    @Override
    public void push(T value) {
        if(head == null) {
            head = new Node<>(value);
        } else {
            Node<T> newHead = new Node<>(value);
            newHead.setNext(head);
            head = newHead;
        }
    }

    @Override
    public T pop() {
        T result = null;
	if(head != null) {
	    Node<T> oldHead = head;
	    head = head.getNext();
	    oldHead.setNext(null);
	    result = oldHead.getValue();
	}
        return result;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
