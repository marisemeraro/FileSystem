/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;

/**
 *
 * @author Mariana
 */
public class FileSystem {
    public Raiz raiz;
    public Directorio directorioActual;
    
    //public String rutaActual;
    public int nivelActual;
    //public ArrayList<String> ListaNombresDirectorios;
    //public ArrayList<String> ListaNombresArchivos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void CRT(int cantidadSectores, int tamSector, String nomRaiz){
        this.raiz = new Raiz(nomRaiz);
    }
    
    public void FLE(String contenido, String nombre, String extension){
        String ruta = this.directorioActual.ruta + "/" + nombre + extension;
        Archivo arch = new Archivo(nombre, ruta, extension, 0, contenido.length());
        this.directorioActual.agregarElemento(arch);
    }
    
    public void MKDIR(String nombre){
        String ruta = this.directorioActual.ruta + "/" + nombre;
        Directorio dir = new Directorio(nombre, ruta);
        this.directorioActual.agregarElemento(dir);
    }
    
    public void CHDIR (String nombre){
        
    }
    
    public void LDIR(){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            System.out.println(elems.get(i).nombre);
            i++;
        }
    }
    
    public void PPT(String nombre){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento elemento =elems.get(i);
            if("Archivo".equals(elemento.getClass().getSimpleName())){
                if (elemento.nombre.equals(nombre)){
                    System.out.println("Extensión");
                    System.out.println("Fecha Creación");
                    System.out.println("Fecha Modificación");
                    System.out.println("Tamaño");
                    break;
                }
            }
            System.out.println(elems.get(i).nombre);
            i++;
        }
    }
}
