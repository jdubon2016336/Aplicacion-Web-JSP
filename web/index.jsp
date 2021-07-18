

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Rol"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Inicio</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
        .bd-placeholder-img {
          font-size: 1.125rem;
          text-anchor: middle;
          -webkit-user-select: none;
          -moz-user-select: none;
          -ms-user-select: none;
          user-select: none;
        }

        @media (min-width: 768px) {
          .bd-placeholder-img-lg {
            font-size: 3.5rem;
          }
        }
    </style>
        <link href="css/signin.css" rel="stylesheet">
    </head> 
    <body class="text-center">
        <form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
            <img class="mb-4" src="img/usuario.png" alt="" width="200" height="80">
            <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion:</h1><br>
            <label for="inputUser" class="sr-only">Username</label><br>
            <input type="text" id="inputUser" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label><br>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="form-group">
            <br><label>Rol</label><br>
                <select class="form-control" id="Roles" name="Roles">

                    <%

                            RolDAO RolDAO = new RolDAO();
                            List<Rol> listaRol= RolDAO.listar();
                            Iterator<Rol> iterator = listaRol.iterator();
                            Rol rol= null;
                            
                            while(iterator.hasNext()){
                                rol = iterator.next();

                    %>
                    <option value="<%= rol.getIdRol() %>"><%= rol.getDescripcion() %></option>
                        <% } %>
                </select>
              </div>
                        <%--<select class="form-control" id="exampleFormControlSelect1"><option>Seleccione un tipo de usuario...</option><option>Administrador</option><option>Usuario</option></select>--%>
            <a class="btn btn-lg btn-primary btn-block" type="submit" href="Controlador?accion=Ingresar">Ingresar</a><br>
            
            <p class="mt-5 mb-3 text-dark">&copy; Javier Alejandro Dubón Ubedo | IN5AV</p>
        </form>
    </body>
</html>
