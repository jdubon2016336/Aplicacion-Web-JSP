
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Persona;
import modelo.Usuario;
import modeloDAO.PersonaDAO;
import modeloDAO.UsuarioDAO;


@WebServlet("/login")

public class Controlador extends HttpServlet {
    public static final long serialVersionUID =  1 ;
    private  UsuarioDAO UsuarioDAO;
    String listar = "view/listar.jsp";
    public void init(){
        UsuarioDAO = new UsuarioDAO();
    }
    
    String inicio = "view/index.jsp";
    String add = "view/add.jsp";
    String edit = "view/editar.jsp";
    String nlistar = "view/nlistar.jsp";
    Persona nuevaPersona = new Persona();
    PersonaDAO nuevaPersonaDao = new PersonaDAO();
    int codigoPersona;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String codigo = request.getParameter("Codigo");
        String dpi = request.getParameter("txtDPI");
        String nombrePersona = request.getParameter("txtNombre");
        
        int DPI=0;
        String Persona="";
        String mensaje="";
        String error="";
        
        try{
            DPI = Integer.parseInt(dpi);
        }catch(NumberFormatException e){
            
            error="Error,verifique que solo sean numeros";
          
        }
        if(error.isEmpty()){
            // si no hay errores, se aceptaran los datos
            
        }else{
            //si no motrar el error
            request.setAttribute("error",error);

        }
        
        
        /*try{
            Persona = nombrePersona;
                }catch(Exception e){
                    e.printStackTrace();
                    error="No se reconoce el nombre de u suario";
                }*/
        if(error.isEmpty()){
            // si no hay errores, se aceptaran los datos
            
        }else{
            //si no motrar el error
            request.setAttribute("error",error);    
        }



        request.getRequestDispatcher("listar").forward(request,response);
        // en el parentesis y dentro e la comilla se agrega el nombre de la vista.



    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("Ingresar")) {
            acceso = listar;
            
        }else if(action.equalsIgnoreCase("listar")){
            acceso = nlistar;
            
        }else if(action.equalsIgnoreCase("regresar")){
            acceso = inicio;
        
            
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;
            
        }else if(action.equalsIgnoreCase("Agregar")){
            String DPI= request.getParameter("txtDPI");
            String nombre= request.getParameter("txtNombre");
            nuevaPersona.setDPI(DPI);
            nuevaPersona.setNombrePersona(nombre);
            nuevaPersonaDao.add(nuevaPersona);
            acceso = listar;
            
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("codPer", request.getParameter("codigoPersona"));
            acceso = edit;
            
        }else if(action.equalsIgnoreCase("Actualizar")){
            codigoPersona = Integer.parseInt(request.getParameter("txtCodigoPersona"));
            String DPI = request.getParameter("txtDPI");
            String nombres = request.getParameter("txtNombre");
            nuevaPersona.setCodigoPersona(codigoPersona);
            nuevaPersona.setDPI(DPI);
            nuevaPersona.setNombrePersona(nombres);
            nuevaPersonaDao.edit(nuevaPersona);
            acceso = listar;    
        }else if(action.equalsIgnoreCase("eliminar")){
            codigoPersona = Integer.parseInt(request.getParameter("codigoPersona"));
            nuevaPersona.setCodigoPersona(codigoPersona);
            nuevaPersonaDao.eliminar(codigoPersona);
            acceso = listar;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        int Rol = Integer.parseInt( request.getParameter("Roles"));
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(username);
        usuario.setContraseña(password);
        
        if (UsuarioDAO.valida(usuario)) {
            
                    usuario.setIdRol(Rol);

            
            if(UsuarioDAO.validaRol(usuario) ){
                
                if(Rol==1){
                            response.sendRedirect("view/listar.jsp");
                }else if(Rol ==2){
                    response.sendRedirect("view/nlistar.jsp");;
                }          
            }else {
            HttpSession session = request.getSession();
            //session.setAttribute("user", username);
            //response.sendRedirect("login.jsp");
            //HttpSession session = request.getSession();
            // session.setAttribute("username",username);
            }
        } else {
            HttpSession session = request.getSession();
            //session.setAttribute("user", username);
            //response.sendRedirect("login.jsp");
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo(){ 
        return "Short description";
    }// </editor-fold>

}