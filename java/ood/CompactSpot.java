public class CompactSpot extends ParkingSpot {
    public CompactSpot() {
        this.hourlyRate=2;
    }

    @Override
    public void park(ParkingLot parkingLot, ParkingSpot compactSpot) {
        parkingLot.compactId++;
        this.parkingLocation=""+ parkingLot.compactId;

        parkingLot.availableCompactSpot--;
        parkingLot.compactSpotMap.put(""+parkingLot.compactId, compactSpot);
    }

    @Override
    public void exit(ParkingLot parkingLot, ParkingSpot compactSpot) {
        parkingLot.compactSpotMap.remove(compactSpot.parkingLocation);
        parkingLot.availableCompactSpot++;
    }

    
}
