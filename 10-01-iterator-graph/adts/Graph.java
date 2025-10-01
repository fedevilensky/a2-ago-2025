package adts;

public interface Graph {
  int vertices();

  Iterable<Edge> neighbors(int v);

  void addEdge(int v, int w);

  void addEdge(int v, int w, int cost);

  void removeEdge(int v, int w);

  Iterable<Edge> edges();

  boolean isNeighbor(int v, int w);

  int getCost(int v, int w);

}
