package gps;

import java.util.List;

public class Trayecto {
// Esta clase muestra el trayecto del autobus indicado

        // Metodo para mostrar el trayecto de un autobus
        public static void mostrarTrayecto(List<GPS> datos, String busId) {
            System.out.println("Mostrando trayecto para el autobús: " + busId);
            System.out.println("Timestamp\t\tLatitud\t\tLongitud\t\tVelocidad");

            // Recorremos todos los datos para el bus seleccionado
            for (GPS g : datos) {
                if (g.getBusId().equals(busId)) {
                    System.out.println(g.getBusId()+ " | " + g.getTiempobus() + " | " + g.getLatitud() + ", " + g.getLongitud() + " | Velocidad: " + g.getVelocidad());
                }
            }
        }


}
