
public class Ticket {
    double cost;
    Vehicle vehicle;
    ParkingSlot parkingSlot;
    long startTime;
    long endTime;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.startTime = System.currentTimeMillis();
    }


    public ParkingSlot getParkingSlot() {
        return this.parkingSlot;
    }
}
