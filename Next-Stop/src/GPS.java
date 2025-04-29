import java.time.LocalDate;
import java.time.LocalTime;

public class GPS {

    private int busId;
    private LocalDate tiempobus;
    private double latitude;
    private double longitude;
    private double velocidad;

    public GPS(int busId, LocalDate tiempobus, double latitude, double longitude) {
        this.busId = busId;
        this.tiempobus = tiempobus;
        this.latitude = latitude;
        this.longitude = longitude;
        this.velocidad = velocidad;
    }

    public int getBusId() {
        return busId;
    }

    public LocalDate getTiempobus() {
        return tiempobus;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String csv(){
        return String.format("%s,%s,%.5f,%.5f,%.2f",
                busId,
                tiempobus.toString(),
                latitude,
                longitude,
                velocidad
        );
    }
}
