import java.util.HashSet;
import java.util.Random;

public class Main {

  private static final Random random = new Random(0);

  public static void main(String[] args) {
    benchmark(new MasterSlavePrisoner(), 100000);
    benchmark(new CorrectDayPrisoner(), 100);
    benchmark(new MachineLearningPrisoner(), 1000000);
  }

  /**
   * Simulate and evaluate multiple experiments
   *
   * @param prisoner Type of prisoner to be tested
   * @param runs     Number of runs to be executed
   */
  public static void benchmark(Prisoner prisoner, long runs) {
    long sum = 0;
    long errors = 0;
    for (long i = 0; i < runs; i++) {
      try {
        sum += executeExperiment(prisoner);
      } catch (BadEscapeException e) {
        i--;
        errors++;
      }
    }
    if (errors > 0) {
      System.out.print("(with " + errors + " errors until " + runs + " successful runs): ");
    }
    System.out.println(sum / runs + " days on average");
  }

  /**
   * Simulate one run of prison experiment
   *
   * @param prisoner Type of prisoner to be tested
   * @return Number of days it took to escape
   * @throws BadEscapeException iff escape did not work
   */
  public static long executeExperiment(Prisoner prisoner) throws BadEscapeException {
    HashSet<Integer> prisoners = new HashSet<>();
    Prison prison = prisoner.getPrison();
    int day = 0;
    int prisonerNr;
    do {
      prisonerNr = random.nextInt(100);
      prisoners.add(prisonerNr);
    } while (!prison.nextDay(day++, prisonerNr));
    if (prisoners.size() < 100) {
      throw new BadEscapeException("Wrong result");
    }
    return day;
  }

  /**
   * Exception thrown when escape of prison did not work
   */
  private static class BadEscapeException extends Exception {
    public BadEscapeException(String message) {
      super(message);
    }
  }
}
