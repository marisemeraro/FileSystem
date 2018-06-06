/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

/**
 *
 * @author Mariana
 */
public class Archivo extends Elemento{
    private String extension;
    private int sector;
    private int tamano;
    
    public Archivo(String nombre, String ruta, String extension, int sector, int tamano){
        this.nombre = nombre;
        this.ruta = ruta;
        this.extension = extension;
        this.sector = sector;
        this.tamano = tamano;
    }
 
    
}
