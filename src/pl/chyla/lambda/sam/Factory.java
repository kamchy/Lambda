package pl.chyla.lambda.sam;
import java.util.regex.*;
import java.util.*;

public class Factory implements Runnable {
  private static Pattern PARSE_PATTERN = Pattern.compile("SI(\"(\\w)*\",(\\d)*)");

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
    static SI UNDEFINED = new SI("Undefined", 0);
    SI(String s, Integer i) { super(s, i); }

    @Override
    public String toString() {
      return "SI(\"" + first + "\", " + second + ")"; 
    }

    public static SI create(String s) { 
      Matcher m = Factory.PARSE_PATTERN.matcher(s);
      if (m.matches()) {
        String name = m.group(1);
        String value = m.group(2);
        return new SI(name, Integer.parseInt(value));
      } else {
        return  SI.UNDEFINED;
      }
    }
  }

  public void run() {

    
    String[] data = new String[] {"SI(\"Kamila\", 34)", "SI(\"Maciuś\", 5)", "SI(\"Tatuś\", 36)"};
    Arrays.asList(data).map(SI::create).forEach(System.out::println);
  }
}
