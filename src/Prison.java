public class Prison {

  private final boolean[] bulb = {false};

  private final Prisoner[] prisoners;

  public Prison(Prisoner[] prisoners) {
    this.prisoners = prisoners;
  }

  /**
   * Is called until one prisoner knows everyone was allowed to switch the light
   *
   * @param day      current day starting at 0
   * @param prisoner the prisoner that is allowed to switch the light
   * @return true iff prisoner is sure that everybody was allowed to switch the light
   */
  public final boolean nextDay(int day, int prisoner) {
    return prisoners[prisoner].switchLight(day, bulb);
  }
}
