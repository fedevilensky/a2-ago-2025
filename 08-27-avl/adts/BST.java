package adts;

public interface BST<T extends Comparable<T>> {
  void insert(T data);

  void remove(T data);

  int height();

  int size();

  boolean contains(T data);

  T get(T data);

  T min();

  T max();
}
