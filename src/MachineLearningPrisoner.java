public class MachineLearningPrisoner extends Prisoner {

  @Override
  Prisoner create(int number) {
    return new MachineLearningPrisoner();
  }

  @Override
  public boolean switchLight(long day, boolean[] bulb) {
    // Why should you be 100% perfect, when you can leave prison after 3 years with 99.6% accuracy?
    return day > 998;
  }
}
