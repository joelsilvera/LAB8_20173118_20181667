package Daos;

import Beans.Banda;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadoDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    //En este caso se usa preparedStatement
    public static ArrayList<Cancion> obtenerListaRecomendados() {
        ArrayList<Cancion> listarecomendados = new ArrayList<>();
         String user = "root";
         String pass = "root";
         String url = "jdbc:mysql://localhost:3306/lab6sw1";

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
                Cancion recomendado = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3));
                listarecomendados.add(recomendado);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listarecomendados;
    }
}
