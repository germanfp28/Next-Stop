package gps;

import java.time.LocalDateTime;

public class GPS {
    // atributos
    private String busId;
    private LocalDateTime tiempobus;
    private double latitud;
    private double longitud;
    private double velocidad;

    // constructor
    public GPS(String busId, LocalDateTime tiempobus, double latitud, double longitud, double velocidad) {
        this.busId = busId;
        this.tiempobus = tiempobus;
        this.latitud = latitud;
        this.longitud = longitud;
        this.velocidad = velocidad;
    }



    // getters
    public String getBusId() {
        return busId;
    }

    public LocalDateTime getTiempobus() {
        return tiempobus;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String csv(){
        // Formato de como se va a guardar en el csv
        return String.format("%s,%s,%.5f,%.5f,%.2f",
                busId,
                tiempobus.toString(),
                latitud,
                longitud,
                velocidad
        );
    }
}
