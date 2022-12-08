package org.example;

//TODO: Read VehicleThatUsesBuilderPattern

public class runBuilderPattern {

  public static void main(String[] args) {

    /**
     * This is what we use to make a new vehicle. We create a new vehicle, and call builder pattern on it and put
     * the parameters in there, then we set the sunroof if we want to give it a sunroof, and we call build to create the
     * new vehicle object
     */
    VehicleThatUsesBuilderPattern car = new VehicleThatUsesBuilderPattern.BuilderPattern
        ("1500cc", 4)
        .hasSunroof(true)
        .build();

    /**
     * As you can see, we dont have a set sunroof here because this truck does not have a sunroof, so sunroof will automatically
     * become false, and the truck will just build as normal
     */
    VehicleThatUsesBuilderPattern truck = new VehicleThatUsesBuilderPattern.BuilderPattern
        ("9000cc", 4)
        .build();

    System.out.println("Car values are:");
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.hasSunroof());

    System.out.println("\nTruck values are:");
    System.out.println(truck.getEngine());
    System.out.println(truck.getWheel());
    System.out.println(truck.hasSunroof());

  }

}
