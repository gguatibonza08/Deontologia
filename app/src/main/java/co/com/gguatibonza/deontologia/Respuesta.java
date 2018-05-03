package co.com.gguatibonza.deontologia;

public class Respuesta {

    private int id;
    private String contenido;

    public Respuesta(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public Respuesta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
