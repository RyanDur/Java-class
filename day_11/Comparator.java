public class Comparator<T extends Comparable<T>> {
    public T getMax(T n, T m) {
        if (n.compareTo(m) < 0) {
            return m;
        } else {
            return n;
        }
    }
}
