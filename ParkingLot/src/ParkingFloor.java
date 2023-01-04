import java.util.List;
import java.util.Map;

public class ParkingFloor {
    String floorName;
    Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsMap;

    public ParkingFloor(String floorName, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsMap) {
        this.floorName = floorName;
        this.parkingSlotsMap = parkingSlotsMap;
    }

    public ParkingSlot getParkingSlot(Vehicle vehicle) {
        ParkingSlotType parkingSlotType = getParkingSlotType(vehicle);
        Map<String, ParkingSlot> entry = parkingSlotsMap.get(parkingSlotType);
        ParkingSlot slot = null;
        for (Map.Entry<String, ParkingSlot> slots : entry.entrySet()) {
            if (slots.getValue().isAvailable()) {
                slot = slots.getValue();
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType getParkingSlotType(Vehicle vehicle) {
        if (vehicle.getVehicleType().equals(VehicleType.CAR)) return ParkingSlotType.FOURWHEELER;
        else if (vehicle.getVehicleType().equals(VehicleType.BUS)) return ParkingSlotType.LARGE;
        else if (vehicle.getVehicleType().equals(VehicleType.BIKE)) return ParkingSlotType.TWOWHEELER;
        return null;
    }

}



