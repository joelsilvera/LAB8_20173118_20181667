<%@ page import="java.util.Calendar" %>
<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: joels
  Date: 13/06/2022
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<Cancion> listaCanciones = (ArrayList<Cancion>) request.getAttribute("lista"); %>

<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Favoritos</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>CANCION</th>
                            <th>BANDA</th>
                            <th>Ver</th>

                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><h3>CANCION</h3>
                            </td>
                            <td><h3>CANCION</h3>
                            </td>
                            <td><h3>CANCION</h3>
                            </td>
                            <td><button name="button" style = background-color:green>Ya no me gusta</button>
                            </td>
                        </tr>

                    </tbody>
                </table>
                <a href="<%=request.getContextPath()%>/listaCanciones" class="btn btn-success ms-auto">Regresar</a>
            </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
