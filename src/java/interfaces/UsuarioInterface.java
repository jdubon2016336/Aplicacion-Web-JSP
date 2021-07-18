
package interfaces;

import java.util.List;
import modelo.Usuario;

public interface UsuarioInterface {
    public List listar();
    public int list (Usuario id); 
    public boolean valida(Usuario id);
    public boolean validaRol(Usuario id);
    public int Buscar(String nombre, String Pass);
}
