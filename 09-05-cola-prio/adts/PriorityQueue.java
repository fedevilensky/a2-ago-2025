package adts;

public interface PriorityQueue<T, P extends Comparable<P>> {
  public void push(T elem, P prio);

  public T pop();

  public boolean isEmpty();

  public boolean isFull();

  public int size();
}
