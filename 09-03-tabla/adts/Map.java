package adts;

public interface Map<K, V> {
  public void set(K key, V value);

  public V get(K key);

  public boolean contains(K key);

  public void remove(K key);

  public int size();
}
