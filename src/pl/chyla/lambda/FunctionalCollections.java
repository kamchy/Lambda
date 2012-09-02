package pl.chyla.lambda;

import java.util.Arrays;
import java.util.*;
import java.util.Random;



public class FunctionalCollections implements Runnable {
  static Random R = new Random(123123);

  public void run() {

    String[] workers = new String[] {
        "Marcus Widner",
        "Melissa Siebelmann",
        "Anne Jurge",
        "Filif Voegel",
        "Christine Zalemba",
        "Witold Applebaum"
    };

    List<Worker> workersList = prepareWorkersWithScores(workers);
    float passingScore = 0.25F;
    printAll(workersList);
    printWorkersScoreRaport(workersList, passingScore);
  }

  private static void printAll(List<Worker> wl) {
    wl.forEach(w -> {System.out.println(w);});
  }

  private static void printWorkersScoreRaport(List<Worker> workersList, float passingScore) {
    workersList
      .filter(w -> w.getScore() > passingScore) 
      .forEach(w -> {Raport.printMessage(w, true);});

  }

  private static List<Worker> prepareWorkersWithScores(String[] workers) {
    return Arrays.asList(workers)
    .map(s -> new Worker(s)) // Mapper
    .map(w -> {w.setScore(R.nextFloat()); return w;})//Block
    .into(new ArrayList<Worker>());

  }


  public static final class Raport {
    private static final String PASSED = "YES! %s, you passed with %s!";
    private static final String NOT_PASSED = "Uuuuu! %s, you havent passed with %s...";
    public static void printMessage(Worker w, boolean passed) {
      String message = String.format( passed ? PASSED : NOT_PASSED, w.fName, w.score);
      System.out.println(message);
    }

    public static void raport(boolean pass, Collection<Worker> workers) {
      System.out.format((pass ? "" : "NOT ") + "PASSED: %s", pass, workers.size());
    }
  }

  public static final class Worker {
    private String lName;
    private String fName;
    private float score;

    public Worker(String names) {
      String[] split = names.split(" ");
      if (split.length == 2) {
        fName = split[0]; lName = split[1];
      } else {
        fName = lName = "undefined";
      }
    }

    String getlName() { return lName; }
    String getfName() { return fName; }

   float getScore() { return score; }
   void setScore(float newScore) {score = newScore;}


    @Override
    public String toString(){
      return String.format("[%s,  %s] - %f", lName, fName, score);
    }

  }
}
