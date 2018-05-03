package co.com.gguatibonza.deontologia;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private String correo;
    private int puntaje;
    private String avatar;
    private String username;
    private String nombre;
    private int fallos;
    private String dificultadActual;
    private int actual;
    private ArrayList<Integer> respondidas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int puntaje, String avatar, String nombre, int fallos, String dificultadActual, int actual, String username) {
        this.puntaje = puntaje;
        this.avatar = avatar;
        this.nombre = nombre;
        this.fallos = fallos;
        this.dificultadActual = dificultadActual;
        this.actual = actual;
        this.username = username;
    }

    public ArrayList<Integer> getRespondidas() {
        return respondidas;
    }

    public void setRespondidas(ArrayList<Integer> respondidas) {
        this.respondidas = respondidas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public String getDificultadActual() {
        return dificultadActual;
    }

    public void setDificultadActual(String dificultadActual) {
        this.dificultadActual = dificultadActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("puntaje", puntaje);
        result.put("avatar", avatar);
        result.put("nombre", nombre);
        result.put("fallos", fallos);
        result.put("dificultadActual", dificultadActual);
        result.put("correo", correo);
        result.put("actual", actual);
        result.put("username", username);
        result.put("respondidas", respondidas);
        return result;
    }
}
