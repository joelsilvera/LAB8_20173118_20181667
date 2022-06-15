package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {
    public ArrayList<Cancion> listarCanciones(){
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

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
             ResultSet rs = stmt.executeQuery("SELECT idcancion , nombre_cancion , nombre_banda, favorito " +
                     "FROM cancion c inner join banda b on (c.banda = b.idbanda) " +
                     "ORDER by idcancion");) {

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setNombre_banda(rs.getString(3));
                cancion.setEs_favorito(rs.getString(4));
                listaCanciones.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }


    public ArrayList<Cancion> listarFavoritos(){
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

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
             ResultSet rs = stmt.executeQuery("SELECT idcancion , nombre_cancion , nombre_banda, favorito " +
                     "FROM cancion c inner join banda b on (c.banda = b.idbanda) " +
                     "WHERE favorito = 'Yes' " +
                     "ORDER by idcancion");) {

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setNombre_banda(rs.getString(3));
                cancion.setEs_favorito(rs.getString(4));
                listaCanciones.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }



    public void actualizar(Cancion cancion){
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion SET favorito = ? where idcancion = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, cancion.getEs_favorito());
            pstmt.setInt(2, cancion.getIdCancion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
