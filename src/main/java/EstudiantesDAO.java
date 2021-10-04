import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudiantesDAO {
    Conexion c = new Conexion();    
    
    
    
    public EstudiantesDAO(){
        c.abrirConexion();
    }
    
    
    
    public void finalizar(){
        c.cerrarConexion();
    }
    
    
    
    public void insertarEstudiante(String nombres, String apellidos, String fecha, String correo_ins, String correo_per, long num_fijo, long num_cel, String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Insert into Estudiantes values(?,?,?,?,?,?,?,?)");
            pst.setString(1, nombres);
            pst.setString(2, apellidos);
            pst.setString(3, fecha);
            pst.setString(4, correo_ins);
            pst.setString(5, correo_per);
            pst.setString(6, String.valueOf(num_cel));
            pst.setString(7, String.valueOf(num_fijo));
            pst.setString(8, programa);
            pst.executeUpdate();
            System.out.println("\n" + "Se agregó el estudiante\n");
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void buscarCorreo(String correo_ins){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Correo_Institucional = ?");
            pst.setString(1, correo_ins);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Nombres: " + rs.getString("Nombres") + "\n"
                                + "Apellidos: " + rs.getString("Apellidos") + "\n"
                                + "Fecha nacimiento: " + rs.getString("Fecha_Nacimiento") + "\n"
                                + "Correo institucional: " + rs.getString("Correo_Institucional") + "\n"
                                + "Correo personal: " + rs.getString("Correo_Personal") + "\n"
                                + "Número de teléfono celular: " + rs.getString("Numero_Celular") + "\n"
                                + "Número de teléfono fijo: " + rs.getString("Numero_Fijo") + "\n"
                                + "Programa académico: " + rs.getString("Programa") + "\n");
            } else {
                System.out.println("No hay resultados para esa consulta" + "\n");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void buscarApellidos(String apellidos){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Apellidos = ?");
            pst.setString(1, apellidos);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Nombres: " + rs.getString("Nombres") + "\n"
                                + "Apellidos: " + rs.getString("Apellidos") + "\n"
                                + "Fecha nacimiento: " + rs.getString("Fecha_Nacimiento") + "\n"
                                + "Correo institucional: " + rs.getString("Correo_Institucional") + "\n"
                                + "Correo personal: " + rs.getString("Correo_Personal") + "\n"
                                + "Número de teléfono celular: " + rs.getString("Numero_Celular") + "\n"
                                + "Número de teléfono fijo: " + rs.getString("Numero_Fijo") + "\n"
                                + "Programa académico: " + rs.getString("Programa") + "\n");
            } else {
                System.out.println("No hay resultados para esa consulta" + "\n");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void buscarPrograma(String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select Nombres, Apellidos from Estudiantes where Programa = ?");
            pst.setString(1, programa);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("\n" + rs.getString("Apellidos") + " " + rs.getString("Nombres") + "\n");
            }            
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void buscarProgramaCantidad(String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Programa = ?");
            pst.setString(1, programa);
            ResultSet rs = pst.executeQuery();
            int cantidad = 0;
            while (rs.next()) {
                cantidad = cantidad + 1;
            }
            System.out.println("Cantidad estudiantes " + programa + ": " + cantidad + "\n");
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void buscarFecha(String fecha){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Fecha_Nacimiento = ?");
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Nombres: " + rs.getString("Nombres") + "\n"
                                + "Apellidos: " + rs.getString("Apellidos") + "\n"
                                + "Fecha nacimiento: " + rs.getString("Fecha_Nacimiento") + "\n"
                                + "Correo institucional: " + rs.getString("Correo_Institucional") + "\n"
                                + "Correo personal: " + rs.getString("Correo_Personal") + "\n"
                                + "Número de teléfono celular: " + rs.getString("Numero_Celular") + "\n"
                                + "Número de teléfono fijo: " + rs.getString("Numero_Fijo") + "\n"
                                + "Programa académico: " + rs.getString("Programa") + "\n");
            } else {
                System.out.println("No hay resultados para esa consulta" + "\n");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void buscarNumCel(long num_cel){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Numero_Celular = ?");
            pst.setString(1, String.valueOf(num_cel));
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("\n" + rs.getString("Apellidos") + " " + rs.getString("Nombres") + " " + rs.getString("Programa") + "\n");
            } else {
                System.out.println("No hay resultados para esa consulta" + "\n");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void modificarEstudiante(String correo_ins, String correo_per, long num_cel, long num_fijo, String programa){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Update Estudiantes set Correo_Personal = ?, Numero_Celular = ?, Numero_Fijo = ?, Programa = ? where Correo_Institucional = ?");
            pst.setString(1, correo_per);
            pst.setString(2, String.valueOf(num_cel));
            pst.setString(3, String.valueOf(num_fijo));
            pst.setString(4, programa);
            pst.setString(5, correo_ins);
            pst.executeUpdate();
            System.out.println("\n" + "Se modificó el estudiante" + "\n");
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void eliminarEstudiante(String correo_ins){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Delete from Estudiantes where Correo_Institucional = ?");
            pst.setString(1, correo_ins);
            pst.executeUpdate();
            System.out.println("\n" + "Se eliminó el estudiante" + "\n");
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public void directorioEstudiantes(){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Nombres: " + rs.getString("Nombres") + "\n"
                                + "Apellidos: " + rs.getString("Apellidos") + "\n"
                                + "Fecha nacimiento: " + rs.getString("Fecha_Nacimiento") + "\n"
                                + "Correo institucional: " + rs.getString("Correo_Institucional") + "\n"
                                + "Correo personal: " + rs.getString("Correo_Personal") + "\n"
                                + "Número de teléfono celular: " + rs.getString("Numero_Celular") + "\n"
                                + "Número de teléfono fijo: " + rs.getString("Numero_Fijo") + "\n"
                                + "Programa académico: " + rs.getString("Programa") + "\n");
            }
            pst.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public boolean verificarBD(String correo_ins){
        try {
            PreparedStatement pst = c.conexion.prepareStatement("Select * from Estudiantes where Correo_Institucional = ?");
            pst.setString(1, correo_ins);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}