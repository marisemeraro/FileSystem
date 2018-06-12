/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariana
 */
public class FileSystem {
    public Directorio raiz;
    public Directorio directorioActual;
    public File file;
    BufferedWriter bw;
    public ArrayList<Integer> punterosDisco;
    public int cantidadSectores;
    public int tamSectores;
    public int sectoresDisponibles;
    public int ultimoSector;
    
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
       
        fileSystem.CRT(10, 10, "Root");
        /*fileSystem.FLE("Ronald Bolanos Rodriguez", "ArchivoNuevo", "txt");
        fileSystem.FLE("Hola", "ArchivoNuevo1", "txt");
        fileSystem.FLE("Mariana Rojas", "ArchivoNuevo2", "txt");
        fileSystem.TREE();
        fileSystem.PPT("ArchivoNuevo");
        fileSystem.PPT("ArchivoNuevo1");
        fileSystem.PPT("ArchivoNuevo2");*/
        
        //fileSystem.REM("ArchivoNuevo");
        /*fileSystem.REM("ArchivoNuevo1");
        fileSystem.FLE("Holamaequehacenuevo", "ArchivoNuevo1", "txt");
        fileSystem.PPT("ArchivoNuevo");
        fileSystem.PPT("ArchivoNuevo1");
        fileSystem.PPT("ArchivoNuevo2");
        //fileSystem.REM("ArchivoNuevo2");
        
        fileSystem.MFLE("ArchivoNuevo1", "Adios");*/
        //fileSystem.menu();
        
        fileSystem.MKDIR("Directorio1");
        fileSystem.CHDIR("Directorio1");
        fileSystem.FLE("Ronald", "Archivo1", "txt");
        fileSystem.MKDIR("Directorio1_1");
        fileSystem.CHDIR("Directorio1_1");
        fileSystem.FLE("Ronald", "Archivo1", "txt");
        fileSystem.MKDIR("Directorio1_1_1");
        fileSystem.FLE("Ronald", "Archivo2", "txt");
        fileSystem.FLE("Ronald", "Archivo3", "txt");
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
            System.out.println("La direccion actual en el File System es :"+this.directorioActual.ruta);
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
                    opMOV();
                    break;
                case 11:
                    opREM();
                    break;
                case 12:
                    TREE();
                    break;
                case 13:
                    opFIND();
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
    
    public void opMOV(){
        Scanner scan = new Scanner(System.in);
        String nombreViejo;
        String nombreNuevo;
        String nuevaRuta;
        System.out.println("Ingrese el nombre del elemento a mover");
        nombreViejo = scan.nextLine();
        System.out.println("Ingrese el nuevo nombre del elemento a mover");
        nombreNuevo = scan.nextLine();
        System.out.println("Ingrese la nueva Ruta");
        nuevaRuta = scan.nextLine();
        MOV(nombreViejo, nombreNuevo, nuevaRuta);
    }
    public void opFIND(){
        Scanner scan = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese 1 para buscar por nombre, 2 para buscar por extensión");
        int op = scan.nextInt();
        if (op == 1){
            System.out.println("Ingrese el nombre a buscar");
            nombre = scan.nextLine();
            nombre = scan.nextLine();
            System.out.println("");
            System.out.println("Direcciones: ");
            FIND(this.raiz.getElementos(), nombre);
        }
        else{
            System.out.println("Ingrese la extensión a buscar");
            nombre = scan.nextLine();
            nombre = scan.nextLine();
            System.out.println("");
            System.out.println("Direcciones: ");
            FIND_aux(this.raiz.getElementos(), nombre);
        }
    }
   
    //Crear un disco virtual. Raiz y directorio raiz
    public void CRT(int cantidadSectores, int tamSector, String nomRaiz){
        this.ultimoSector = -1;
        this.cantidadSectores = cantidadSectores;
        this.tamSectores = tamSector;
        this.sectoresDisponibles = cantidadSectores;
        //Crea la raiz pero no se crea el archivo
        //this.raiz = new Raiz(nomRaiz);
        //Se crea el direcotorio raiz
        this.directorioActual = new Directorio(nomRaiz, nomRaiz, null);
        this.raiz = this.directorioActual;
        //Se inicializa el arreglo de punteros para el achivo de disco
        punterosDisco = new ArrayList<>();
        try{
            //Se crea el archivo
            //C:\\Users\\Andres\\Desktop\\
            //C:\\Users\\Mariana\\Desktop\\
            this.file = new File("C:\\Users\\Mariana\\Desktop\\"+nomRaiz+".txt");
            String buffer = "*";
            for (int i = 0; i < cantidadSectores; i++) {
                for (int j = 0; j < tamSector; j++) {
                    buffer = buffer + "X";
                }
                buffer = buffer + "*";
                punterosDisco.add(-1);
            }
            EscribirArchivo(buffer);
            System.out.println("****La raíz ha sido creada con el nombre de "+nomRaiz+"****");
            System.out.println(punterosDisco);
        }
        catch(Exception e){
            System.out.println("***Error al crear el el disco****");
        } 
    }
    
