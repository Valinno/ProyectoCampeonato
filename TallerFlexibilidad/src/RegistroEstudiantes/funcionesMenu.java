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

   
   private Registro ManipulacionDatos(String Titulo) {
        
        Registro DatoAlumno=new Registro();
        boolean EstadoNotas;
        boolean EstadoStrings;
        Validaciones objetoValidar;
        
        do {
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
        
        do {
            objetoValidar = new Validaciones();
            EstadoNotas = true;
            try {
                DatoAlumno.setNotas(Float.valueOf(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", Titulo, 0))
                , Float.valueOf(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", Titulo, 0))
                , Float.valueOf(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", Titulo, 0)));
            } catch (NumberFormatException | NullPointerException e) {
                EstadoNotas = false;
                JOptionPane.showMessageDialog(null, "Error. No se permiten valores alfanuméricos o nulos. Por favor intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
            }
                
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

   public void capturar_datos(ArrayList<Registro> alumnos) {
        
        do {
            Registro x=new Registro();
            alumnos.add(ManipulacionDatos("Captura de Datos"));
            RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea seguir suministrando Informacion?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } while (RespuestaGeneral == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "Proceso finalizado.");
    }
    


   public void actualizar(ArrayList<Registro> alumnos) {

    int Posicion_Actualizar = -1;
    Registro x=new Registro();
    Posicion_Actualizar = consultar(alumnos);

    if (Posicion_Actualizar>=0 && Posicion_Actualizar<alumnos.size()) {
        
        x = alumnos.get(Posicion_Actualizar);
        RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea ACTUALIZAR los datos de este estudiante?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (RespuestaGeneral == JOptionPane.YES_OPTION) {
            
            int Respuesta;
            int Opcion_Datos;
            boolean estado;
            boolean CambiarPromedioAuto = true;
            boolean EstadoStrings;
            Validaciones objetoValidar;
            
            do {
                estado = true;
                Opcion_Datos = -1;
                Opcion_Datos=Integer.parseInt(JOptionPane.showInputDialog("¿Qué datos desea actualizar?\n1. Código\n2. Nombre\n3. Apellido\n4. Nota °1\n5. Nota °2\n6. Nota °3\n7. Promedio Académico\n8. Salir"));
                objetoValidar=new Validaciones();
                do {
                    objetoValidar.setContador(0);
                    EstadoStrings = true;
                    try {
                        switch(Opcion_Datos) {

                            case 1 -> x.setId(JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", "Actualización de Datos", 0));
                            case 2 -> x.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", "Actualización de Datos", 0));
                            case 3 -> x.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", "Actualización de Datos", 0));
                        }
                        
                        objetoValidar.ValidacionString(x.getId(), "Identificación", "Actualización de Datos");
                        objetoValidar.ValidacionString(x.getNombr(), "Nombre", "Actualización de Datos");
                        objetoValidar.ValidacionString(x.getApel(), "Apellido", "Actualización de Datos");
                            
                        if (objetoValidar.getContador() > 0) {
                            JOptionPane.showMessageDialog(null, "La siguiente casilla: " + objetoValidar.getLista() + " se encuentra vacía o nula. Por favor ingrésela nuevamente.", "Actualización de Datos", JOptionPane.WARNING_MESSAGE);
                            EstadoStrings = false;
                        }

                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Error. No se permiten datos nulos. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                        EstadoStrings = false;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                    }
                        
                } while(EstadoStrings == false);
                
                if (Opcion_Datos >3) {
                    Opcion_Datos-=3;
                    do {
                        objetoValidar.setContador(0);
                        estado = true; 
                        try {
                            switch(Opcion_Datos) {
                                case 1 -> x.setNot1(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", "Actualización de Datos", 0)));
                                case 2 -> x.setNot2(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", "Actualización de Datos", 0)));
                                case 3 -> x.setNot3(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", "Actualización de Datos", 0)));
                                case 4 -> {
                                    int RespuestaPromedio;
                                    RespuestaPromedio=JOptionPane.showConfirmDialog(null, "¿Desea calcular el promedio en automático?", "Actualización de Datos", JOptionPane.YES_NO_OPTION);
                                    if (RespuestaPromedio != JOptionPane.YES_OPTION) {
                                        x.setProm(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite el promedio académico del alumno.", "Actualización de Datos", 0)));
                                        CambiarPromedioAuto = false;
                                    } else {
                                        CambiarPromedioAuto = true;
                                    }
                                }
                                case 5 -> {
                                }
                                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                            }
                
                            objetoValidar.ValidacionNumeros(x.getNot1(), "Nota °1", "Actualización de Datos");
                            objetoValidar.ValidacionNumeros(x.getNot2(), "Nota °2", "Actualización de Datos");
                            objetoValidar.ValidacionNumeros(x.getNot3(), "Nota °3", "Actualización de Datos");
                            objetoValidar.ValidacionNumeros(x.getProm(), "Nota °3", "Actualización de Datos");
                            
                            if (objetoValidar.getContador() > 0) {
                                JOptionPane.showMessageDialog(null, "La siguiente nota: " + objetoValidar.getLista() + " están fuera de rango (0pts a 5pts). Por favor intente de nuevo.", "Actualización de Datos", JOptionPane.WARNING_MESSAGE);
                                estado = false;
                            } else {
                                if (CambiarPromedioAuto == true) {
                                    x.setProm((float) ((0.3*(x.getNot1()+x.getNot2()))+(0.4*x.getNot3())));
                                }
                            }
                            
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Error. No se permiten datos alfanuméricos para las notas. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                            estado = false;
                        } catch (NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                            estado = false;
                        }
                    } while(estado == false);
                }
                
                Respuesta=JOptionPane.showConfirmDialog(null, "¿Desea seguir actualizando datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            } while (Respuesta == JOptionPane.YES_OPTION);  
            JOptionPane.showMessageDialog(null, "Actualización de datos terminada.");
        }
    }
}

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




   public void informe(ArrayList<Registro> ListaAlumnos) {
       
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
    
   public int consultar(ArrayList<Registro> alumnos) {

    String CodigoMatricula;
    int posicion = -1;
    Registro x=new Registro();
    metodosScroll Panel=new metodosScroll();
    metodosBusqueda buscarAlumno;
    
    if (alumnos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "La base de datos está vacía. Por favor llene los datos antes de consultar.", "Sistema de Datos de Estudiantes", JOptionPane.WARNING_MESSAGE);
        return posicion = -1;
    }
    RespuestaGeneral = JOptionPane.showConfirmDialog(null, "\n¿Desea consultar al estudiante por índice?", "Consulta de Información de Estudiantes", JOptionPane.YES_NO_OPTION);
    if (RespuestaGeneral == JOptionPane.YES_OPTION) {
        do {
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
        CodigoMatricula=JOptionPane.showInputDialog(null, "\nIngrese código del estudiante a consultar.", "Consulta de Información de Estudiantes", 0);
        buscarAlumno=new metodosBusqueda(CodigoMatricula, alumnos);
        posicion = buscarAlumno.getPosicion();
        if (posicion != -1) { 
            x=alumnos.get(posicion);
            JOptionPane.showMessageDialog(null, Panel.crearScroll(x.mostrar(), 30, 80), "Sistema de Datos de Estudiantes", JOptionPane.OK_OPTION);      
        } else {
            JOptionPane.showMessageDialog(null, "Este alumno NO está en la lista de registrados.");
        }
    }

    return posicion;
}


}


