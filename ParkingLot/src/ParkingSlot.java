public class ParkingSlot {
    String name;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;
    boolean isAvailable;

    public ParkingSlot(String name, Vehicle vehicle, ParkingSlotType parkingSlotType, boolean isAvailable) {
        this.name = name;
        this.vehicle = vehicle;
        this.parkingSlotType = parkingSlotType;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void bookSlot(Vehicle vehicle) {
        this.vehicle = vehicle;
        isAvailable = false;
    }

    public void releaseSlot() {
        this.vehicle = null;
        isAvailable = true;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }
}
