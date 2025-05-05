package gps;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    Scanner leer = new Scanner(System.in);

    public void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("Menu");
                System.out.println("1. Mover Autobuses");
                System.out.println("2. Mostrar autobuses parados");
                System.out.println("5. Salir");
                opcion = leer.nextInt();


                // en cada caso llamamos a los metodos
                switch (opcion) {
                    case 1:
                        System.out.println("Moviendo autobuses......");
                        String archivo = "almacenamiento/datos_gps.csv"; // ruta de donde se guardan los datos
                        Generador.generador(archivo);

                        break;
                    case 2:
                        System.out.println("Mostrando autobuses parados.......");
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Saliendo");
                        break;

                    default:
                        System.out.println("El numero de opcion no existe");
                        break;
                }

            } catch (Exception e) {

                leer.next();
            }

        } while (opcion != 5);

    }
}
