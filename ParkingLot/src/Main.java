import java.util.*;

public class Main {
    private static final int NUMBER_OF_AISLES = 3;

    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getParkingLotInstance("Atlante Parking", new Address());

        ParkingSlot slot1 = new ParkingSlot("F1A", null, ParkingSlotType.LARGE, true);
        ParkingSlot slot2 = new ParkingSlot("F1B", null, ParkingSlotType.FOURWHEELER, true);

        List<ParkingFloor> floors = new ArrayList<>();

        Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsOnFirstFloor = new HashMap<>();
        Map<String, ParkingSlot> largeParkingSlotsOnFirstFloor = new HashMap<>();
        largeParkingSlotsOnFirstFloor.put("F1A", slot1);

        parkingSlotsOnFirstFloor.put(ParkingSlotType.LARGE, largeParkingSlotsOnFirstFloor);


        ParkingFloor firstFloor = new ParkingFloor("F1", parkingSlotsOnFirstFloor);

        ParkingSlot slot3 = new ParkingSlot("F2A", null, ParkingSlotType.TWOWHEELER, true);
        ParkingSlot slot4 = new ParkingSlot("F2B", null, ParkingSlotType.FOURWHEELER, true);

        ParkingSlot slot5 = new ParkingSlot("F3A", null, ParkingSlotType.TWOWHEELER, true);
        ParkingSlot slot6 = new ParkingSlot("F3B", null, ParkingSlotType.TWOWHEELER, true);

        Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots = new HashMap<>();
        Map<String, ParkingSlot> fourWheelerParkingSlots = new HashMap<>();
        Map<String, ParkingSlot> twoWheelerParkingSlots = new HashMap<>();



        fourWheelerParkingSlots.put("F1B", slot2);
        fourWheelerParkingSlots.put("F2B", slot4);

        twoWheelerParkingSlots.put("F2A", slot3);
        twoWheelerParkingSlots.put("F3A", slot5);
        twoWheelerParkingSlots.put("F3A", slot6);

        parkingSlots.put(ParkingSlotType.FOURWHEELER, fourWheelerParkingSlots);
        parkingSlots.put(ParkingSlotType.TWOWHEELER, twoWheelerParkingSlots);


        Vehicle vehicle = new Vehicle("PB-10-5911", VehicleType.CAR);
        Ticket ticket = parkingLot.bookTicket(vehicle);

//        parkingLot.release(ticket);




    }

}
