package adts;

public interface Heap<T, P extends Comparable<P>> {
  public void push(T elem, P prio);

  public T pop();

  public T top();

  public int size();

  public boolean isEmpty();
}
