
package modelo;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private int idRol;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseña, int idRol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    
}
