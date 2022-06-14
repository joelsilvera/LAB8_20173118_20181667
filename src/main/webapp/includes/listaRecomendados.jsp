<%@ page import="Beans.Cancion" %><%--
  Created by IntelliJ IDEA.
  User: david
  Date: 13/06/2022
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaRecomendados" scope="request" type="java.util.ArrayList<Beans.Cancion>"/>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Recomendados"/>
    </jsp:include>
<head>
    <title>Lista de Recomendados</title>
</head>
<body>

    <main>
        <div class='container'>
        <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
        <jsp:include page="/includes/navbar.jsp">
            <jsp:param name="page" value="recomendados"/>
        </jsp:include>
        <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
        <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
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
        <%for (Cancion recomendado: listaRecomendados) {%>
        <tr>
        <td><%=recomendado.getIdCancion()%>
        </td>
        <td><%=recomendado.getNombre_cancion()%>
        </td>
        <td><%=recomendado.getNombre_banda()%>
        </td>
        <td>
        <a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones">Más de la banda</a>
        </td>
        </tr>
        <%}%>

        </tbody>
        </table>
        </div>
        </div>
        <jsp:include page="/static/scripts.jsp"/>
        </body>
    </main>
</body>
</html>