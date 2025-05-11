package gps;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void menu(ArrayList<GPS> datos) {
        Scanner leer = new Scanner(System.in);
        String nombre;

        System.out.println("==================");
        System.out.println("Sistema GPS de Autobuses");
        System.out.println("Ubicacion: PORTUGAL");
        System.out.println("==================");



        while (true) {
            System.out.println("Escribe el id del autobus(ej.Bus01), o 'salir' para terminar");
            nombre = leer.next().trim();
            if (nombre.equals("salir")) {
                System.out.println("Gracias por tu viaje");
                break;
            }

            GPS ultimo = ultimodato(datos, nombre);
            if (ultimo == null) {
                System.out.println("El autobus no existe");
            }else {
                System.out.println("Autobus " + nombre);
                System.out.println("Ubicacion actual, " + ultimo.getLatitud() + "," + ultimo.getLongitud());
                System.out.println("Hora: " + ultimo.getTiempobus());
                System.out.println("Velocidad " + ultimo.getVelocidad());
            }
        }


    }

    private static GPS ultimodato(ArrayList<GPS> datos, String nombre) {
        GPS ultimo = null;

        for (GPS g : datos) {
            if (g.getBusId().equals(nombre)) {
                if (ultimo == null || g.getTiempobus().isAfter(ultimo.getTiempobus())) {
                    ultimo = g;
                }
            }
        }
        return ultimo;
    }
}
