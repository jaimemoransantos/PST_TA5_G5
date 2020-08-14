package com.example.amst5;

import android.media.Image;

public class Libro {
    private String rutaImagen;
    private String titulo;
    private String categoria;
    private String autor;
    private String editorial;
    private String sinopsis;
    public Libro(String nomb,String cat, String autor, String editorial, String sinopsis,String ruta){
        rutaImagen=ruta;
        titulo=nomb;
        categoria=cat;
        this.autor=autor;
        this.editorial=editorial;
        this.sinopsis=sinopsis;


    }
    public String getRuta(){
        return rutaImagen;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getCategoria(){
        return categoria;
    }
    public String getAutor(){
        return autor;
    }
    public String getEditorial(){
        return editorial;
    }
    public String getSinopsis(){
        return sinopsis;
    }


}
