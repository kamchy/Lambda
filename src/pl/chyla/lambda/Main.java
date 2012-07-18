package pl.chyla.lambda;
import pl.chyla.lambda.sam.*;

public class Main {
  public static void main(String[] args) {
    Runnable[] examples = { 
      new FunctionalCollections(),
      new Factory(),
      new SAM()
    };
    for (Runnable r: examples) {
      r.run();
    }
  }
}
