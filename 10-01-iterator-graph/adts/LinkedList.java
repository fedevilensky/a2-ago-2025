package adts;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
  class LinkedListNode {
    T data;
    LinkedListNode next = null;

    LinkedListNode(T data) {
      this.data = data;
    }
  }

  class LinkedListIterator implements Iterator<T> {
    LinkedListNode curr;

    LinkedListIterator(LinkedListNode start) {
      this.curr = start;
    }

    @Override
    public boolean hasNext() {
      return this.curr != null;
    }

    @Override
    public T next() {
      T ret = this.curr.data;
      this.curr = this.curr.next;

      return ret;
    }
  };

  private LinkedListNode head = null;
  private int length = 0;

  @Override
  public void insert(T data) {
    LinkedListNode newNode = new LinkedListNode(data);
    if (this.head == null) {
      head = newNode;
      this.length++;
      return;
    }
    // else head != null

    LinkedListNode aux = this.head;
    while (aux.next != null) {
      aux = aux.next;
    }

    aux.next = newNode;
    this.length++;
  }

  @Override
  public int getPos(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPos'");
  }

  @Override
  public T get(int pos) {
    if (pos >= this.length) {
      throw new RuntimeException("out of range");
    }

    LinkedListNode aux = this.head;
    for (int i = 0; i < pos; i++) {
      aux = aux.next;
    }

    return aux.data;
  }

  @Override
  public void remove(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public void removeAt(int pos) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeAt'");
  }

  @Override
  public int size() {
    return this.length;
  }

  @Override
  public boolean isEmpty() {
    return this.length == 0;
  }

  @Override
  public boolean contains(T data) {
    LinkedListNode aux = this.head;

    while (aux != null) {
      if (aux.data.equals(data)) {
        return true;
      }
      aux = aux.next;
    }

    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator(this.head);
  }

}