    //Crea un nuevo archivo en el directorio actual
    public void FLE(String contenido, String nombre, String extension){ 
        int sector_inicial = EscribirTextoDisco(contenido);
        if (sector_inicial != -1){
            if (directorioActual != null){
                String ruta = this.directorioActual.ruta + "/" + nombre +"."+ extension;
                Date date = new Date();
                Archivo arch = new Archivo(nombre, ruta, extension, 0, contenido.length(), date, date, sector_inicial, this.ultimoSector);
                this.directorioActual.agregarElemento(arch);
                System.out.println("****El archivo "+nombre+" ha sido creado en la dirección "+directorioActual.ruta+"****");
            }
            else{
                System.out.println("****Error!!! Debe crear un directorio inicial****");
            }
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
                    REM_Archivo(arch); //borra contenido de archivo en disco
                    int sector_inicial = EscribirTextoDisco(nuevoContenido);
                    arch.sector_inicial = sector_inicial;
                    arch.sector_final = this.ultimoSector;
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
                    System.out.println("Sector inicial      >>> "+arch.sector_inicial);
                    System.out.println("Sector final        >>> "+arch.sector_final);
                    System.out.println("Ruta                >>> "+arch.ruta);
                    break;
                }
            }
            i++;
        }
    }
    
    //Ver el contenido de un archivo
    public void VIEW(String nombre){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento elemento =elems.get(i);
            if(elemento instanceof Archivo){
                if (elemento.nombre.equals(nombre)){
                    Archivo arch = (Archivo) elemento;
                    leerArchivo(arch.sector_inicial, arch.sector_final);
                    break;
                }
            }
            i++;
        }
    }
    
    public ArrayList<Integer> listaPunteros(int sectorInicial, int sectorFinal){
        ArrayList<Integer> listaPunteros = new ArrayList<Integer>();
        int i =0;
        int sectorActual = sectorInicial;
        while(i!=this.punterosDisco.size()){
            if (sectorActual == sectorFinal){
                listaPunteros.add(sectorActual);
                break;
            }
            else{
                listaPunteros.add(sectorActual);
                sectorActual = this.punterosDisco.get(sectorActual);
            }i++;
        }
        return listaPunteros;
    }
    public void leerArchivo(int sectorInicial, int sectorFinal){
        String textoDisco = "";
        String resultado="";
        try {
            textoDisco = getBufferFile();
        } catch (IOException ex) {
            Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cont = 1;
        int sectorActual=0;
        ArrayList<Integer> listaPunteros = listaPunteros(sectorInicial, sectorFinal);
        while(cont < textoDisco.length()-1){
            if(textoDisco.charAt(cont)=='*'){
                sectorActual++;
            }
            else{
                if ((sectorActual>=sectorInicial) && (sectorActual<=sectorFinal) && listaPunteros.contains(sectorActual)){
                    if(textoDisco.charAt(cont) != 'X')
                        resultado = resultado + textoDisco.charAt(cont);
                }
            }
            cont++;
        }
        System.out.println("");
        System.out.println("El contenido del archivo es:");
        System.out.println(resultado);
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
    
    public int buscarSector(int sector){
        int i = 0;
        while (i!= this.punterosDisco.size()){
            if (this.punterosDisco.get(i)==sector){
                return i;
            }
            i++;
        }
        return -3;
    }
    
    public void eliminarPunteros (int sectorInicial, int sectorFinal){
        ArrayList<Integer> listaPunteros = listaPunteros(sectorInicial, sectorFinal);
        int i = 0;
        while (i!= this.punterosDisco.size()){
            if (i >= sectorInicial && i<= sectorFinal && listaPunteros.contains(i)){
                this.punterosDisco.set(i, -1);
            }
            i++;
        }
    }
    
    public void REM_Archivo(Archivo arch){
        int sectorInicial = arch.sector_inicial;
        int sectorFinal = arch.sector_final;
        String textoDisco = "";
        String resultado="";
        ArrayList<Integer> listaPunteros = listaPunteros(arch.sector_inicial, arch.sector_final);
        try {
            textoDisco = getBufferFile();
        } catch (IOException ex) {
            Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cont = 0;
        int sectorActual=-1;
        while(cont < textoDisco.length()-1){
            if(textoDisco.charAt(cont)=='*'){
                sectorActual++;
                resultado = resultado + textoDisco.charAt(cont);
            }
            else{
                if ((sectorActual>=sectorInicial) && (sectorActual<=sectorFinal) && listaPunteros.contains(sectorActual)){
                    resultado = resultado + 'X';
                }
                else{
                    resultado = resultado + textoDisco.charAt(cont);
                }
            }
            cont++;
        }

        try {
            EscribirArchivo(resultado);
        } catch (IOException ex) {
            Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int puntero = buscarSector(sectorInicial);
        //Nadie lo apunta (es el primero)
        if(puntero==-3){
            eliminarPunteros(sectorInicial,sectorFinal);
        }
        else{
            //es el ultimo sector
            if(this.punterosDisco.get(sectorFinal) == -2){
                this.ultimoSector = puntero;
                this.punterosDisco.set(puntero, -2);
            }
            else{
                this.punterosDisco.set(puntero, punterosDisco.get(sectorFinal));
            }
        }
        eliminarPunteros(sectorInicial,sectorFinal);
        
        System.out.println("");
        System.out.println("El contenido del archivo es:");
        System.out.println(resultado);
        System.out.println(this.punterosDisco);
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
    
    public void FIND(ArrayList<Elemento> elems, String nombre){
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele.nombre.equals(nombre))
                    System.out.println(ele.ruta);
            if (ele instanceof Directorio){
                Directorio dir = (Directorio) elems.get(i);
                FIND(dir.getElementos(), nombre);
            }i++;
        }
    }
    
    public void FIND_aux(ArrayList<Elemento> elems, String extension){
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele instanceof Archivo){
                Archivo arch = (Archivo) elems.get(i);
                if (arch.extension.equals(extension))
                    System.out.println(arch.ruta);
            }
            else{
               Directorio dir = (Directorio) elems.get(i);
               FIND_aux(dir.getElementos(), extension);
            }i++;
        }
    }
    
    public void MOV(String nombreViejo, String nombreNuevo, String nuevaRuta){
        ArrayList<Elemento> elems = this.directorioActual.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele.nombre.equals(nombreViejo)){
                if(MOV_aux(ele, nuevaRuta, nombreNuevo))
                    elems.remove(i);
                else
                    System.out.println("No se pudo mover");
                break;
            }
            i++;
        }
    }
    
    public boolean MOV_aux(Elemento elemento, String ruta, String nuevoNombre){
        ArrayList<Elemento> elems = this.raiz.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento ele = elems.get(i);
            if (ele instanceof Directorio && ele.ruta.equals(ruta)){
                Directorio directorio = (Directorio) ele;
                if (buscarNombre(nuevoNombre, directorio))
                        return false;
                Date date = new Date();
                elemento.nombre = nuevoNombre;
                elemento.fecha_modificacion = date;
                if(elemento instanceof Archivo){
                    Archivo arch = (Archivo) elemento;
                    arch.fecha_modificacion = date;
                    elemento.ruta = directorio.ruta + "/" + arch.nombre +"."+ arch.extension;
                }
                else{
                    Directorio dir = (Directorio) elemento;
                    dir.fecha_modificacion = date;
                    elemento.ruta = directorio.ruta + "/" + elemento.nombre;
                    dir.ruta = directorio.ruta + "/" + dir.nombre;
                    cambiarRuta(dir);
                }
                directorio.agregarElemento(elemento);
                return true;
            }
            i++;
        }
        return false;
    }
    public void cambiarRuta(Directorio dir){
        ArrayList<Elemento> elems = dir.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele instanceof Archivo){
                Archivo arch = (Archivo) elems.get(i);
                arch.ruta = dir.ruta + "/" + arch.nombre +"."+ arch.extension;
            }
            else{
                Directorio directorio = (Directorio) elems.get(i);
                directorio.ruta = dir.ruta + "/" + directorio.nombre;
                cambiarRuta(directorio);
            }
            i++;
        }
    }
    public boolean buscarNombre(String nombre, Directorio dir){
        ArrayList<Elemento> elems = dir.getElementos();
        int tam = elems.size();
        int i = 0;
        while(i!=tam){
            Elemento  ele = elems.get(i);
            if (ele.nombre.equals(nombre)){
                return true;
            }
            i++;
        }
        return false;
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
    
    public String getBufferFile() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader (this.file);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        return linea;
    }
    
    //Crea el buffer q se va a copiar en el archivo
    /*
    En el arreglo de punteros la siglas son:
    -1 = no hay nada en el sector
    -2 = representa el ultimo sector ocupado
    0 = no tiene referencia a ninguno otro, solo ocupa un sector
    Culaquier otro positivo = referencia al siguiente sector
    */
    //Funcion para escribir texto en el archivo
    public int EscribirTextoDisco(String texto){
        String textoDisco = "";
        try {
            textoDisco = getBufferFile();
        } catch (IOException ex) {
            Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nuevoBuffer = "";
        int sectores_menos =  0;
        if (texto.length() <= this.tamSectores*SectoresDisponibles()){
            int sector = -1;
            int cont = 0;
            while(cont < textoDisco.length()-1){
                if (textoDisco.charAt(cont) == '*'){
                    if (sector <= this.cantidadSectores){
                        sector = sector + 1;
                        if (textoDisco.charAt(cont + 1) == 'X'){ 
                            this.sectoresDisponibles = this.sectoresDisponibles - ((texto.length()/this.tamSectores) + 1);
                            String res = EscribirTextoDiscoAuxiliar(textoDisco, texto, sector);
                            System.out.println("Este es el buffer "+res);
                            System.out.println("Estos son los punteros "+this.punterosDisco);
                            System.out.println("Esta es la cantidad de sectores disponibles "+this.sectoresDisponibles);
                            try {
                                EscribirArchivo(res);
                            } catch (IOException ex) {
                                Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            return sector;
                        }
                        else{
                            cont = cont + this.tamSectores;
                        }
                    }
                }
                cont = cont + 1;
            }
            return -1;
        }
        else{
            System.out.println("****No hay espacio suficiente para el mensaje****");
            return -1;
        }
    }
    
    public String EscribirTextoDiscoAuxiliar(String textoDisco, String contenido, int sector){
        int ultimo_temp = this.ultimoSector;
        boolean escribir = false;
        String nuevoBuffer = "";
        int posContenido = 0;
        int sectorLogico = -1;
        int sectorAnterior = 0;
        int contador = 0;
        boolean permitir = false;
        System.out.println(sector);
        while (contador < textoDisco.length()) {
            if (sectorLogico == sector || escribir == true){
                escribir = true;
                if (textoDisco.charAt(contador) != '*'){
                    if (posContenido < contenido.length()){
                        if (permitir){
                            nuevoBuffer = nuevoBuffer + contenido.charAt(posContenido);
                            posContenido = posContenido + 1;  
                        }
                        else{
                            nuevoBuffer = nuevoBuffer + textoDisco.charAt(contador);
                        }
                        if (sectorLogico == sector){
                            sectorAnterior = sectorLogico;
                        }
                        else{
                            if (permitir){
                               this.punterosDisco.set(sectorAnterior, sectorLogico);            
                                sectorAnterior = sectorLogico; 
                            }
                            
                        }
                    }
                    else{
                        this.punterosDisco.set(sectorLogico, 0);
                        nuevoBuffer = nuevoBuffer + textoDisco.charAt(contador);
                        escribir = false;
                        sectorLogico = sectorLogico + 1;
                    }
                }
                else{
                    permitir = true;
                    if (textoDisco.length() > contador+1){
                        if (textoDisco.charAt(contador+1) != 'X'){
                            permitir = false;
                        }
                    }
                    nuevoBuffer = nuevoBuffer + textoDisco.charAt(contador);
                    sectorLogico = sectorLogico + 1;
                }
            }
            else{
                permitir = true;
                nuevoBuffer = nuevoBuffer + textoDisco.charAt(contador);
                if (textoDisco.charAt(contador) == '*'){
                    if (textoDisco.length() > contador+1){
                        if (textoDisco.charAt(contador+1) != 'X'){
                            permitir = false;
                        }
                    }
                    sectorLogico = sectorLogico + 1;
                }
            }
            contador++;
        }

        if(this.ultimoSector != -1){
            this.punterosDisco.set(ultimo_temp, sector);
        }
        this.ultimoSector = sectorAnterior;
        this.punterosDisco.set(this.ultimoSector, -2);
        
        return nuevoBuffer;
    }
    
    //Buscar cantidad de sectores disponibles
    public int SectoresDisponibles(){
        int cantidad = 0;
        for (int i = 0; i < this.punterosDisco.size(); i++) {
            if (punterosDisco.get(i) == -1){
                cantidad = cantidad + 1;
            }
        }
        return cantidad;
    }
    
    //Escribe el texto de entrada en el archivo y reemplaza
    public void EscribirArchivo(String buffer) throws IOException{
        if (this.file.exists()){
          try {
              bw = new BufferedWriter(new FileWriter(file));
              bw.write(buffer);
          } catch (IOException ex) {
              Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
          }
         }
         else{
            try {
                bw = new BufferedWriter(new FileWriter(file));
            } catch (IOException ex) {
                Logger.getLogger(FileSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
             bw.write("Acabo de crear el fichero de texto.");
         }
         bw.close();
    }
}
