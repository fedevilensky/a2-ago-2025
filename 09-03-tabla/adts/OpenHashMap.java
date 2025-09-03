package adts;

import functions.hash.HashFunc;

public class OpenHashMap<K, V> implements Map<K, V> {
  /// List<Pair<K,V>>
  Object[] arr;
  private int count = 0;
  private HashFunc<K> h;

  private int abs(int x) {
    if (x < 0) {
      return -x;
    }

    return x;
  }

  private int getPos(K key) {
    return abs(h.hash(key) % this.arr.length);
  }

  public OpenHashMap(int expectedSize, HashFunc<K> h) {
    this.h = h;
    this.arr = new Object[2 * expectedSize - 1];
  }

  @Override
  public void set(K key, V value) {
    remove(key);

    int pos = getPos(key);

    if (this.arr[pos] == null) {
      this.arr[pos] = new LinkedList<Pair<K, V>>();
    }

    List<Pair<K, V>> bucket = (List<Pair<K, V>>) this.arr[pos];
    bucket.insert(new Pair<K, V>(key, value));
    this.count++;
  }

  @Override
  public V get(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public boolean contains(K key) {
    int pos = getPos(key);

    if (this.arr[pos] == null) {
      return false;
    }

    List<Pair<K, V>> l = (List<Pair<K, V>>) this.arr[pos];
    return l.contains(new Pair<K, V>(key));
  }

  @Override
  public void remove(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'size'");
  }
}
