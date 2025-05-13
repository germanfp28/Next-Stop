package gps;
import gps.GPS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lectura {
// Esta clase se encarga de leer el archivo y filtrar los datos segun el id
    public static List<GPS> leerYFiltrarDatos(String archivo, String busIdFiltro, LocalDateTime inicio, LocalDateTime fin) {
        List<GPS> datosFiltrados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Saltar la cabecera
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 5) {
                    String busId = campos[0];
                    LocalDateTime timestamp = LocalDateTime.parse(campos[1]);
                    double latitud = Double.parseDouble(campos[2]);
                    double longitud = Double.parseDouble(campos[3]);
                    int velocidad = Integer.parseInt(campos[4]);

                    // Validar datos
                    if (esValido(latitud, longitud, velocidad, timestamp, busId, busIdFiltro, inicio, fin)) {
                        GPS g = new GPS(busId, timestamp, latitud, longitud, velocidad);
                        datosFiltrados.add(g);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV");
        }
        return datosFiltrados;
    }

    // metodo parra validar los datos
    public static boolean esValido(double latitud, double longitud, int velocidad, LocalDateTime timestamp, String busId, String busIdFiltro, LocalDateTime inicio, LocalDateTime fin) {
        boolean dentroRango = (inicio == null || !timestamp.isBefore(inicio)) && (fin == null || !timestamp.isAfter(fin));

        return (latitud >= -90 && latitud <= 90) && (longitud >= -180 && longitud <= 180) && (velocidad >= 0 && velocidad <= 50) && (busId.equals(busIdFiltro)) && dentroRango;
    }

}
