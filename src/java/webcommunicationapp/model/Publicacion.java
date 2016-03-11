/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webcommunicationapp.model;

import java.util.Objects;

/**
 *
 * @author ariel
 */
public class Publicacion {
    private String titulo;
    private String aviso;

    public String getTitulo() {
        return titulo;
    }
    public String getAviso(){
        return aviso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAviso(String aviso){
        this.aviso = aviso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }
}
