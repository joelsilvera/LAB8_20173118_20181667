package Beans;

public class Cancion {
    private int idCancion;
    private String nombre_cancion;
    private String nombre_banda;

    public Cancion(){

    }

    public Cancion(int idCancion, String nombre_cancion, String nombre_banda) {
        this.idCancion = idCancion;
        this.nombre_cancion = nombre_cancion;
        this.nombre_banda = nombre_banda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getNombre_banda() {
        return nombre_banda;
    }

    public void setNombre_banda(String nombre_banda) {
        this.nombre_banda = nombre_banda;
    }
}
