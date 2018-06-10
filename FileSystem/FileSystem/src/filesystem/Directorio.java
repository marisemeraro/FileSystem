/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mariana
 */
public class Directorio extends Elemento{
    private ArrayList<Elemento> elementos;

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    
    public Directorio(String nombre, String ruta, Elemento ultima_dir){
        this.nombre = nombre;
        this.ruta = ruta;
        this.elementos = new ArrayList<>();
        this.ultima_direccion = ultima_dir;
    }
    
    public void agregarElemento(Elemento elem){
        this.elementos.add(elem);
    }

    public Elemento getUltima_direccion() {
        return ultima_direccion;
    }

    public void setUltima_direccion(Elemento ultima_direccion) {
        this.ultima_direccion = ultima_direccion;
    }
    
    
}
