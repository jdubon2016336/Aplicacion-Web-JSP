
package modeloDAO;

import configuracion.Conexion;
import interfaces.UsuarioInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO implements UsuarioInterface{
    Conexion conect = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario nUsuario = new Usuario();
    int r = 0;

    @Override
    public List listar() {
        ArrayList<Usuario> listaUsuario = new ArrayList();
        String sql = "select * from Usuario";
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombreUsuario(rs.getString("nombreUsuario"));
                nuevoUsuario.setContraseña(rs.getString("contraseña"));
                nuevoUsuario.setIdRol(rs.getInt("idRol"));
                listaUsuario.add(nuevoUsuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaUsuario;
    }

    @Override
    public boolean valida(Usuario id) {
        boolean status=false; String sql = "select * from usuario where nombreUsuario=? and contraseña=?";
        try{
      
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id.getNombreUsuario());
            ps.setString(2, id.getContraseña());
           
            System.out.print(ps);
            
            rs= ps.executeQuery();
            status = rs.next();
                
                
          
            
            
        }catch (Exception e){
        }

                    return status;

    
    }

    @Override
    public boolean validaRol(Usuario id) {
        boolean status=false; String sql = "select * from usuarios where nombreUsuario=? and Contraseña=? and idRol=?";
        try{
      
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id.getNombreUsuario());
            ps.setString(2, id.getContraseña());
            ps.setInt(3, id.getIdRol());
           
            System.out.print(ps);
            
            rs= ps.executeQuery();
            status = rs.next();
                
                
          
            
            
        }catch (Exception e){
        }

                    return status;
    }

    @Override
    public int Buscar(String nombre, String Pass) {
        Usuario user = null;
           int x=0;
        String sql = "select * from usuarios where Usuario= ?  and password=?" ;
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, Pass);
            
            rs = ps.executeQuery();
            while(rs.next()){
             
            
            user.setNombreUsuario(rs.getString("nombreUsuario"));
            user.setContraseña(rs.getString("contraseña"));
            user.setIdRol(rs.getInt("idRol"));
            
            if(nombre == user.getNombreUsuario() ){
                x=1;
            }
            
            }
           
            
        }catch (Exception e){
            e.printStackTrace();
        }
        if(x==1){
            
        x=1;
        
        
      
    } else{
            x=2;
        }  
        
        return x;
    }

    @Override
    public int list(Usuario id) {
        String sql = "select * from usuario where nombreUsuario=? and contraseña=?";
        try{
            r =0;
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id.getNombreUsuario());
            ps.setString(2, id.getContraseña());
            rs = ps.executeQuery();
            
            while (rs.next()){
                 r = r+1;
                nUsuario.setNombreUsuario(rs.getString("nombreUsuario"));
                nUsuario.setContraseña(rs.getString("Contraseña"));
                nUsuario.setIdRol(rs.getInt("idRol"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
            
        }catch (Exception e){
            return 0;
        }
    }

   
}
