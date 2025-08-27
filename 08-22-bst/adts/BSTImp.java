package adts;

public class BSTImp<T extends Comparable<T>> implements BST<T> {
  class BSTNode {
    T data;
    int height = 1;
    BSTNode left = null;
    BSTNode right = null;

    BSTNode(T data) {
      this.data = data;
    }
  }

  BSTNode root = null;
  int count = 0;

  int max(int a, int b) {
    if (a > b) {
      return a;
    }
    return b;
  }

  int height(BSTNode n) {
    if (n == null) {
      return 0;
    }

    return n.height;
  }

  private T minNode(BSTNode n) {
    if (n == null) {
      throw new RuntimeException("null pointer reached");
    }

    if (n.left != null) {
      return minNode(n.left);
    } else {
      return n.data;
    }
  }

  private T maxNode(BSTNode n) {
    if (n == null) {
      throw new RuntimeException("null pointer reached");
    }

    if (n.right != null) {
      return maxNode(n.right);
    } else {
      return n.data;
    }
  }

  private BSTNode insert(T data, BSTNode n) {
    if (n == null) {
      this.count++;
      return new BSTNode(data);
    }

    // data < n.data
    if (data.compareTo(n.data) < 0) {
      n.left = insert(data, n.left);
    }
    // data > n.data
    else if (data.compareTo(n.data) > 0) {
      n.right = insert(data, n.right);
    }

    n.height = 1 + max(height(n.left), height(n.right));

    return n;

  }

  private boolean contains(T data, BSTNode n) {
    if (n == null) {
      return false;
    }

    if (data.compareTo(n.data) == 0) {
      return true;
    }

    if (data.compareTo(n.data) < 0) {
      return contains(data, n.left);
    } else if (data.compareTo(n.data) > 0) {
      return contains(data, n.right);
    }

    throw new RuntimeException("Unreachable code reached");
  }

  @Override
  public void insert(T data) {
    this.root = insert(data, this.root);
  }

  @Override
  public void remove(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public int height() {
    return height(this.root);
  }

  @Override
  public int size() {
    return this.count;
  }

  @Override
  public boolean contains(T data) {
    return contains(data, this.root);
  }

  @Override
  public T get(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public T min() {
    return minNode(this.root);
  }

  @Override
  public T max() {
    return maxNode(this.root);
  }

}
