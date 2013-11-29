public interface Queue<T> {
    /**
     * insert(<type>) adds an element to the queue.
     */
    void insert(T value);

    /**
     * retrieve() removes an element from the queue.
     */
    T retrieve();
}
