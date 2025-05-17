package gps;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Analisis {
// esta clase realiza un analisis de los datos del autobus
    // Calcular la velocidad media por autobús
    public static double calcularVelocidadMedia(List<GPS> datos, String busId) {
        int totalVelocidad = 0;
        int cantidadDatos = 0;

        for (GPS g : datos) {
            if (g.getBusId().equals(busId)) {
                totalVelocidad += g.getVelocidad();
                cantidadDatos++;
            }
        }

        return (cantidadDatos == 0) ? 0 : (double) totalVelocidad / cantidadDatos;
    }

    // Detectar el número de paradas por autobús
    public static int contarParadas(List<GPS> datos, String busId) {
        int paradas = 0;

        for (GPS g : datos) {
            if (g.getBusId().equals(busId) && g.getVelocidad() == 0) {
                paradas++;
            }
        }

        return paradas;
    }

    // Contar las paradas por ruta por bus
    public static Map<String, Integer> contarParadasPorRuta(List<GPS> datos) {
        Map<String, Integer> paradasPorRuta = new HashMap<>();

        for (GPS g : datos) {
            if (g.getVelocidad() == 0) {
                paradasPorRuta.put(g.getBusId(), paradasPorRuta.getOrDefault(g.getBusId(), 0) + 1);
            }
        }

        return paradasPorRuta;
    }
}
