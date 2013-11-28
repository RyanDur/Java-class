public interface Stack<T> {
    /**
     * push(<type>) puts an element at the top of the stack.
     */
    void push(T value);

    /**
     * pop() removes the element at the top of the stack and returns it.
     */
    T pop();

    /**
     * peek() returns the element at the top of the stack, but does not remove it from the stack.
     */
    T peek();

    /**
     * isEmpty() returns true if there are no elements on the stack, false otherwise.
     */
    boolean isEmpty();
}
