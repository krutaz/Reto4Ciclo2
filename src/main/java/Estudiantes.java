public class Estudiantes {
    private String nombres;
    private String apellidos;
    private String fecha;
    private String correo_ins;
    private String correo_per;
    private long num_fijo;
    private long num_cel;
    private String programa;
    
    
    
    public Estudiantes(){
        
    }
    
    
    
    public Estudiantes(String nombres, String apellidos, String fecha, String correo_ins, String correo_per, long num_fijo, long num_cel, String programa){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.correo_ins = correo_ins;
        this.correo_per = correo_per;
        this.num_fijo = num_fijo;
        this.num_cel = num_cel;
        this.programa = programa;
    }

    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCorreo_ins() {
        return correo_ins;
    }

    public void setCorreo_ins(String correo_ins) {
        this.correo_ins = correo_ins;
    }

    public String getCorreo_per() {
        return correo_per;
    }

    public void setCorreo_per(String correo_per) {
        this.correo_per = correo_per;
    }

    public long getNum_fijo() {
        return num_fijo;
    }

    public void setNum_fijo(long num_fijo) {
        this.num_fijo = num_fijo;
    }

    public long getNum_cel() {
        return num_cel;
    }

    public void setNum_cel(long num_cel) {
        this.num_cel = num_cel;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}