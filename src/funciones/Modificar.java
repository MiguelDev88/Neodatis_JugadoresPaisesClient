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

public class Modificar {
    
    public static void modificar (BufferedReader leer) throws IOException {
        
        C_Jugador jugador;
        String dni;
        
        
        //ODB odb=ODBFactory.open("jugadores.db");
        ODB odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca DNI del jugador a modificar:");
            dni=leer.readLine();
            Objects<C_Jugador> jugadores=odb.getObjects(new CriteriaQuery(C_Jugador.class,Where.equal("dni",dni)));

            if(jugadores.isEmpty())
                System.out.println(" - No se ha encontrado ningún jugador por ese DNI -");
            
            else{   
                jugador=jugadores.getFirst();
                modificarJugador(jugador, leer, odb);   
            }

        }catch(Exception e){
            System.out.println(" - Operación Cancelada -");
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void modificarJugador (C_Jugador jugador, BufferedReader leer, ODB odb) throws IOException {
        
        byte op=1;
        String deporte, ciudad;
        
        
        while(op!=0){
            
            Visualizar.verJugador(jugador);
            
            op=Menu.menuModificar(leer);
            switch(op){
                case 1:
                    System.out.println("Introducir nuevo deporte:");
                    deporte=leer.readLine();
                    jugador.setDeporte(deporte);
                    break;
                case 2:
                    System.out.println("Introducir nueva ciudad:");
                    ciudad=leer.readLine();
                    jugador.setCiudad(ciudad);
                    break;
                case 3:
                    odb.store(jugador);
                    System.out.println(" - Jugador Actualizado -");
                    op=0;
                    break;
                case 0:
                    System.out.println(" - Operación Cancelada -");
                    break;
            }
        }
        
    }
    
}
