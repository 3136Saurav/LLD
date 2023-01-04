import strategy.DrivingStrategy;

public class Vehicle {
    DrivingStrategy driveStrategy;

    public Vehicle(DrivingStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
