package android.oscarbetanzos.com.petinsta;

import android.app.Application;

public class Mascota extends Application{
    private int foto;
    private String nombre;
    private String rate;

    public Mascota(int foto, String nombre, String rate) {
        this.foto = foto;
        this.nombre = nombre;
        this.rate = rate;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
