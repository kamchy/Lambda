package pl.chyla.lambda.sam;

import java.util.*;

public class SAM implements Runnable {
  interface Bla {
    void apply(String in);
  }

  public void run () {
    Bla s1 = s -> {System.out.println(s);};
    Bla s2 = s -> {System.out.println("---" + s + "---\n");};
    List<Bla> list = Arrays.asList(new Bla[]{s1, s2});
    List<String> items = Arrays.asList(new String[]{"ala", "ma", "kota"});
    list.forEach(bla -> { items.forEach( s -> { bla.apply(s);});});
  }
}
