package gps;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Menu {

    public static void menu() {
        Scanner leer = new Scanner(System.in);
        String archivo = "almacenamiento/datos_gps.csv"; // ruta del archivo
        List <GPS> datos = null; // lista para almacenar los datos leidos

        // Menú principal
        while (true) {
            System.out.println("====Menu====");
            System.out.println("1. Generar los datos del autobus");
            System.out.println("2. Leer archivo CSV y filtrar datos");
            System.out.println("3. Exportar posiciones a JSON");
            System.out.println("4. Mostrar trayecto de un autobús");
            System.out.println("5. Analis del autobus");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leer.nextInt();

            // Llamar a los métodos según la opción seleccionada
            switch(opcion) {
                case 1:
                    // Generamos los datos GPS
                    Generador.generador(archivo);
                    break;

                case 2:
                    // Leemos el archivo y filtramos por id
                    System.out.println("Ingrese el id del bus ");
                    String busId = leer.next();

                    // llamamos al metodo de lectura y filtrado de datos
                    datos = Lectura.leerYFiltrarDatos(archivo,busId, null, null);

                    if (datos.isEmpty()) {
                        System.out.println("No se encontro el id del bus ");
                    }else {
                        System.out.println("Datos leidos y filtrados con exito");
                    }
                    for (GPS g : datos) {
                        System.out.println(g.getBusId()+ " | " + g.getTiempobus() + " | " + g.getLatitud() + ", " + g.getLongitud() + " | Velocidad: " + g.getVelocidad());
                    }

                    break;

                case 3:
                   // exportamos los datos de las posiciones al JSON
                    if (datos != null && !datos.isEmpty()) {
                        Exportar.exportarUltimaPosicion(datos,"posiciones.json");
                    }else {
                        System.out.println("No hay datos disponibles para exportar");
                    }
                    break;

                case 4:
                   // Mostrar el trayecto de un autobus
                    if (datos != null && !datos.isEmpty()) {
                        System.out.println("Escribe el id del autobus");
                        String idbusTrayecto = leer.next();
                        Trayecto.mostrarTrayecto(datos,idbusTrayecto);
                    }else{
                        System.out.println("No hay datos disponibles");
                    }
                    break;
                    // menu dentro de otro menu para ver el analisis del autobus
                case 5:
                    if (datos != null && !datos.isEmpty()) {
                        System.out.println("===== Análisis de Datos =====");
                        System.out.println("1. Velocidad media de un autobús");
                        System.out.println("2. Número de paradas de un autobús");
                        System.out.println("3. Paradas por cada autobús");
                        System.out.print("Seleccione una opción: ");
                        int opcion2 = leer.nextInt();
                        leer.nextLine(); // limpiar el buffered

                        switch (opcion2) {
                            case 1:
                                System.out.print("Ingrese el ID del autobús: ");
                                String idVel = leer.nextLine();
                                double velocidadMedia = Analisis.calcularVelocidadMedia(datos, idVel);
                                System.out.println("Velocidad media de " + idVel + ": " + velocidadMedia + " km/h");
                                break;

                            case 2:
                                System.out.print("Ingrese el ID del autobús: ");
                                String idParadas = leer.nextLine();
                                int paradas = Analisis.contarParadas(datos, idParadas);
                                System.out.println("Número de paradas de " + idParadas + ": " + paradas);
                                break;

                            case 3:
                                System.out.println("Paradas por ruta:");
                                Map<String, Integer> paradasRuta = Analisis.contarParadasPorRuta(datos);
                                for (Map.Entry<String, Integer> entry : paradasRuta.entrySet()) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue() + " paradas");
                                }
                                break;

                            default:
                                System.out.println("Opción de análisis no válida.");
                        }
                    } else {
                        System.out.println("No hay datos disponibles para analizar.");
                    }
                    break;
                case 6:
                    // salir del programa
                    leer.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

}
