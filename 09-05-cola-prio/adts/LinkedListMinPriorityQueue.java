package adts;

public class LinkedListMinPriorityQueue<T, P extends Comparable<P>>
    implements PriorityQueue<T, P> {

  class PriorityPair {
    T fst;
    P snd;

    PriorityPair(T fst, P snd) {
      this.fst = fst;
      this.snd = snd;
    }
  }

  private List<PriorityPair> l = new LinkedList<>();

  LinkedListMinPriorityQueue() {
  }

  @Override
  public void push(T elem, P prio) {
    l.insert(new PriorityPair(elem, prio));
  }

  @Override
  public T pop() {
    if (this.isEmpty()) {
      throw new RuntimeException("no hay elementos!!");
    }

    PriorityPair min = l.get(0);
    int minPos = 0;
    for (int i = 1; i < l.size(); i++) {
      PriorityPair curr = l.get(i);
      // if (curr.snd < min.snd) {
      if (curr.snd.compareTo(min.snd) < 0) {
        min = curr;
        minPos = i;
      }
    }

    l.removeAt(minPos);
    return min.fst;
  }

  @Override
  public boolean isEmpty() {
    return l.isEmpty();
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public int size() {
    return l.size();
  }

}
