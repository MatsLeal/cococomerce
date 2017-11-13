<%-- 
    Document   : principal
    Created on : 12/11/2017, 03:23:39 PM
    Author     : Alain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String usuario = (String) objsesion.getAttribute("usuario");
    if(usuario.equals("")){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>
    <body>
        <h1>Pagina principal, acceso concedido usuario: <% out.println(usuario); %></h1>
    </body>
</html>
