
<%@page import="modelo.Persona"%>
<%@page import="modeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Pagina Editar</title>
        
    </head>
    <body >
        <div class="container ">
            <div class="col-lg-5 text-center container">
                <%
                    PersonaDAO nuevaPersonaDao = new PersonaDAO();
                    int codPersona = Integer.parseInt((String)request.getAttribute("codPer"));
                    Persona nuevaPersona = (Persona)nuevaPersonaDao.list(codPersona);
                %>
                <h1>Modificar Persona</h1>
                <form>
                    <strong>DPI:</strong>
                    <input class="form-control" type="text" name="txtDPI" value="<%= nuevaPersona.getDPI() %>"><br>
                    <strong>Nombre:</strong>
                    <input  class="form-control" type="text" name="txtNombre" value="<%= nuevaPersona.getNombrePersona() %>"><br>
                    <input class="form-control" type="hidden" name="txtCodigoPersona" value="<%= nuevaPersona.getCodigoPersona() %>"><br>
                    <input  class="btn btn-primary" type="submit" name="accion" value="Actualizar"><br>
                </form>
            </div>
        </div>
    </body>
</html>
