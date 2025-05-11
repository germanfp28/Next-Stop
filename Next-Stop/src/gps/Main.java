package gps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String archivo = "almacenamiento/datos_gps.csv"; // ruta de donde se guardan los datos
        Generador.generador("almacenamiento/datos_gps.csv");
        // lee y valida los datos del archivo csv
        ArrayList<GPS> datos = Procesos.leerycomprobar(archivo);

        // inicia el menu
        Menu.menu(datos);
    }
}