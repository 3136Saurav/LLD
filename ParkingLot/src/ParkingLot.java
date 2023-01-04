import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    String name;
    Address address;
    List<ParkingFloor> parkingFloorList;
    static ParkingLot instance;

    private ParkingLot(String name, Address address) {
        this.name = name;
        this.parkingFloorList = new ArrayList<ParkingFloor>();
    }

    public static ParkingLot getParkingLotInstance(String name, Address address) {
        if (instance == null) {
            instance = new ParkingLot(name, address);
        }
        return instance;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> slotType) {
        ParkingFloor parkingFloor = new ParkingFloor(name, slotType);
        this.parkingFloorList.add(parkingFloor);
    }

    public void removeFloor(ParkingFloor floor) {
        this.parkingFloorList.remove(floor);
    }

    public Ticket bookTicket(Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlotForVehicle(vehicle);
        if (parkingSlot == null) {
            return null;
        }

        Ticket ticket = new Ticket(vehicle);

        return ticket;
    }

    public double releaseTicketAndCharge(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        long duration = (endTime - ticket.startTime) / 1000;

        ticket.getParkingSlot().releaseSlot();

        double cost = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return cost;

    }

    private ParkingSlot getParkingSlotForVehicle(Vehicle vehicle) {
        ParkingSlot slot = null;
        for (ParkingFloor parkingFloor : parkingFloorList) {
            slot = parkingFloor.getParkingSlot(vehicle);
            if (slot != null) break;
        }
        return slot;
    }

}
