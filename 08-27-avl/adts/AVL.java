package adts;

public class AVL<T extends Comparable<T>> implements BST<T> {
  class AVLNode {
    T data;
    int height = 1;
    AVLNode left = null;
    AVLNode right = null;

    AVLNode(T data) {
      this.data = data;
    }
  }

  AVLNode root = null;
  int count = 0;

  int max(int a, int b) {
    if (a > b) {
      return a;
    }
    return b;
  }

  int height(AVLNode n) {
    if (n == null) {
      return 0;
    }

    return n.height;
  }

  private T minNode(AVLNode n) {
    if (n == null) {
      throw new RuntimeException("null pointer reached");
    }

    if (n.left != null) {
      return minNode(n.left);
    } else {
      return n.data;
    }
  }

  private T maxNode(AVLNode n) {
    if (n == null) {
      throw new RuntimeException("null pointer reached");
    }

    if (n.right != null) {
      return maxNode(n.right);
    } else {
      return n.data;
    }
  }

  private AVLNode rebalance(AVLNode n) {
    int bF = height(n.left) - height(n.right);

    if (bF < 1) { // desbalance der-?
      AVLNode aux = n.right;
      bF = height(aux.left) - height(aux.right);

      if (bF < 0) { // desbalance der-der
        n = leftRotation(n);
      } else {// desbalance der-izq
        // bF > 0
        n = rightLeftRotation(n);
      }

    } else if (bF > 1) { // desbalance izq-?
      AVLNode aux = n.left;
      bF = height(aux.left) - height(aux.right);

      if (bF < 0) { // desbalance izq-der
        n = leftRightRotation(n);
      } else { // desbalance izq-izq
        // bF > 0
        n = rightRotation(n);
      }
    }

    return n;
  }

  private AVLNode leftRotation(AVLNode z) {
    AVLNode y = z.right;
    AVLNode yLeft = y.left;

    y.left = z;
    z.right = yLeft;

    z.height = 1 + max(height(z.left), height(z.right));
    y.height = 1 + max(height(y.left), height(y.right));

    return y;

  }

  private AVLNode insert(T data, AVLNode n) {
    if (n == null) {
      this.count++;
      return new AVLNode(data);
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

    n = rebalance(n);

    return n;

  }

  private boolean contains(T data, AVLNode n) {
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
