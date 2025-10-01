import java.util.Iterator;

import adts.LinkedList;
import adts.List;

public class Main {
  public static void main(String[] args) {
    List<String> l = new LinkedList<>();

    l.insert("a");
    l.insert("b");
    l.insert("c");
    l.insert("d");
    l.insert("e");
    l.insert("f");
    l.insert("g");
    l.insert("h");

    // O(N^2)
    for (int i = 0; i < l.size(); i++) {
      System.out.println(l.get(i));
    }

    // O(N)
    Iterator<String> it = l.iterator();
    while (it.hasNext()) {
      String s = it.next();
      System.out.println(s);
    }

    // O(N)
    for (String s : l) {
      System.out.println(s);
    }
  }
}
