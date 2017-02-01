package funciones;
import java.io.BufferedReader;
import java.io.IOException;


// @author Miguel

public class Menu {
    
    public static byte menuPrincipal (BufferedReader leer) throws IOException {
        
        byte b;
        
        System.out.println("\n Seleccione opción:"
                + "\n1.Alta Jugador"
                + "\n2.Baja Jugador"
                + "\n3.Modificar Jugador"
                + "\n4.Consultas"
                + "\n0.Finalizar ");
        b=Byte.parseByte(leer.readLine());
        
        return b;
        
    }
    
    public static byte menuAltas (BufferedReader leer) throws IOException {
        
        byte b;
        
        System.out.println("\n ¿Qué desea dar de alta?"
                + "\n1.Jugador"
                + "\n0.Finalizar ");
        b=Byte.parseByte(leer.readLine());
        
        return b;
        
    }
    
    public static byte menuBajas (BufferedReader leer) throws IOException {
        
        byte b;
        
        System.out.println("\n ¿Qué desea dar de baja?"
                + "\n1.Jugador"
                + "\n2.Pais"
                + "\n0.Finalizar ");
        b=Byte.parseByte(leer.readLine());
        
        return b;
        
    }
    
    public static byte menuModificar (BufferedReader leer) throws IOException {
        
        byte b;

        
        System.out.println("\n ¿Qué desea modificar?"
                + "\n1.Deporte"
                + "\n2.Ciudad"
                + "\n3.Guardar Cambios"
                + "\n0.Finalizar ");
        b=Byte.parseByte(leer.readLine());
        
        return b;
        
    }
    
    public static byte menuConsultas (BufferedReader leer) throws IOException {
        
        byte b;

        
        System.out.println("\n ¿Qué desea Consultar?"
                + "\n1.Jugadores por inicial"
                + "\n2.Jugadores de una ciudad mayores de edad"
                + "\n3.Jugadores por Pais"
                + "\n4.Suma de las edades"
                + "\n5.Número de jugadores registrados"
                + "\n6.Edad media "
                + "\n7.Número de jugadores por ciudad"
                + "\n8.Listado de Jugadores (nombre, edad, pais)"
                + "\n9.Nombre y ciudad de los jugadores por Pais"
                + "\n10.Número de jugadores de un pais y edad"
                + "\n0.Finalizar ");
        b=Byte.parseByte(leer.readLine());
        
        return b;
        
    }
    
    public static byte menuConfirmar (BufferedReader leer) throws IOException {
        
        byte op;
        System.out.println("¿Seguro que desea eliminar este registro?"
                + "\n1.SI"
                + "\n2.NO");
        
        op=Byte.parseByte(leer.readLine());
        
        return op;
    }
      
}