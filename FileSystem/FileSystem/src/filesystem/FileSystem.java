/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Mariana
 */
public class FileSystem {
    public Directorio raiz;
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
        fileSystem.FLE("Ronald", "Archivo1", "txt");
        fileSystem.MKDIR("Directorio1_1_1");
        fileSystem.FLE("Ronald", "Archivo2", "txt");
        fileSystem.CHDIR("Directorio1_1_1");
        fileSystem.FLE("Ronald", "Archivo3", "txt");
        fileSystem.LDIR();
        fileSystem.PPT("ArchivoNuevo");
        fileSystem.CHDIR("..");   
        fileSystem.CHDIR("..");  
        fileSystem.CHDIR(".."); 
        
        fileSystem.menu();
        return;
    }
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
        int opcion;
        while(true){
            System.out.println("");
            System.out.println("Funcionalidades File System");
            System.out.println("1. CRT");
            System.out.println("2. FLE");
            System.out.println("3. MKDIR");
            System.out.println("4. CHDIR");
            System.out.println("5. LDIR");
            System.out.println("6. MFLE");
            System.out.println("7. PPT");
            System.out.println("8. VIEW");
            System.out.println("9. CPY");
            System.out.println("10. MOV");
            System.out.println("11. REM");
            System.out.println("12. TREE");
            System.out.println("13. FIND");
            System.out.println("14. Salir");
            System.out.println("Escriba la opción que desee");
            opcion = scan.nextInt();
            
            switch(opcion){
                case 1:
                    opCRT();
                    break;
                case 2:
                    opFLE();
                    break;
                case 3:
                    opMKDIR();
                    break;
                case 4:
                    opCHDIR();
                    break;
                case 5:
                    LDIR();
                    break;
                case 6:
                    opMFLE();
                    break;
                case 7:
                    opPPT();
                    break;
                case 8:
                    opVIEW();
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    opREM();
                    break;
                case 12:
                    TREE();
                    break;
                case 13:
                    break;
                case 14:
                    return;
                default:
                    System.out.println("Error");
            }
            
        }
    }
    public void opCRT(){
        Scanner scan = new Scanner(System.in);
        int cantSectores;
        int tamSector;
        String nomRaiz;
        System.out.println("Ingrese la cantidad de sectores");
        cantSectores = scan.nextInt();
        System.out.println("Ingrese tamaño del sector");
        tamSector = scan.nextInt();
        System.out.println("Ingrese nombre de la raíz");
        nomRaiz = scan.nextLine();
        nomRaiz = scan.nextLine();
        CRT(cantSectores, tamSector, nomRaiz);
    }
    
    public void opFLE(){
        Scanner scan = new Scanner(System.in);
        String contenido;
        String nombre;
        String extension;
        System.out.println("Ingrese el contenido");
        contenido = scan.nextLine();
        System.out.println("Ingrese el nombre");
        nombre = scan.nextLine();
        System.out.println("Ingrese la extensión");
        extension = scan.nextLine();
        FLE(contenido,nombre,extension);
    }
    
    public void opMKDIR(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre");
        nombre = scan.nextLine();
        MKDIR(nombre);
    }
    
    public void opCHDIR(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre");
        nombre = scan.nextLine();
        CHDIR(nombre);
    }
    
    public void opMFLE(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        String contenido;
        System.out.println("Ingrese el nombre del archivo a modificar");
        nombre = scan.nextLine();
        System.out.println("Ingrese el nuevo contenido del archivo");
        contenido = scan.nextLine();
        MFLE(nombre, contenido);
    }
    
    public void opPPT(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre del archivo a consultar");
        nombre = scan.nextLine();
        PPT(nombre);
    }
    
    public void opVIEW(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre del archivo a consultar");
        nombre = scan.nextLine();
        VIEW(nombre);
    }
    
    public void opREM(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre del elemento a eliminar");
        nombre = scan.nextLine();
        REM(nombre);
    }
    
   
    //Crear un disco virtual. Raiz y directorio raiz
    public void CRT(int cantidadSectores, int tamSector, String nomRaiz){
        //Crea la raiz pero no se crea el archivo
        //this.raiz = new Raiz(nomRaiz);
        //Se crea el direcotorio raiz
        this.directorioActual = new Directorio(nomRaiz, nomRaiz, null);
        this.raiz = this.directorioActual;
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
                System.out.println("Arc >>> "+elems.get(i).nombre+"."+arch.extension);
            }
            else{
                System.out.println("Dir >>> "+elems.get(i).nombre);
            }
            i++;
        }
    }
    
    public void MFLE(String nombre, String nuevoContenido){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento elemento =elems.get(i);
            if(elemento instanceof Archivo){
                if (elemento.nombre.equals(nombre)){
                    Archivo arch = (Archivo) elemento;
                    Date date = new Date();
                    arch.fecha_modificacion = date;
                    //CAMBIAR CONTENIDO
                    break;
                }
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
                    System.out.println("Nombre              >>> "+arch.nombre);
                    System.out.println("Extensión           >>> "+arch.extension);
                    System.out.println("Fecha Creación      >>> "+arch.fecha_creacion);
                    System.out.println("Fecha Modificación  >>> "+arch.fecha_modificacion);
                    System.out.println("Tamaño              >>> "+arch.tamano);
                    break;
                }
            }
            i++;
        }
    }
    
    public void VIEW(String nombre){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento elemento =elems.get(i);
            if(elemento instanceof Archivo){
                if (elemento.nombre.equals(nombre)){
                    Archivo arch = (Archivo) elemento;
                    //LEER CONTENIDO
                    break;
                }
            }
            i++;
        }
    }
    
    public void REM(String nombre){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele.nombre.equals(nombre)){
                if (ele instanceof Archivo){
                    Archivo arch = (Archivo) elems.get(i);
                    REM_Archivo(arch);
                }
                else{
                    Directorio dir = (Directorio) elems.get(i);
                    REM_Directorio(dir);
                }
                elems.remove(i);
                System.out.println("Elemento eliminado");
                System.out.println("");
                break;
            }
            i++;
        }
    }
    
    public void REM_Archivo(Archivo arch){
        //Eliminar de disco
    }
    
    public void REM_Directorio(Directorio dir){
        ArrayList<Elemento> elems = dir.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele instanceof Archivo){
                Archivo arch = (Archivo) elems.get(i);
                REM_Archivo(arch);
            }
            else{
                Directorio dir2 = (Directorio) elems.get(i);
                REM_Directorio(dir2);
            }
            i++;
        }
    }
    
    public void TREE(){
        ArrayList<Elemento> elems = this.raiz.getElementos();
        int tam = elems.size();
        int i = 0;
        String espacios = " ";
        System.out.println(" ");
        System.out.println("****Elementos dentro de la ruta "+this.raiz.nombre+"****");
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele instanceof Archivo){
                Archivo arch = (Archivo) elems.get(i);
                System.out.println(espacios + "Arc >>> "+arch.nombre+"."+arch.extension);
            }
            else{
                Directorio dir = (Directorio) elems.get(i);
                System.out.println(espacios + "Dir >>> "+dir.nombre);
                printDir(dir.getElementos(), espacios + "   ");
            }
            i++;
        }
        System.out.println(" ");
    }
    
    public void printDir(ArrayList<Elemento> elems, String espacios){
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele instanceof Archivo){
                Archivo arch = (Archivo) elems.get(i);
                System.out.println(espacios + "Arc >>> "+ arch.nombre+"."+arch.extension);
            }
            else{
                Directorio dir = (Directorio) elems.get(i);
                System.out.println(espacios + "Dir >>> "+dir.nombre);
                printDir(dir.getElementos(), espacios + "   ");
            }
            i++;
        }
    }
}
