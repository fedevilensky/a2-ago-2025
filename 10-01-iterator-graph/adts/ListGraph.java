package adts;

public class ListGraph implements Graph {
  /// List\<Edge\>[]
  Object[] edges;

  public ListGraph(int vertices) {
    this.edges = new Object[vertices + 1];
    for (int i = 1; i <= vertices; i++) {
      this.edges[i] = new LinkedList<Edge>();
    }
  }

  @Override
  public int vertices() {
    return this.edges.length - 1;
  }

  @Override
  public Iterable<Edge> neighbors(int v) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'neighbors'");
  }

  @Override
  public void addEdge(int v, int w) {
    addEdge(v, w, 1);
  }

  @Override
  public void addEdge(int v, int w, int cost) {
    Edge newEdge = new Edge(v, w, cost);

    LinkedList<Edge> neighbors = (LinkedList<Edge>) this.edges[v];
    neighbors.remove(newEdge);

    neighbors.insert(newEdge);
  }

  @Override
  public Iterable<Edge> edges() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'edges'");
  }

  @Override
  public boolean isNeighbor(int v, int w) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isNeighbor'");
  }

  @Override
  public int getCost(int v, int w) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCost'");
  }

  @Override
  public void removeEdge(int v, int w) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
  }
}
