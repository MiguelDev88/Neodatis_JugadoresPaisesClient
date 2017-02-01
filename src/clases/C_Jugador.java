package clases;


// @author Miguel

public class C_Jugador {
    
    private String dni, nombre, deporte, ciudad;
    int edad;
    private C_Pais pais;
    
    
    public C_Jugador (){}
    
    public C_Jugador (String dni, String nombre, String deporte, String ciudad, int edad) {
        
        this.dni=dni;
        this.nombre=nombre;
        this.deporte=deporte;
        this.ciudad=ciudad;
        this.edad=edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public C_Pais getPais() {
        return pais;
    }

    public void setPais(C_Pais pais) {
        this.pais = pais;
    }
    
}
