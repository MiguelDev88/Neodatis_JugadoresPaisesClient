package funciones;
import clases.*;
import java.io.BufferedReader;
import java.io.IOException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


// @author Miguel

public class Altas {
    
    
    public static void altaJugador (BufferedReader leer) throws IOException {
        
        C_Jugador jugador;
        
        
        //ODB odb=ODBFactory.open("jugadores.db");
        ODB odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            jugador=nuevoJugador(leer);

            if (odb.getObjects(new CriteriaQuery(C_Jugador.class,Where.equal("dni",jugador.getDni()))).isEmpty())
            {
                Asociar.asociarPais(jugador, odb, leer);
                odb.store(jugador);
                System.out.println(" - Jugador Registrado -");
            }
            else
                System.out.println("\n - Jugador ya existente en la BD");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    
    public static C_Jugador nuevoJugador (BufferedReader leer) throws IOException {
        
        String dni, nombre, deporte, ciudad;
        int edad;
        
        
        System.out.println("Introducir dni:");
        dni=leer.readLine();
        System.out.println("Introducir nombre:");
        nombre=leer.readLine();
        System.out.println("Introducir deporte:");
        deporte=leer.readLine();
        System.out.println("Introducir ciudad:");
        ciudad=leer.readLine();
        System.out.println("Introducir edad:");
        edad=Integer.parseInt(leer.readLine());
        
        C_Jugador jugador = new C_Jugador (dni, nombre, deporte, ciudad, edad);

        return jugador;

    }
    
    public static C_Pais nuevoPais (int id, BufferedReader leer) throws IOException {
        
        String nombre;
        

        System.out.println("Introducir nombre del País:");
        nombre=leer.readLine();
        
        C_Pais pais=new C_Pais (id, nombre);
        
        return pais;
        
    }
    
}
