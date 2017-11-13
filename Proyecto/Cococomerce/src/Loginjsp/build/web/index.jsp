<%-- 
    Document   : index
    Created on : 12/11/2017, 02:49:15 PM
    Author     : Alain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <script src="js/main.js"></script>
    </head>
    <body>
        <h1>Iniciar Sesión</h1>
        <form action="iniciar" method="post" id="forminicio">
            <label>Usuario</label>
            <input type="text" name="usuario" id="txtusuario"/><br>
            <label>Contraseña</label>
            <input type="password" name="pass" id="txtpass"/><br>
            <input type="button" value="Iniciar Sesión" id="btniniciar"/>
        </form>
        <br>
        No tienes cuenta.. <a href="registro.jsp">Registrarme</a>
    </body>
</html>
