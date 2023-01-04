import strategy.SportsDrivingStrategy;

public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportsDrivingStrategy());
    }
}
