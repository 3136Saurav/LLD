import strategy.DrivingStrategy;
import strategy.OffRoadDrivingStrategy;

public class GoodsAndServiceVehicle extends Vehicle{

    public GoodsAndServiceVehicle() {
        super(new OffRoadDrivingStrategy());
    }
}
