public class Mainapp {
    public static void main(String[] args) {
        EstudiantesDAO e = new EstudiantesDAO();
        Estudiantes est = new Estudiantes();
        VistaConsola v = new VistaConsola();
        
        
        
        int opcion = 0;
        String nombres;
        String apellidos;
        String fecha;
        String correo_ins;
        String correo_per;
        long num_fijo;
        long num_cel;
        String programa;
        
        
        
        do{ 
            System.out.println("INSTITUTO LA FLORESTA\n"
                    + "Seleccione tarea a realizar:\n"
                    + "1. Ingresar estudiante\n"
                    + "2. Consultas\n"
                    + "3. Modificar estudiante\n"
                    + "4. Eliminar estudiante\n"
                    + "5. Ver directorio de estudiantes\n"
                    + "6. Salir");
            opcion = v.leerDatosInt("Opción:");
            
            
            
            switch(opcion){
                case 1:
                    nombres = v.leerDatosString("Ingresar estudiante\n"
                            + "Ingresar nombres:");
                    apellidos = v.leerDatosString("Ingresar apellidos:");
                    fecha = v.leerDatosString("Ingresar fecha de nacimiento (YYYY-MM-DD):");
                    correo_ins = v.leerDatosString("Ingresar correo institucional:");
                    correo_per = v.leerDatosString("Ingresar correo personal:");
                    num_cel = v.leerDatosLong("Ingresar número de celular:");
                    num_fijo = v.leerDatosLong("Ingresar número fijo:");
                    programa = v.leerDatosString("Ingresar programa:");
                    e.insertarEstudiante(nombres, apellidos, fecha, correo_ins, correo_per, num_fijo, num_cel, programa);
                    break;
                case 2:
                    while (opcion != 7){
                        System.out.println("Consultas\n"
                            + "Seleccione consulta a realizar:\n"
                            + "1. Buscar estudiante por correo electrónico\n"
                            + "2. Buscar estudiante por apellidos\n"
                            + "3. Buscar por programa\n"
                            + "4. Buscar cantidad de estudiantes por programa\n"
                            + "5. Buscar por fecha de nacimiento\n"
                            + "6. Buscar por número de celular\n"
                            + "7. Regresar");
                        opcion = v.leerDatosInt("Opción:");
                    
                    
                    
                        switch(opcion){
                            case 1:
                                correo_ins = v.leerDatosString("1. Buscar estudiante por correo electrónico\n"
                                        + "Ingresar correo institucional:");
                                if(e.verificarBD(correo_ins)){
                                    est.setCorreo_ins(correo_ins);
                                    e.buscarCorreo(correo_ins);
                                } else {
                                    System.out.println("El estudiante no se encuentra registrado en el instituto\n");
                                }
                                break;
                            case 2:
                                apellidos = v.leerDatosString("2. Buscar estudiante por apellidos\n"
                                        + "Ingresar apellidos:");
                                e.buscarApellidos(apellidos);
                                break;
                            case 3:
                                programa = v.leerDatosString("3. Buscar por programa\n"
                                        + "Ingresar programa:");
                                e.buscarPrograma(programa);
                                break;
                            case 4:
                                programa = v.leerDatosString("4. Buscar cantidad de estudiantes por programa\n"
                                        + "Ingresar programa:");
                                e.buscarProgramaCantidad(programa);
                                break;
                            case 5:
                                fecha = v.leerDatosString("5. Buscar por fecha de nacimiento\n"
                                        + "Ingresar fecha de nacimiento:");
                                e.buscarFecha(fecha);
                                break;
                            case 6:
                                num_cel = v.leerDatosLong("6. Buscar por número de celular\n"
                                        + "Ingresar número de celular:");
                                e.buscarNumCel(num_cel);                            
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Error: Opción no valida");
                            }
                        }break;
                case 3:
                    correo_ins = v.leerDatosString("Modificar estudiante\n"
                            + "Ingresar correo institucional:");
                    if(e.verificarBD(correo_ins)){
                        est.setCorreo_ins(correo_ins);
                        correo_per = v.leerDatosString("Ingresar correo personal:");
                        num_cel = v.leerDatosLong("Ingresar número de celular:");
                        num_fijo = v.leerDatosLong("Ingresar número fijo:");
                        programa = v.leerDatosString("Ingresar programa:");
                        e.modificarEstudiante(correo_ins, correo_per, num_cel, num_fijo, programa);
                    } else {
                        System.out.println("El estudiante no se encuentra registrado en el instituto\n");
                    }
                    break;
                case 4:
                    correo_ins = v.leerDatosString("Eliminar estudiante\n"
                            + "Ingresar correo institucional:");
                    if(e.verificarBD(correo_ins)){
                        est.setCorreo_ins(correo_ins);
                        e.eliminarEstudiante(correo_ins);
                    } else {
                        System.out.println("El estudiante no se encuentra registrado en el instituto\n");
                    }
                    break;
                case 5:
                    System.out.println("El directorio de los estudiantes");
                    e.directorioEstudiantes();
                    break;
                case 6:
                    System.out.println("Hasta pronto");
                    e.finalizar();
                    break;
                default:
                    System.out.println("Error: Opción no valida");
            }
        }while(opcion != 6);
    }
}
