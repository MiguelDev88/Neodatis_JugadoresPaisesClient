package funciones;
import clases.C_Jugador;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;


// @author Miguel

public class Consultas {
    
    public static void consultas (BufferedReader leer) throws IOException {
        
        byte op=1;


        while(op!=0){
            op=Menu.menuConsultas(leer);
            switch(op){
                case 1://Jugadores por inicial
                    consultaPorInicial(leer);
                    break;
                case 2://Jugadores de una ciudad mayores de edad"
                    consultaPorCiudadEdad(leer);
                    break;
                case 3://Jugadores por Pais"
                    consultaPorPais(leer);
                    break;
                case 4://Suma de las edades"
                    consultaSumaEdades(leer);
                    break;
                case 5://Número de jugadores registrados"
                    consultaNumJugadoresRegistrados(leer);
                    break;
                case 6://Edad media "
                    consultaEdadMedia(leer);
                    break;
                case 7://Número de jugadores por ciudad"
                    consultaNumJugadoresCiudad(leer);
                    break;
                case 8://Listado de Jugadores (nombre, edad, pais)"
                    consultaListadoJugadores(leer);
                    break;
                case 9://.Nombre y ciudad de los jugadores por Pais"
                    consultaNombreCiudadPorPais(leer);
                    break;
                case 10://Número de jugadores de un pais y edad"
                    consultaNumJugadoresPaisEdad(leer);
                    break;
            }
        }
    }
    
    public static void consultaPorInicial (BufferedReader leer) throws IOException {
        
        String inicial;
        C_Jugador jugador;
        ODB odb;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca la Inicial a buscar");
            inicial=leer.readLine();

            ICriterion criterion=Where.like("nombre", inicial);
            //IQuery q=new CriteriaQuery(C_Jugador.class, criterion);
            Iterator jugadores=odb.getObjects(new CriteriaQuery(C_Jugador.class, criterion)).iterator();

            System.out.println("Jugadores encontrados:");
            while(jugadores.hasNext())
            {
                jugador=(C_Jugador)jugadores.next();
                Visualizar.verJugador(jugador);
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();

    }
    
    public static void consultaPorCiudadEdad (BufferedReader leer) throws IOException {
        
        String ciudad;
        int edad;
        C_Jugador jugador;
        ODB odb;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca la Ciudad a buscar");
            ciudad=leer.readLine();
            
            System.out.println("Introduzca la edad mínima a buscar:");
            edad=Integer.parseInt(leer.readLine());

            ICriterion criterion=new And().add (Where.equal("ciudad", ciudad))
                                          .add(Where.gt("edad", edad));
            Iterator jugadores=odb.getObjects(new CriteriaQuery(C_Jugador.class, criterion)).iterator();

            System.out.println("Jugadores encontrados:");
            while(jugadores.hasNext())
            {
                jugador=(C_Jugador)jugadores.next();
                Visualizar.verJugador(jugador);
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();

    }
    
    public static void consultaPorPais (BufferedReader leer) throws IOException {
        
        String nombrePais;
        C_Jugador jugador;
        ODB odb;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca El pais a buscar");
            nombrePais=leer.readLine();

            ICriterion criterion=Where.equal("pais.nombre", nombrePais);
            Iterator jugadores=odb.getObjects(new CriteriaQuery(C_Jugador.class, criterion)).iterator();

            System.out.println("Jugadores encontrados:");
            while(jugadores.hasNext())
            {
                jugador=(C_Jugador)jugadores.next();
                Visualizar.verJugador(jugador);
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();

    }
    
    public static void consultaSumaEdades (BufferedReader leer) throws IOException {
        
        ODB odb;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            ObjectValues values=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class).sum("edad")).nextValues();      

            System.out.println("La suma total de las edades es: " +values.getByAlias("edad"));
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void consultaEdadMedia (BufferedReader leer) throws IOException {
        
        ODB odb;
        float media;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            
            //Values v=new ValuesCriteriaQuery(C_Jugador.class).sum("edad").count("count");
            
            ObjectValues values=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class).sum("edad").count("count")).getFirst();
           

            media=((BigDecimal)values.getByAlias("edad")).floatValue() / ((BigInteger)values.getByAlias("count")).floatValue();

            System.out.println("La Edad media es: " +media+" años.");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void consultaNumJugadoresRegistrados (BufferedReader leer) throws IOException {
        
        ODB odb;

        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            ObjectValues values=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class).count("count")).getFirst();

            System.out.println("Hay un total de "+values.getByAlias("count")+" Jugadores registrados.");
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void consultaNumJugadoresCiudad (BufferedReader leer) throws IOException {
        
        ODB odb;

        
        odb=ODBFactory.open("jugadores.db");
        //odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            Values v=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class).count("count").field("ciudad"));

            System.out.println("Resultado:");
            while(v.hasNext()){
                ObjectValues values=v.nextValues();
                
                System.out.printf("%nCiudad: "+values.getByAlias("ciudad"));
                System.out.printf("%nNumJugadores: "+values.getByAlias("count"));
                
                //System.out.printf("%nCiudad: "+values.getByIndex(0));
                //System.out.printf("%nNumJugadores: "+values.getByIndex(1));


            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void consultaListadoJugadores (BufferedReader leer) throws IOException {
        
        ODB odb;

        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            Values v=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class).field("nombre").field("edad").field("pais.nombre"));

            System.out.println("Resultado:");
            while(v.hasNext()){
                ObjectValues values=v.nextValues();
                System.out.printf("%nJugador: "+values.getByAlias("nombre"));
                System.out.printf("%nEdad: "+values.getByAlias("edad"));
                System.out.printf("%nPais: "+values.getByAlias("pais.nombre"));


            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void consultaNombreCiudadPorPais (BufferedReader leer) throws IOException {
        
        String nombrepais;
        ODB odb;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca el Pais a buscar");
            nombrepais=leer.readLine();

            Values v=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class,Where.equal("pais.nombre", nombrepais)).field("nombre").field("ciudad"));

            System.out.println("Resultado:");
            while(v.hasNext()){
                ObjectValues values=v.nextValues();
                System.out.printf("%nJugador: "+values.getByAlias("nombre"));
                System.out.printf("%nCiudad: "+values.getByAlias("ciudad"));

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
    
    public static void consultaNumJugadoresPaisEdad (BufferedReader leer) throws IOException {
        
        String nombrepais;
        int edad;
        ODB odb;
        
        
        //odb=ODBFactory.open("jugadores.db");
        odb = ODBFactory.openClient("192.168.4.20", 8000, "base");
        
        try{
            System.out.println("Introduzca el Pais a buscar");
            nombrepais=leer.readLine();

            System.out.println("Introduzca la Edad a buscar");
            edad=Integer.parseInt(leer.readLine());

            Values v=odb.getValues(new ValuesCriteriaQuery(C_Jugador.class,new And().add (Where.equal("pais.nombre", nombrepais))
                                              .add(Where.equal("edad", edad))).field("nombre").field("ciudad"));

            System.out.println("Resultado:");
            while(v.hasNext()){
                ObjectValues values=v.nextValues();
                System.out.printf("%nJugador: "+values.getByAlias("nombre"));
                System.out.printf("%nCiudad: "+values.getByAlias("ciudad"));

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        odb.close();
        
    }
}
