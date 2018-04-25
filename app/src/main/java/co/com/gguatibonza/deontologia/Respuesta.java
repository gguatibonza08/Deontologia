package co.com.gguatibonza.deontologia;

public class Respuesta {

    private int id;
    private String contenido;
    private String validar;


    public Respuesta(int id, String contenido, String validar) {
        this.id = id;
        this.contenido = contenido;
        this.validar = validar;
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

    public String getValidar() {
        return validar;
    }

    public void setValidar(String validar) {
        this.validar = validar;
    }

}
