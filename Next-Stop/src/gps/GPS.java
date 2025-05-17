package gps;

import java.time.LocalDateTime;

public class GPS {
    // atributos
    private String busId;
    private LocalDateTime tiempobus;
    private double latitud;
    private double longitud;
    private int velocidad;

    // constructor
    public GPS(String busId, LocalDateTime tiempobus, double latitud, double longitud,int velocidad) {
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

    public int getVelocidad() {
        return velocidad;
    }

    // setters
    public void setBusId(String busId) {
        this.busId = busId;
    }

    public void setTiempobus(LocalDateTime tiempobus) {
        this.tiempobus = tiempobus;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // Metodo para una representacion en el csv
    public String toCSV() {
        return busId + "," + tiempobus.toString() + "," + latitud + "," + longitud + "," + velocidad;
    }
}
