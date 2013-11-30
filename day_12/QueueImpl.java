public class QueueImpl<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void insert(T value) {
        if(head == null) {
            head = tail = new Node<>(value);
        } else {
            tail.setNext(new Node<>(value));
            tail = tail.getNext();
        }
    }

    @Override
    public T retrieve() {
        T result = null;
        if(head != null) {
            Node<T> oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
            return oldHead.getValue();
        }
        return result;
    }
}
