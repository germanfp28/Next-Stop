import gps.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Nombre del archivo CSV donde se almacenarán los datos simulados
        String archivo = "almacenamiento/datos_gps.csv";

        // Paso 1: Generar datos simulados y guardarlos en un archivo CSV
        Generador.generador(archivo);  // Genera los datos en el archivo CSV

        // Paso 2: Cargar los datos desde el archivo CSV
        List<GPS> datos = cargarDatosDesdeCSV(archivo);

        // Paso 3: Exportar las últimas posiciones de los autobuses en formato JSON
        Exportar.exportarUltimasPosiciones(datos);

        // Otras funcionalidades (como análisis, etc.) pueden agregarse aquí
    }

    // metodo para cargar los datos del archivo CSV en una lista de objetos GPS
    public static List<GPS> cargarDatosDesdeCSV(String archivo) {
        List<GPS> datos = new ArrayList<>();

        try {
            // Leer el archivo CSV línea por línea
            Files.lines(Paths.get(archivo)).skip(1).forEach(line -> {
                // Dividir la línea en partes
                String[] partes = line.split(",");

                // Obtener los valores de cada columna
                String busId = partes[0];
                String tiempobus = partes[1];
                double latitud = Double.parseDouble(partes[2]);
                double longitud = Double.parseDouble(partes[3]);
                int velocidad = Integer.parseInt(partes[4]);

                // Crear el objeto GPS y agregarlo a la lista
                GPS gps = new GPS(busId, java.time.LocalDateTime.parse(tiempobus), latitud, longitud, velocidad);
                datos.add(gps);
            });
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: ");
        }

        return datos;
    }
}