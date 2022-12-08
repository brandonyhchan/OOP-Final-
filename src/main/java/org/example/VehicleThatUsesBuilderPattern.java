package org.example;

//TODO: Refer to run BuilderPattern after reading through this

/**
 * Builder pattern allows us to create a vehicle that may have different features. in this case a vehicle may
 * or may not have a sunroof. So all vehicles have to have an engine and wheels, but not all vehicles have a
 * sunroof.
 *
 */

public class VehicleThatUsesBuilderPattern {

  //all vehicles need this (required parameters)
  private String engine;
  private int wheel;

  //not all vehicles will have this (optional parameter)
  boolean sunroof;

  /**
   * This constructor is private because only the builder can create a Vehicle! builder class is below.
   * @param builder
   */
  private VehicleThatUsesBuilderPattern(BuilderPattern builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.sunroof = builder.sunroof;
  }

  /**
   * If you noticed, this class only has getters and thats because we dont set anything in the vehicle class, everything
   * gets set in the builder class.
   */

  public String getEngine() {
    return this.engine;
  }

  public int getWheel() {
    return wheel;
  }

  public boolean hasSunroof() {
    return sunroof;
  }

  /**
   * This is the builder class. I am assuming that the builder should be inside the object that implements the builder
   * pattern because when i called it outside it didnt work for me but you guys can try!
   */
  public static class BuilderPattern {

    // required parameters that all cars have
    private String engine;
    private int wheel;

    //an optional parameter
    private boolean sunroof;

    //Constructor of builder pattern will have everything that is neccessary for a car
    public BuilderPattern(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    /**
     * If we want to give a car a sunroof, we have to put it in the setter to give it that value
     * @param sunroof
     * @return
     */
    public BuilderPattern hasSunroof(boolean sunroof) {
      this.sunroof = sunroof;
      return this;
    }

    /**
     * This is what we call to create the vehicle
     * @return
     */
    public VehicleThatUsesBuilderPattern build() {
      return new VehicleThatUsesBuilderPattern(this);
    }

  }

}

