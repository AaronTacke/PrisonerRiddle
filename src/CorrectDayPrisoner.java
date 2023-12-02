public final class CorrectDayPrisoner extends Prisoner {

  private int number;

  // Stores maximum day%100 where light was still on
  private int maxProgress = 0;

  @Override
  Prisoner create(int number) {
    CorrectDayPrisoner newPrisoner = new CorrectDayPrisoner();
    newPrisoner.number = number;
    return newPrisoner;
  }

  @Override
  public boolean switchLight(long day, boolean[] bulb) {
    // Prisoner 0 turns light on if he was there on a 0-day
    if (number == 0 && day % 100 == 0) {
      bulb[0] = true;
    }

    // Remember if light was turned on
    if (bulb[0] && maxProgress < (day % 100)) {
      maxProgress = (int) (day % 100);
    }

    // Turn light off, if it's the wrong date
    if (number != day % 100) {
      bulb[0] = false;
    }

    // Turn light on, if it once reached a latter state
    if (maxProgress > day % 100) {
      bulb[0] = true;
    }

    // Optimization: Remember that you yourself turned light on
    if (bulb[0] && number == day % 100) {
      maxProgress = (int) (day % 100) + 1;
    }

    // Return true iff Prisoner 99 kept light on on 99-day
    return maxProgress == 100;
  }
}
