package Daos;

import Beans.Banda;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadoDao {


    //En este caso se usa preparedStatement
    public static ArrayList<Cancion> obtenerListaRecomendados() {
        ArrayList<Cancion> listarecomendados = new ArrayList<>();
         String user = "root";
         String pass = "root";
         String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select idcancion, nombre_cancion, nombre_banda from \n" +
                     "cancion c inner join banda b on c.banda = b.idbanda\n" +
                     "\t\t  inner join reproduccion r on c.idcancion = r.cancion_idcancion\n" +
                     "group by cancion_idcancion having\n" +
                     "count(*) >2 order by count(*) desc");) {

            while (rs.next()) {

                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setNombre_banda(rs.getString(3));
                listarecomendados.add(cancion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listarecomendados;
    }
}
