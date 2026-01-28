import java.util.*;

public class ParkingLot {
    Map<String, ParkingSpot> largeSpotMap=new HashMap<>();
    Map<String, ParkingSpot> compactSpotMap=new HashMap<>();
    Map<String, ParkingSpot> handicapSpotMap=new HashMap<>();

    Map<String, Ticket> ticketMap = new HashMap<>();

    int availableCompactSpot=100;
    int availableLargeSpot=100;
    int availableHandicapSpot=100;

    int largeId=0;
    int compactId=100;
    int handicapId=200;

    public void park(String vehicleType) throws Exception, ParkingFullException {
        if (checkFull(vehicleType)) {
            throw new ParkingFullException();
        }
        ParkingSpot parkingSpot = getParkingSpot(vehicleType);
        parkingSpotUpdate(parkingSpot);

        

    }

    private boolean checkFull(String vehicleType) throws Exception {
        if(vehicleType.equals("large")) {
            return availableLargeSpot<=0;
        } else if(vehicleType.equals("compact")) {
            return availableCompactSpot<=0;
        }else if (vehicleType.equals("handicap")) {
            return availableHandicapSpot<=0;
        }
        throw new Exception("Invalid Vehicle type");
    }
    private ParkingSpot getParkingSpot(String vehicleType) throws Exception {
        if(vehicleType.equals("large")) {
            return new LargeSpot();
        } else if(vehicleType.equals("compact")) {
            return new CompactSpot();
        }else if (vehicleType.equals("handicap")) {
            return new HandicapSpot();
        }
        throw new Exception("Invalid Vehicle type");
    }

    private void parkingSpotUpdate(ParkingSpot parkingSpot) {
        parkingSpot.park(this, parkingSpot);
    }
}
