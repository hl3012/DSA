import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class Ticket {
    private String parkingLocation;
    private Timestamp enter;
    private Timestamp exit;
    private float hourlyRatio;
    private float chargeAmount;
    private ParkingSpot parkingSpot;

    public void calculate() {
        this.exit=Timestamp.from(Instant.now());
        Duration duration = Duration.between(enter.toLocalDateTime(), this.exit.toLocalDateTime());
        this.chargeAmount=duration.toHours()*hourlyRatio;
    }

    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot=parkingSpot;
    }

   
}
