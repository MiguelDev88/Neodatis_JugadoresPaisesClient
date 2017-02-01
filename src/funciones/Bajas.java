package funciones;
import clases.C_Jugador;
import java.io.BufferedReader;
import java.io.IOException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


// @author Miguel

public class Bajas {
    
    
    public static void bajaJugador (BufferedReader leer) throws IOException {
        
        C_Jugador jugador;
        String dni;
        
        
        //ODB odb=ODBFactory.open("jugadores.db");
        ODB odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca DNI del jugador a eliminar:");
            dni=leer.readLine();
            Objects<C_Jugador> jugadores=odb.getObjects(new CriteriaQuery(C_Jugador.class,Where.equal("dni",dni)));

            if(jugadores.isEmpty())
                System.out.println(" - No se ha encontrado ningún jugador por ese DNI -");
            
            else{
                
                jugador=jugadores.getFirst();
                
                if (Menu.menuBajas(leer)==1)
                    odb.delete(jugador);
                else
                    System.out.println("\n - Operación cancelada - ");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
}
