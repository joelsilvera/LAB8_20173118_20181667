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
        CancionDao cancionDao = new CancionDao();
        System.out.println(action);
        switch(action){
            case "listar" -> {

                ArrayList<Cancion> listaCanciones = cancionDao.listarCanciones();
                request.setAttribute("lista", listaCanciones);
                RequestDispatcher view = request.getRequestDispatcher("/includes/listadecanciones.jsp");
                view.forward(request, response);
            }
            case "listarFavoritos" -> {
                ArrayList<Cancion> listaFavoritos = cancionDao.listarFavoritos();
                request.setAttribute("lista", listaFavoritos);
                RequestDispatcher view = request.getRequestDispatcher("/includes/cancionesFavoritas.jsp");
                view.forward(request, response);
            }

            case "actualizaraYes" -> {
                String id = "" + request.getParameter("id") + "";

                String idcancion = id;
                String favorito = "Yes";

                Cancion cancion = new Cancion();
                cancion.setIdCancion(Integer.parseInt(idcancion));
                cancion.setEs_favorito(favorito);

                cancionDao.actualizar(cancion);
                response.sendRedirect(request.getContextPath() + "/listaCanciones");
            }
            case "actualizaraNo" -> {

                String id = request.getParameter("id");

                String idcancion = id;
                String favorito = "No";

                Cancion cancion = new Cancion();
                cancion.setIdCancion(Integer.parseInt(idcancion));
                cancion.setEs_favorito(favorito);

                cancionDao.actualizar(cancion);
                response.sendRedirect(request.getContextPath() + "/listaCanciones");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

    }

}
