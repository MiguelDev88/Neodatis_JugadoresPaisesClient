package funciones;

import clases.C_Jugador;


// @author Miguel

public class Visualizar {
    
    public static void verJugador (C_Jugador jugador) {
        
        
        System.out.println("\n------------------");
        System.out.println("DNI: "+jugador.getDni());
        System.out.println("Nombre: "+jugador.getNombre());
        System.out.println("Deporte: "+jugador.getDeporte());
        System.out.println("Ciudad: "+jugador.getCiudad());
        System.out.println("Edad: "+jugador.getEdad());
        System.out.println("Pais: "+jugador.getPais().getNombre());
        System.out.println("------------------");
        
    }
    
}
