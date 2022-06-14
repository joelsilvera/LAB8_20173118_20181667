package Servlets;

import Beans.Cancion;
import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listaServlet", value = "/listaCanciones")
public class listaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch(action){
            case "listar" -> {
                CancionDao cancionDao = new CancionDao();
                ArrayList<Cancion> listaCanciones = cancionDao.listarCanciones();
                request.setAttribute("lista", listaCanciones);
                RequestDispatcher view = request.getRequestDispatcher("/includes/listadecanciones.jsp");
                view.forward(request, response);
            }
            case "abrirFavoritos" -> {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/includes/cancionesFavoritas.jsp");
                requestDispatcher.forward(request, response);
            }
            case "addFavorito" -> {

            }
            case "deleteFavorito" -> {

            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
