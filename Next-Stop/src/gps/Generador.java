package gps;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class Generador {

    public static void generador(String archivo){
        String [] busids = {"Bus01", "Bus02", "Bus03"};
        // comienzo del tiempo
        LocalDateTime inicioTiempo = LocalDateTime.of(2025,3,25,8,0);
        Random random = new Random();

        try (FileWriter fw = new FileWriter(archivo)){
            fw.write("busId,tiempobus,latitud,longitud,velocidad\n");

            for(String busId: busids) {
                LocalDateTime tiempoActual = inicioTiempo; // igualamos al tiempo por defecto ya creado
                double latitud = 40.4168; // latitud base
                double longitud = -3.7038; // longitud base
                int velocidad=0;


                for (int i = 0; i < 60; i++) {
                     velocidad = random.nextInt(51); // velocidad aleatoria entre 0 y 50
                    latitud += (random.nextDouble() -0.5) * 0.01; // movimientos aleatorios
                    longitud += (random.nextDouble() -0.5) * 0.01;

                    GPS datosbus = new GPS(busId, tiempoActual, longitud, latitud, velocidad);
                    fw.write(datosbus.csv() + "\n");
                    if (velocidad == 0){
                        System.out.println(busId + "Bus parado" + longitud + " " + latitud );
                    }
                }



            }
            System.out.println("Datos guardados en" + archivo);

        }catch (IOException e){
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }
    }
}
