
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="images/pokemon4.png" type="image/x-icon">
    
    </head>
    <body>
    
        <header class="header">
            <img src="images/${sessionScope.Usuario.avatar}" alt=""/>
            <section>
                <label class="nombreUsuario">Bienvenido, <span>${sessionScope.Usuario.nombre}</span></label>         
                
            </section>

            <button id="btnCS" class="btn">Cerrar Sesion</button>
        </header>
        <main class="main">
            <section class="muroPrincipal">
                 <form class="publicar" action="SvPrincipal" method="POST">
                <input type="text" class="titulo" name="titulo" placeholder="Titulo">
                <input type="text" class="publicacion" name="contenido" placeholder="Publicación">
                <input type="submit" name="seleccion" value="Publicar">
                <span>${mensajeCorrecto}</span>
                <br>
            </form>
                <section class="muro" id="muro">    
                    <c:forEach var="publicacion" items="${sessionScope.Publicaciones}">
                        <form class="panel" action="SvPrincipal" method="POST">
                            <label class="lblUsuario"><span>${publicacion.nombreUsuario}</span></label>
                            <input type="text" class="titulo" name="titulo" value="${publicacion.titulo}">
                            <input type="text" class="publicacion" name="contenido" value="${publicacion.contenido}">
                            <label class="lblPanel">Fecha de creacion:<span>${publicacion.fechaCreacion}</span></label>
                            <label class="lblPanel">Comentarios</label>
                            <input type="text" class="comentario" name="comentario" placeholder="Agregar comentario">
                            <input type="submit" id="btnComentar" name="seleccion" value="Comentar">
                            <c:set var="id" value="${publicacion.id}" ></c:set>
                            <c:set var="idPublicacion" value="${sessionScope.Comentario.idPublicacion}"></c:set>
                            <c:forEach var="comentario" items="${sessionScope.Comentarios}">
                                <c:if test="${id eq idPublicacion}">
                                    <form>
                                        <label class="lblUsuario"><span>${comentario.nombreUsuario}</span></label>
                                        <input type="text" class="comentario" name="comentario" value="${comentario.contenido}">
                                        <label class="lblPanel">Fecha de comentario:<span>${comentario.fecha}</span></label>
                                    </form>
                                </c:if>  
                            </c:forEach>
                        </form>                   
                    </c:forEach>
                </section>
            </section>

        </main>
        <footer class="footer">
            <p>Copyright © 2023 Rodrigo Gtz.</p>
        </footer>
        <script src="js/principal.js" type="text/javascript"></script>     
    </body>
</html>
