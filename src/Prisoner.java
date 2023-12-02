import java.util.stream.IntStream;

public abstract class Prisoner {

  /**
   * Constructing method for subclasses
   *
   * @param number the number of the prisoner [0,99]
   * @return newly created prisoner
   */
  abstract Prisoner create(int number);

  /**
   * Behavior of prisoner when he is called into room
   *
   * @param day  current day starting at 0
   * @param bulb array of length 1, containing current state of light bulb starting at false
   * @return state of light bulb after leaving the room
   */
  public abstract boolean switchLight(long day, boolean[] bulb);

  /**
   * Create a prison with the corresponding prisoners
   *
   * @return newly created prison
   */
  public final Prison getPrison() {
    return new Prison(IntStream.range(0, 100).mapToObj(this::create).toArray(Prisoner[]::new));
  }
}
