package adts;

public class Edge {
  public int ori, dest, cost;

  public Edge(int ori, int dest) {
    this.ori = ori;
    this.dest = dest;
    this.cost = 1;
  }

  public Edge(int ori, int dest, int cost) {
    this.ori = ori;
    this.dest = dest;
    this.cost = cost;
  }

  @Override
  public boolean equals(Object obj) {
    Edge other = (Edge) obj;
    return this.ori == other.ori && this.dest == other.dest;
  }
}
