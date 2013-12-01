public interface BinarySearchTree<T> {

    void add(T value);

    void delete(T value);

    boolean contains(T value);

    T getMin();

    T getMax();

    int depth();

    String toString();
}
