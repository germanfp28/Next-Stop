package gps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Exportar {
    // Esta clase exporta los datos del bus indicado en el JSON
    // Metodo para exportar la ultima posicion de cada autobus
    public static void exportarUltimaPosicion(List<GPS> datos, String archivo) {

        // Creamos un objeto JSON
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(java.time.LocalDateTime.class, new AdaptadorLocalDateTime()) // Registra el adaptador
                .setPrettyPrinting() // Para que el JSON sea legible
                .create();

        try (FileWriter writer = new FileWriter(archivo)) {
            // Recorremos los datos para obtener la última posición de cada autobús
            for (String busId : new String[] {"Bus01", "Bus02", "Bus03"}) {
                // Buscar el último registro del bus
                GPS ultimaPosicion = null;
                for (GPS g : datos) {
                    if (g.getBusId().equals(busId)) {
                        ultimaPosicion = g;
                    }
                }

                // Convertir el objeto GPS a formato JSON
                if (ultimaPosicion != null) {
                    String json = gson.toJson(ultimaPosicion);
                    writer.write(json + "\n");
                }
            }

            System.out.println("Datos exportados exitosamente a JSON.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }
}
