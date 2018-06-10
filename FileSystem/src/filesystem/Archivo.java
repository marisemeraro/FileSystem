/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.Date;

/**
 *
 * @author Mariana
 */
public class Archivo extends Elemento{
    protected String extension;
    protected int sector;
    protected int tamano;
    protected int sector_inicial;
    protected int sector_final;
    
    public Archivo(String nombre, String ruta, String extension, int sector, int tamano, Date f_creacion, Date f_modificacion, int sector_inicial, int sector_final){
        this.nombre = nombre;
        this.ruta = ruta;
        this.extension = extension;
        this.sector = sector;
        this.tamano = tamano;
        this.fecha_creacion = f_creacion;
        this.fecha_modificacion = f_modificacion;
        this.sector_inicial = sector_inicial;
        this.sector_final = sector_final;
    }
 
    
}
