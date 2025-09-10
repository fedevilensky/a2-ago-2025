package adts;

public class MinHeap<T, P extends Comparable<P>> implements Heap<T, P> {
  class Pair {
    T fst;
    P snd;

    Pair(T fst, P snd) {
      this.fst = fst;
      this.snd = snd;
    }
  }

  /// Pair<T,P>[]
  Object[] arr;
  int count;

  private void siftUp(int pos) {
    throw RuntimeException("unimplemented");
  }

  private void siftDown(int pos) {
    throw RuntimeException("unimplemented");
  }

  public MinHeap(int expectedSize) {
    this.arr = new Object[expectedSize];
    this.count = 0;
  }

  @Override
  public void push(T elem, P prio) {
    if (count == arr.length) {
      Object[] aux = arr;
      arr = new Object[2 * this.arr.length];
      for (int i = 1; i < this.count; i++) {
        arr[i] = aux[i];
      }
    }

    this.count++;
    this.arr[this.count] = new Pair(elem, prio);
    siftUp(this.count);
  }

  @Override
  public T pop() {
    if (this.count < 1) {
      throw new RuntimeException("heap is empty");
    }
    Pair p = (Pair) arr[1];
    this.arr[1] = this.arr[this.count];
    this.count--;
    siftDown(1);

    return p.fst;
  }

  @Override
  public T top() {
    if (this.count < 1) {
      throw new RuntimeException("heap is empty");
    }
    Pair p = (Pair) arr[1];
    return p.fst;
  }

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public boolean isEmpty() {
    return this.count == 0;
  }

}
