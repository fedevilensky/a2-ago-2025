package adts;

public class Pair<T1, T2> {

  public T1 fst;
  public T2 snd;

  @Override
  public boolean equals(Object obj) {
    Pair<T1, T2> other = (Pair<T1, T2>) obj;
    return this.fst == other.fst;
  }

  public Pair() {
  }

  public Pair(T1 fst) {
    this.fst = fst;
  }

  public Pair(T1 fst, T2 snd) {
    this.fst = fst;
    this.snd = snd;
  }
}
