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
    
    public Directorio(String nombre, String ruta){
        this.nombre = nombre;
        this.ruta = ruta;
    }
    
    public void agregarElemento(Elemento elem){
        this.elementos.add(elem);
    }
}
