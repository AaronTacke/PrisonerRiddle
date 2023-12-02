public final class MasterSlavePrisoner extends Prisoner {

  private int number;

  // Master (number==0): Counts visited prisoners
  // Slave (number!=0): 0 iff never turned light on
  private int memory = 0;

  @Override
  Prisoner create(int number) {
    MasterSlavePrisoner newPrisoner = new MasterSlavePrisoner();
    newPrisoner.number = number;
    return newPrisoner;
  }

  @Override
  public boolean switchLight(long day, boolean[] bulb) {
    if (number == 0) {
      // The master is called to the room

      if (bulb[0]) {
        // memorizes if new prisoner visited
        memory++;
        bulb[0] = false;
      }

      // returns true when all other prisoners visited
      return memory == 99;

    } else {
      // A slave is called to the room

      if (!bulb[0] && memory == 0) {
        // Switches light bulb on once, if he never visited before
        bulb[0] = true;
        memory++;
      }

      return false;
    }
  }
}
