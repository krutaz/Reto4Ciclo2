import java.util.Scanner;

public class VistaConsola {
    private Scanner leer;
    
    
    
    public VistaConsola(){
        leer = new Scanner(System.in);
    }
    
    
    
    public String leerDatosString(String mensaje){
        System.out.println(mensaje);
        String dato = leer.nextLine();
        return dato;
    }
    
    
    
    public long leerDatosLong(String mensaje){
        long dato = 0;
        try {
            System.out.println(mensaje);
            dato = leer.nextLong();
            leer.nextLine();
        } catch (Exception e) {
            leer.nextLine();
            System.out.println("El dato ingresado no es un número");
            dato = 0;
        }
        return dato;
    }
    
    
    
    public int leerDatosInt(String mensaje){
        int dato = 0;
        try {
            System.out.println(mensaje);
            dato = leer.nextInt();
            leer.nextLine();
        } catch (Exception e) {
            leer.nextLine();
            System.out.println("El dato ingresado no es un número" + "\n");
            dato = 0;
        }
        return dato;
    }
    
    
    
    public boolean validarDatos(int dato){
        if (dato != 0) {
            return true;            
        } else {
            return false;
        }
    }
}