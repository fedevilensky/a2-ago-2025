package adts;

public interface List<T> extends Iterable<T> {
  public void insert(T data);

  public int getPos(T data);

  public T get(int pos);

  public void remove(T data);

  public void removeAt(int pos);

  public int size();

  public boolean isEmpty();

  public boolean contains(T data);
}
