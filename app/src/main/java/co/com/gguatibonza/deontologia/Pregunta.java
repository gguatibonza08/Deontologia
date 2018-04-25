package co.com.gguatibonza.deontologia;

import java.util.ArrayList;

public class Pregunta {
    private int id;
    private String dificultad;
    private int peso;
    private ArrayList<Respuesta> respuestas = new ArrayList<>();
    private Respuesta correta;
    private String contenido;
    private String explicacion;


    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public Pregunta(int id, String dificultad, int peso, ArrayList<Respuesta> respuestas, Respuesta correta, String contenido) {
        this.id = id;
        this.dificultad = dificultad;
        this.peso = peso;
        this.respuestas = respuestas;
        this.correta = correta;
        this.contenido = contenido;
    }

    public Pregunta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Respuesta getCorreta() {
        return correta;
    }

    public void setCorreta(Respuesta correta) {
        this.correta = correta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
