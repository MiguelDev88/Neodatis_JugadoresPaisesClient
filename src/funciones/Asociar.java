package funciones;
import clases.C_Jugador;
import clases.C_Pais;
import java.io.BufferedReader;
import java.io.IOException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


// @author Miguel

public class Asociar {
    
    public static void asociarPais (C_Jugador jugador, ODB odb, BufferedReader leer) throws IOException {
        
        int id;
        C_Pais pais;
        
        
        System.out.println("Introducir id del país al que pertenece el jugador:");
        id=Integer.parseInt(leer.readLine());

        Objects<C_Pais> paises=odb.getObjects(new CriteriaQuery(C_Pais.class,Where.equal("id",id)));

        if( paises.isEmpty() ){
            pais=Altas.nuevoPais(id, leer);
            //odb.store(pais);
        }else
            pais=paises.getFirst();
        
        jugador.setPais(pais);
    } 
}
