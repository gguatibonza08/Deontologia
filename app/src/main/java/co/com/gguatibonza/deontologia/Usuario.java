package co.com.gguatibonza.deontologia;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Usuario {

    private int id;
    private String correo;
    private int puntaje;
    private String avatar;
    private String nombre;
    private int fallos;

    public Usuario() {
    }

    public Usuario(int id, int puntaje, String avatar, String nombre, int fallos) {
        this.id = id;
        this.puntaje = puntaje;
        this.avatar = avatar;
        this.nombre = nombre;
        this.fallos = fallos;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        result.put("id", id);
        result.put("puntaje", puntaje);
        result.put("avatar", avatar);
        result.put("nombre", nombre);
        result.put("fallos", fallos);
        return result;
    }
}
