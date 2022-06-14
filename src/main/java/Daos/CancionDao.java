package Daos;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {
    public ArrayList<BandaDao> listarCanciones(){
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/hr";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
