package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {
    public ArrayList<Cancion> listarCanciones(){
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idcancion as 'ID', nombre_cancion as 'Cancion', nombre_banda as 'Banda' " +
                     "FROM cancion c inner join banda b on (c.banda = b.idbanda) " +
                     "ORDER by idcancion;");) {

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getString(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setNombre_banda(rs.getInt(3));
                listaCanciones.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCanciones;


    }
}
