package pl.chyla.lambda.sam;
import java.util.regex.*;
import java.util.*;

public class Factory implements Runnable {

  static interface Creator<T> {
    public T create(String s);
  }

  static class  Pair<F, S> {
    protected F first;
    protected S second;

    public Pair(F f, S s) {
      first = f;
      second = s;
    }
  }


  static class SI extends Pair<String, Integer> { 
    private static final SI UNDEFINED = new SI("Undefined", 0);

    SI(String s, Integer i) { super(s, i); }

    @Override
    public String toString() {
      return "SI(\"" + first + "\", " + second + ")"; 
    }

    public static SI create(String s) { 
        return  SI.UNDEFINED;
    }
  }

  public void run() {
    String[] data = new String[] {"SI(\"Kamila\", 34)", "SI(\"Maciuś\", 5)", "SI(\"Tatuś\", 36)"};
    Arrays.asList(data).map(SI::create).forEach(System.out::println);
  }
}

