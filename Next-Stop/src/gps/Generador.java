package gps;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.ArrayList;

public class Generador {

    public static void generador(String archivo) {
        String[] busIds = {"Bus01", "Bus02", "Bus03"};
        LocalDateTime inicio = LocalDateTime.of(2025, 3, 25, 8, 0); // Hora de inicio

        double latitud = 38.7169;   // Lisboa
        double longitud = -9.1399;

        Random random = new Random();
        ArrayList<GPS> todosLosDatos = new ArrayList<>();

        // Generar datos para cada bus
        for (String busId : busIds) {
            LocalDateTime tiempo = inicio;
            double lat = latitud;
            double lon = longitud;

            for (int i = 0; i < 60; i++) {
                int velocidad = random.nextInt() * 50;

                // Simular movimiento aleatorio
                lat += (random.nextDouble() - 0.5) * 0.01;
                lon += (random.nextDouble() - 0.5) * 0.01;

                GPS g = new GPS(busId, tiempo, lon, lat, velocidad);
                todosLosDatos.add(g);

                tiempo = tiempo.plusMinutes(1);
            }
        }


        // Guardar en CSV
        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write("busId,tiempobus,latitud,longitud,velocidad\n");

            for (GPS g : todosLosDatos) {
                fw.write(g.csv() + "\n");
            }
            System.out.println("Datos GPS generados en: " + archivo);

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV");
        }
    }
}
