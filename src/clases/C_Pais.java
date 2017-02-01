package clases;


// @author Miguel

public class C_Pais {
    
    private int id;
    private String nombre;
    
    
    public C_Pais (){}
    
    public C_Pais (int id, String nombre) {
        
        this.id=id;
        this.nombre=nombre;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
