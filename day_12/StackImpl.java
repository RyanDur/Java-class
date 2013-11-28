public class StackImpl<T> implements Stack<T> {
    private Node<T> head;

    @Override
    public void push(T value) {
	if(head == null) {
	    head = new Node<T>(value);
	}
    }

    @Override
    public T pop() {
	return null;
    }

    @Override
    public T peek() {
	return head.getValue();
    }

    @Override
    public boolean isEmpty() {
	return false;
    }
}
