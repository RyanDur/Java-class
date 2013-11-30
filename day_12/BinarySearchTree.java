public interface BinarySearchTree<T> {

    void add(T value);

    boolean contains(T value);

    T getMin();

    T getMax();

    int depth();

    String toString();
}
