/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;
import java.util.Date;

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
        FileSystem fileSystem = new FileSystem();
        fileSystem.CRT(5, 8, "Root");
        fileSystem.FLE("Ronald", "ArchivoNuevo", "txt");
        fileSystem.MKDIR("Directorio1");
        fileSystem.CHDIR("Directorio1");
        fileSystem.MKDIR("Directorio1_1");
        fileSystem.CHDIR("Directorio1_1");
        fileSystem.MKDIR("Directorio1_1_1");
        fileSystem.CHDIR("Directorio1_1_1");
        fileSystem.LDIR();
        fileSystem.PPT("ArchivoNuevo");
        fileSystem.CHDIR("..");   
        fileSystem.CHDIR("..");  
        fileSystem.CHDIR("..");  
    }
    
    //Crear un disco virtual. Raiz y directorio raiz
    public void CRT(int cantidadSectores, int tamSector, String nomRaiz){
        //Crea la raiz pero no se crea el archivo
        this.raiz = new Raiz(nomRaiz);
        //Se crea el direcotorio raiz
        this.directorioActual = new Directorio(nomRaiz, nomRaiz, null);
        System.out.println("****La raíz ha sido creada con el nombre de "+nomRaiz+"****");
    }
    
    //Crea un nuevo archivo en el directorio actual
    public void FLE(String contenido, String nombre, String extension){ 
        if (directorioActual != null){
            String ruta = this.directorioActual.ruta + "/" + nombre +"."+ extension;
            Date date = new Date();
            Archivo arch = new Archivo(nombre, ruta, extension, 0, contenido.length(), date, date);
            this.directorioActual.agregarElemento(arch);
            System.out.println("****El archivo "+nombre+" ha sido creado en la dirección "+directorioActual.ruta+"****");
        }
        else{
            System.out.println("****Error!!! Debe crear un directorio inicial****");
        }
    }
    
    //Crea un nuevo directorio
    public void MKDIR(String nombre){
         if (directorioActual != null){
            //Crea un elemento pero no se mueve a el
            String ruta = this.directorioActual.ruta + "/" + nombre;
            Directorio dir = new Directorio(nombre, ruta, directorioActual);
            this.directorioActual.agregarElemento(dir);
            System.out.println("****El directorio "+nombre+" ha sido creado en la dirección "+directorioActual.ruta+"****");
         }
         else{
             System.out.println("****Error!!! Debe crear un directorio inicial****");
         }
    }
    
    //Moverse hacia adelante y hacia atras en los directorios
    public void CHDIR (String nombre){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        System.out.println("****Dirección actual****");
        if (nombre.equals("..")){
            if (this.directorioActual.getUltima_direccion() != null){
                this.directorioActual = (Directorio) this.directorioActual.getUltima_direccion();
            }
        }
        else{
            while(i!=tam){
                Elemento  ele = elems.get(i);
                if (ele instanceof Directorio){
                    Directorio dir = (Directorio) ele;
                    if (dir.nombre.equals(nombre)){
                        dir.setUltima_direccion(this.directorioActual);
                        this.directorioActual = dir;
                    }
                }
                i++;
            }
        }
        System.out.println(this.directorioActual.ruta);      
    }
    
    //Lista los archivos y directorios dentro del directorio actual. 
    public void LDIR(){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        System.out.println("****Elementos dentro de la ruta "+this.directorioActual.ruta+"****");
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele instanceof Archivo){
                Archivo arch = (Archivo) elems.get(i);
                System.out.println("Archivo >>> "+elems.get(i).nombre+"."+arch.extension);
            }
            else{
                System.out.println("Directorio >>> "+elems.get(i).nombre);
            }
            i++;
        }
    }
    
    // Ver las propiedades de un archivo. 
    public void PPT(String nombre){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento elemento =elems.get(i);
            if(elemento instanceof Archivo){
                if (elemento.nombre.equals(nombre)){
                    Archivo arch = (Archivo) elemento;
                    System.out.println("****Las propiedades del archivo son: ****");
                    System.out.println("Nombre >>> "+arch.nombre);
                    System.out.println("Extensión  >>> "+arch.extension);
                    System.out.println("Fecha Creación >>> "+arch.fecha_creacion);
                    System.out.println("Fecha Modificación >>> "+arch.fecha_modificacion);
                    System.out.println("Tamaño >>> "+arch.tamano);
                    break;
                }
            }
            i++;
        }
    }
}
