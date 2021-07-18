
package modeloDAO;

import configuracion.Conexion;
import interfaces.RolInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;

public class RolDAO implements RolInterface{
    Conexion conect = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Rol nRol = new Rol(); 

    @Override
    public List listar() {
        ArrayList<Rol> listaRol = new ArrayList();
        String sql = "select * from Rol";
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Rol nuevoRol = new Rol();
                nuevoRol.setIdRol(rs.getInt("idRol"));
                nuevoRol.setDescripcion(rs.getString("descripcion"));
                listaRol.add(nuevoRol);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaRol;
    }

    @Override
    public Rol list(int id) {
        String sql = "select * from Rol where idRol= "+id;
        try{
            con = conect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                nRol.setIdRol(rs.getInt("idRol"));
                nRol.setDescripcion(rs.getString("descripcion"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return nRol;
    
    }
}
