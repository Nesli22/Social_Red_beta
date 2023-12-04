
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
         <link rel="icon" href="images/pokemon1.png" type="image/x-icon">
    </head>
    <body>
        <section class="contenedorPrincipal">
        <header class="header">

        </header>
        <main class="main">
            <form id="frmInicioSesion" method="POST" action="SvInicioSesion" class="frm">
                
                <h1 class="titulo">Inicio de Sesion</h1><br>
                <input type="email" id="correo" name="correo" placeholder="Correo Electronico:" required>
                <br>

                <input type="password" id="contraseña" name="contraseña" placeholder="Contraseña:" required>
                <br>

                <input type="submit" id="btnIS" name="btnIs" value="Entrar">
                <br>
                <span>${mensajeInicioSesion}</span>
                <a href="Registro.jsp" class="registrar">¿No tienes una cuenta?&nbsp;&nbsp;&nbsp;Regístrate aquí</a>
                
            </form>
        </main>
        <footer class="footer">
            <p>Copyright © 2023 Rodrigo Gtz.</p>
        </footer>
        </section>
        <script src="js/inicio.js" type="text/javascript"></script>
    </body>
</html>
