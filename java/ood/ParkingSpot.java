public abstract class ParkingSpot {
    public String parkingLocation;
    public float hourlyRate;
    public abstract void park(ParkingLot parkingSpot, ParkingSpot compactSpot);
    public abstract void exit(ParkingLot parkingSpot, ParkingSpot compactSpot);
}
