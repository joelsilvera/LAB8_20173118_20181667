package Servlets;

import Daos.RecomendadoDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecomendadoServlet", value = "/listaRecomendados")
public class RecomendadoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RecomendadoDao recomendadoDao = new RecomendadoDao();

        switch (action){
            case "listar": {
                request.setAttribute("listaRecomendados", recomendadoDao.obtenerListaRecomendados());
                RequestDispatcher listaRecomendados = request.getRequestDispatcher("/includes/listaRecomendados.jsp");
                listaRecomendados.forward(request, response);
            }
            case "buscar": {

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
