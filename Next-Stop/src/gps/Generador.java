package gps;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.ArrayList;

public class Generador {
// esta clase genera los datos de los 3 autobuses y lo guarda en el archivo csv
    public static void generador(String archivo) {
        String[] busIds = {"Bus01", "Bus02", "Bus03"};
        LocalDateTime inicio = LocalDateTime.of(2025, 3, 25, 8, 0); // Hora de inicio
        Random random = new Random();

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write("busId,tiempobus,latitud,longitud,velocidad\n");


            // Generar datos para cada bus
            for (String busId : busIds) {
                LocalDateTime tiempo = inicio;
                double latitud = 38.7169;   // Lisboa
                double longitud = -9.1399;

                for (int i = 0; i < 60; i++) {
                    // Simular movimiento aleatorio
                    latitud += (random.nextDouble() - 0.5) * 0.001;
                    longitud += (random.nextDouble() - 0.5) * 0.001;
                    int velocidad = random.nextInt(51); // valor aleatorio entre 0 y 50

                    GPS g = new GPS(busId, tiempo, latitud, longitud, velocidad);
                    fw.write(g.toCSV() + "\n");
                    //incremento de tiempo en un 1minuto
                    tiempo = tiempo.plusMinutes(1);
                }
            }
            System.out.println("Datos generados exitosamente");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV");
        }

    }
}
