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
            case  "editarFavorito"-> {
                String id = request.getParameter("id");
                Cancion cancion = cancionDao.buscarId(id);

                if (cancion != null) {
                    request.setAttribute("cancion", cancion);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("includes/listadecanciones.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "includes/listadecanciones.jsp");
                }

            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        CancionDao cancionDao = new CancionDao();

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        switch(action){
            case "actualizar" -> {
                Cancion cancion = leerParametrosRequest(request);
                cancionDao.actualizar(cancion);
                response.sendRedirect(request.getContextPath() + "/listaCanciones");
            }
            case "" -> {

            }

        }
    }
    public Cancion leerParametrosRequest(HttpServletRequest request) {
        String idcancion = request.getParameter("idcancion");
        String nombre_cancion = request.getParameter("nombre_cancion");
        String banda = request.getParameter("banda");
        String favorito = request.getParameter("favorito");

        String favorito_act;
        if(favorito.equals("No")){
            favorito_act = "Yes";
        }else{
            favorito_act = "No";
        }

        Cancion cancion = new Cancion();
        cancion.setIdCancion(Integer.parseInt(idcancion));
        cancion.setNombre_cancion(nombre_cancion);
        cancion.setNombre_banda(banda);
        cancion.setEs_favorito(favorito_act);
        return cancion;
    }
}
