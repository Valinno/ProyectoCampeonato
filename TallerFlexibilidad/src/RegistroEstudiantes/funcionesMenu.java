/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALVARO
 */

public class funcionesMenu {

    private int RespuestaGeneral;

   // Metodo para capturar datos
   private Registro ManipulacionDatos(String Titulo) {
        
        Registro DatoAlumno=new Registro();
        boolean EstadoNotas;
        boolean EstadoStrings;
        Validaciones objetoValidar;
        
        // Bucle para evitar que escapen entradas vacías ""
        do {
            // Objeto para validar casillas vacías o nulas
            objetoValidar = new Validaciones();
            EstadoStrings = true;
            
            DatoAlumno.setId(JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", Titulo, 0));
            DatoAlumno.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", Titulo, 0));
            DatoAlumno.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", Titulo, 0));
                
            objetoValidar.ValidacionString(DatoAlumno.getId(), "Identificación", Titulo);
            objetoValidar.ValidacionString(DatoAlumno.getNombr(), "Nombre", Titulo);
            objetoValidar.ValidacionString(DatoAlumno.getApel(), "Apellido", Titulo);

            if (objetoValidar.getContador()>0) {
                EstadoStrings = false; 
                JOptionPane.showMessageDialog(null, "Las siguientes casillas se encuentran vacías: " + objetoValidar.getLista() + ". Por favor intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
            }
                        
        } while(EstadoStrings == false);
        
        // Bucle para evitar que escapen entradas negativas
        do {
            // Objeto para validar casillas vacías o nulas
            objetoValidar = new Validaciones();
            EstadoNotas = true;
            try {
                DatoAlumno.setNotas(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", Titulo, 0))
                , Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", Titulo, 0))
                , Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", Titulo, 0)));
            } catch (NumberFormatException | NullPointerException e) {
                EstadoNotas = false;
                JOptionPane.showMessageDialog(null, "Error. No se permiten valores alfanuméricos o nulos. Por favor intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
            }
            // Si el estado del bucle no ha fallado (Excepciones), continúa con la validación
            if (EstadoNotas != false) {
                objetoValidar.ValidacionNumeros(DatoAlumno.getNot1(), "Nota °1", Titulo);
                objetoValidar.ValidacionNumeros(DatoAlumno.getNot2(), "Nota °2", Titulo);
                objetoValidar.ValidacionNumeros(DatoAlumno.getNot3(), "Nota °3", Titulo);
                
                if (objetoValidar.getContador() > 0) {
                    JOptionPane.showMessageDialog(null, "Las siguientes notas: " + objetoValidar.getLista() + " están fuera de rango (0pts a 5pts). Por favor intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
                    EstadoNotas = false;
                } else {
                    DatoAlumno.setProm((float) ((0.3*(DatoAlumno.getNot1()+DatoAlumno.getNot2()))+(0.4*DatoAlumno.getNot3())));
                }
            }
        } while(EstadoNotas == false);
        
        return DatoAlumno;
            
    }

// Metodo para añadir datos a la lista
   public void capturar_datos(ArrayList<Registro> alumnos) {
        
       metodosBusqueda objetoBusqueda;
       
        do {
            // Objeto para verificar C.C o D.I repetido
            objetoBusqueda = new metodosBusqueda();
            // Objeto auxiliar
            Registro x=new Registro();
            x = ManipulacionDatos("Captura de Datos");
            objetoBusqueda = new metodosBusqueda(x.getId(), alumnos, 0);
            // Si no hay duplicados continua el ingreso de datos
            if (!objetoBusqueda.getDuplicado()) {
                alumnos.add(x);
                RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea seguir suministrando Informacion?", "Captura de Datos", JOptionPane.YES_NO_OPTION);
            } else {
                RespuestaGeneral=JOptionPane.NO_OPTION;
            }

        } while (RespuestaGeneral == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "Proceso finalizado.");
    }
    

// Metodo para actualizar el objeto de la lista de alumnos, dato por dato
   public void actualizar(ArrayList<Registro> alumnos) {

    int Posicion_Actualizar = -1;
    Registro x=new Registro();
    // Consulta el objeto a actualizar, si no existe su código retorna -1
    Posicion_Actualizar = consultar(alumnos);

    // Evita el intento de actualizar datos fuera de la lista
    if (Posicion_Actualizar>=0 && Posicion_Actualizar<alumnos.size()) {

        RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea ACTUALIZAR los datos de este estudiante?", "Actualización de Datos", JOptionPane.YES_NO_OPTION);
        
        if (RespuestaGeneral == JOptionPane.YES_OPTION) {
            
            x = alumnos.get(Posicion_Actualizar);
            int Respuesta;
            metodosBusqueda objetoBusqueda;
            int Opcion_Datos;
            // Estado del bucle de notas
            boolean estado;
            boolean CambiarPromedioAuto = true;
            // Estado del bucle de cadenas
            boolean EstadoStrings;
            Validaciones objetoValidar;
            
            do {
                estado = true;
                Opcion_Datos = -1;
                try {
                    Opcion_Datos=Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué datos desea actualizar?\n1. Código\n2. Nombre\n3. Apellido\n4. Nota °1\n5. Nota °2\n6. Nota °3\n7. Promedio Académico\n8. Salir", "Menú Actualización de Datos", JOptionPane.QUESTION_MESSAGE));
                    if (Opcion_Datos <= 3) {
                        do {
                            objetoValidar = new Validaciones();
                            objetoValidar.setContador(0);
                            EstadoStrings = true;
                             // Primera parte del menu secundario de actualizacion dato por dato
                            switch(Opcion_Datos) {
                                case 1 -> {
                                    String codigoID;
                                    codigoID = JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", "Actualización de Datos", 0);
                                    objetoBusqueda = new metodosBusqueda(codigoID, alumnos, 0);
                                    if (!objetoBusqueda.getDuplicado()) {
                                        x.setId(codigoID);
                                        objetoValidar.ValidacionString(x.getId(), "Identificación", "Actualización de Datos");
                                    }
                                }
                                case 2 -> {
                                    x.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", "Actualización de Datos", 0));
                                    objetoValidar.ValidacionString(x.getNombr(), "Nombre", "Actualización de Datos");
                                }
                                case 3 -> {
                                    x.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", "Actualización de Datos", 0));
                                    objetoValidar.ValidacionString(x.getApel(), "Apellido", "Actualización de Datos");
                                }
                                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                            }
                            
                            if (objetoValidar.getContador() > 0) {
                                JOptionPane.showMessageDialog(null, "La siguiente casilla: " + objetoValidar.getLista() + " se encuentra vacía o nula. Por favor ingrésela nuevamente.", "Actualización de Datos", JOptionPane.WARNING_MESSAGE);
                                EstadoStrings = false;
                            }
                        } while(EstadoStrings == false);
                    } else {
                        do {
                            objetoValidar = new Validaciones();
                            objetoValidar.setContador(0);
                            estado = true; 
                            // Segunda parte del menu secundario de actualizacion dato por dato
                            switch(Opcion_Datos) {
                                case 4 -> {
                                    x.setNot1(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", "Actualización de Datos", 0)));
                                    objetoValidar.ValidacionNumeros(x.getNot1(), "Nota °1", "Actualización de Datos");
                                }
                                case 5 -> {
                                    x.setNot2(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", "Actualización de Datos", 0)));
                                    objetoValidar.ValidacionNumeros(x.getNot2(), "Nota °2", "Actualización de Datos");
                                }
                                case 6 -> {
                                    x.setNot3(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", "Actualización de Datos", 0)));
                                    objetoValidar.ValidacionNumeros(x.getNot3(), "Nota °3", "Actualización de Datos");
                                }
                                case 7 -> {
                                    int RespuestaPromedio;
                                    RespuestaPromedio=JOptionPane.showConfirmDialog(null, "¿Desea calcular el promedio en automático?", "Actualización de Datos", JOptionPane.YES_NO_OPTION);
                                    if (RespuestaPromedio != JOptionPane.YES_OPTION) {
                                        x.setProm(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite el promedio académico del alumno.", "Actualización de Datos", 0)));
                                        objetoValidar.ValidacionNumeros(x.getProm(), "Promedio Académico", "Actualización de Datos");
                                        CambiarPromedioAuto = false;
                                    } else {
                                        CambiarPromedioAuto = true;
                                    }
                                }
                                case 8 -> {
                                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...", "Acutalización de Datos", JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }
                                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                            } 
                            
                            if (objetoValidar.getContador() > 0) {
                                JOptionPane.showMessageDialog(null, "La siguiente nota: " + objetoValidar.getLista() + " están fuera de rango (0pts a 5pts). Por favor intente de nuevo.", "Actualización de Datos", JOptionPane.WARNING_MESSAGE);
                                estado = false;
                            } else {
                                if (CambiarPromedioAuto == true) {
                                    x.setProm((float) ((0.3*(x.getNot1()+x.getNot2()))+(0.4*x.getNot3())));
                                }
                            }
                        } while(estado == false);
                    }
                } catch (NumberFormatException | NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                }
                Respuesta=JOptionPane.showConfirmDialog(null, "¿Desea seguir actualizando datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            } while (Respuesta == JOptionPane.YES_OPTION);  
            JOptionPane.showMessageDialog(null, "Actualización de datos terminada.");
        }
    }
}

// Objeto para borrar el objeto de la lista de alumnos
   public void borrar(ArrayList<Registro> alumnos) {
    int PosicionBorrar = -1;

    PosicionBorrar = consultar(alumnos);

    if (PosicionBorrar>=0 && PosicionBorrar<alumnos.size()) {
        
        RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea ELIMINAR este estudiante de la base de datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (RespuestaGeneral == JOptionPane.YES_OPTION) {
            
            alumnos.remove(PosicionBorrar);
            
            JOptionPane.showMessageDialog(null, "Estudiante eliminado del  con exito.");
        }
    }
}



// Muestra todos los objetos de la lista alumnos
   public void informe(ArrayList<Registro> ListaAlumnos) {
       
        // Objeto para mostrar panel de información con scroll integrado
       metodosScroll scroll=new metodosScroll();
       
       if (ListaAlumnos.isEmpty()) {
           JOptionPane.showMessageDialog(null, "La base de datos está vacía. Por favor llene los datos antes de consultar.", "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.WARNING_MESSAGE);
           return;
        }
        StringBuilder mostrarLista=new StringBuilder();
        String ver = null;
        for (Registro x:ListaAlumnos) {
            mostrarLista.append("__________________________________________________________________________________________\n");
            ver=x.mostrar();
            mostrarLista.append(ver);
        }
        JOptionPane.showMessageDialog(null, scroll.crearScroll(mostrarLista, 30, 80), "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.PLAIN_MESSAGE);
    }
 
// Para buscar alumnos mediante código o por índice de la lista
   public int consultar(ArrayList<Registro> alumnos) {

    String CodigoIdentidad;
    int posicion = -1;
    Registro x=new Registro();
     // Objeto para mostrar panel con información de la lista
    metodosScroll Panel=new metodosScroll();
    metodosBusqueda buscarAlumno;
    
    if (alumnos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "La base de datos está vacía. Por favor llene los datos antes de consultar.", "Sistema de Datos de Estudiantes", JOptionPane.WARNING_MESSAGE);
        return posicion = -1;
    }
     // Opción para buscar estudiante por indice o por codigo de identidad
    RespuestaGeneral = JOptionPane.showConfirmDialog(null, "\n¿Desea consultar al estudiante por índice?", "Consulta de Información de Estudiantes", JOptionPane.YES_NO_OPTION);
    if (RespuestaGeneral == JOptionPane.YES_OPTION) {
        do {
            posicion = -1;
            try {
                posicion=Integer.parseInt(JOptionPane.showInputDialog(null, "\nIngrese el índice del estudiante a consultar.", "Consulta de Información de Estudiantes", 0));
                x=alumnos.get(posicion);
                JOptionPane.showMessageDialog(null, Panel.crearScroll(x.mostrar(), 30, 80), "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.PLAIN_MESSAGE);
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Error. Posición fuera de rango. Intente de nuevo.", "Consulta de Información de Estudiantes", JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error. No se permiten datos alfanuméricos. Intente de nuevo.", "Consulta de Información de Estudiantes", JOptionPane.WARNING_MESSAGE);
            }
        } while (posicion <0 || posicion >= alumnos.size());
    } else {
        try {
            CodigoIdentidad=JOptionPane.showInputDialog(null, "\nIngrese código del estudiante a consultar.", "Consulta de Información de Estudiantes", 0);
            buscarAlumno=new metodosBusqueda(CodigoIdentidad, alumnos);
            posicion = buscarAlumno.getPosicion();
            if (posicion != -1) { 
                x=alumnos.get(posicion);
                JOptionPane.showMessageDialog(null, Panel.crearScroll(x.mostrar(), 30, 80), "Sistema de Datos de Estudiantes", JOptionPane.OK_OPTION);      
            } else {
                JOptionPane.showMessageDialog(null, "Este alumno NO está en la lista de registrados.");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Opción inválida. Intente de nuevo.", "Consulta de Información de Estudiantes", JOptionPane.WARNING_MESSAGE);
        }
    }

    return posicion;
}


}


