package com.borjarnau.miscontactos.pojo;

/**
 * Created by ArnAu on 04/05/2016.
 */
public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private int foto;


    public Contacto(int foto, String nombre, String telefono, String email) {   // falta en el constructor int foto
        this.foto = foto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
