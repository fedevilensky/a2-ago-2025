import adts.LinkedList;
import adts.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> l = new LinkedList<>();

    for (int i = 0; i < 10; i++) {
      l.insert(i);
    }

    for (int i = 0; i < 11; i++) {
      System.out.println(l.get(i));
    }
  }

}
