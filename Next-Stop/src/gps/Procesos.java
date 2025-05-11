package gps;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Procesos {

    // leemos el documento csv y validamos que los datos esten correctos

    public static ArrayList<GPS> leerycomprobar(String Archivo) {
        ArrayList<GPS> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(Archivo))) {
            String linea;
            br.readLine();

            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");

                try {
                    String busId = partes[0];
                    LocalDateTime tiempoActual = LocalDateTime.parse(partes[1]);
                    double latitud = Double.parseDouble(partes[2]);
                    double longitud = Double.parseDouble(partes[3]);
                    int velocidad = Integer.parseInt(partes[4]);


                    if (valido(latitud, longitud, velocidad)) {
                        GPS datos = new GPS(busId,tiempoActual,longitud,latitud,velocidad);
                        lista.add(datos);
                    }
                }catch (Exception e){
                    System.out.println("Error al leer las lineas");
                }

            }

        }catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
        return lista;
    }

    private static boolean valido(double lat, double lon, int velocidad) {
        return lat >= -90 && lat <= 90 && lon >= -180 && lon <= 180 && velocidad >= 0;
    }



    // filtrado de utobuses

    public static ArrayList<GPS> buscarbusid(ArrayList<GPS> lista, String busId, LocalDateTime desde, LocalDateTime hasta) {
        ArrayList<GPS> resultado = new ArrayList<>();

        for (GPS datos: lista) {
            if (datos.getBusId().equals(busId) && !datos.getTiempobus().isBefore(desde) && !datos.getTiempobus().isAfter(hasta)) {
                resultado.add(datos);
            }
        }
        return resultado;
    }

}
