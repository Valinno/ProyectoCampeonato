/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ALVARO
 */

public class funcionesMenu {

    private int RespuestaGeneral;
    
    
    // //////////// SOBRECARGADAS //////////////
    
    private JScrollPane crearScroll(StringBuilder mostrar) {
        
        JTextArea text=new JTextArea(30, 90);
        JScrollPane scroll=new JScrollPane(text);
        
        text.setText(mostrar.toString());
        text.setEditable(false);
        
        return scroll;
    }

    private JScrollPane crearScroll(String mostrar) {
        
        JTextArea text=new JTextArea(30, 90);
        JScrollPane scroll=new JScrollPane(text);
        
        text.setText(mostrar);
        text.setEditable(false);
        
        return scroll;
    }
 
    
int busqueda(String a, ArrayList<Registro> alumnos) {

        int guardar = -1;
        
        for (Registro x:alumnos) {
            
            if(a.equals(x.getId())) {
                
                guardar=alumnos.indexOf(x);
                JOptionPane.showMessageDialog(null, "Estudiante encontrado en la posicion " + guardar);
                
            }
            
        }
        return guardar;
}

String busqueda(int i, ArrayList<Registro> alumnos) {
    
    Registro x=new Registro();
    x = alumnos.get(i);

    return x.mostrar();
}

    // //////////////////////////
    

    
private Registro ManipulacionDatos(String Titulo) {
        
        Registro DatoAlumno=new Registro();
        ArrayList<String> Mensaje;
        int ContadorCasos;
        boolean EstadoNotas;
        boolean EstadoStrings;
        
        do {
            EstadoStrings = true;
            try {
                Mensaje=new ArrayList<>();
                        
                DatoAlumno.setId(JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", Titulo, 0));
                DatoAlumno.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", Titulo, 0));
                DatoAlumno.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", Titulo, 0));
                        
                if(DatoAlumno.getId() == null || DatoAlumno.getId().isBlank()) {
                    Mensaje.add("Identificación");
                    EstadoStrings = false;
                }
                if(DatoAlumno.getNombr() == null || DatoAlumno.getNombr().isBlank()) {
                    Mensaje.add("Nombre");
                    EstadoStrings = false;
                } 
                if(DatoAlumno.getApel() == null || DatoAlumno.getApel().isBlank()) {
                    Mensaje.add("Apellido");
                    EstadoStrings = false;
                }
                if (EstadoStrings == false) {
                    JOptionPane.showMessageDialog(null, "Las siguientes casillas se encuentran vacías: " + Mensaje + ". Por favor intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error. No se permiten datos nulos. Intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
                EstadoStrings = false;
            }
                        
        } while(EstadoStrings == false);
        
        do {
            EstadoNotas = true;
            try {
                ContadorCasos = 0;
                Mensaje = new ArrayList<>();
 
                DatoAlumno.setNotas(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", Titulo, 0))
                    , Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", Titulo, 0))
                    , Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", Titulo, 0)));

                DatoAlumno.setProm((float) ((0.3*(DatoAlumno.getNot1()+DatoAlumno.getNot2()))+(0.4*DatoAlumno.getNot3())));
                
                if(DatoAlumno.getNot1() < 0) {
                    Mensaje.add("Nota °1");
                    EstadoNotas = false;
                }
                if(DatoAlumno.getNot2() < 0) {
                    Mensaje.add("Nota °2");
                    EstadoNotas = false;
                } 
                if(DatoAlumno.getNot3() < 0) {
                    Mensaje.add("Nota °3");
                    EstadoNotas = false;
                }
                if (EstadoNotas == false) {
                    JOptionPane.showMessageDialog(null, "Las siguientes casillas tienen valores negativos: " + Mensaje + ". Por favor intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException | NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error de entrada para la nota. Intente de nuevo.", Titulo, JOptionPane.WARNING_MESSAGE);
                EstadoNotas = false;
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
    

boolean ValidacionStrings(String cadena) {
    try {
        if (cadena.isBlank()) {
            JOptionPane.showMessageDialog(null, "No debe dejar esta casilla en blanco. Por favor intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "No debe dejar esta casilla en vacía. Por favor intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
        return false;
    }
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
            int Respuesta_Calculo;
            int Opcion_Datos;
            boolean estado;
            boolean CambiarPromedioAuto;
            boolean EstadoStrings;
            String datoTemporal;
            
            do {
                estado = true;
                Opcion_Datos = -1;
                Opcion_Datos=Integer.parseInt(JOptionPane.showInputDialog("¿Qué datos desea actualizar?\n1. Código\n2. Nombre\n3. Apellido\n4. Nota °1\n5. Nota °2\n6. Nota °3\n7. Promedio Académico\n8. Salir"));
                
                do {
                    EstadoStrings = true;
                    try {
                        switch(Opcion_Datos) {

                            case 1:
                                datoTemporal = x.getId();
                                x.setId(JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", "Captura de datos del Estudiante", 0));
                                estado = ValidacionStrings(x.getId());
                                if (estado == false) {
                                    x.setId(datoTemporal);
                                }
                                break;
                    
                            case 2: 
                                datoTemporal = x.getNombr();
                               x.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", "Captura de datos del Estudiante", 0));
                               estado = ValidacionStrings(x.getNombr());
                               if (estado == false) {
                                    x.setNombr(datoTemporal);
                                }
                               break;
                            case 3: 
                                datoTemporal = x.getApel();
                                x.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", "Captura de datos del Estudiante", 0));
                                estado = ValidacionStrings(x.getApel());
                                if (estado == false) {
                                    x.setApel(datoTemporal);
                                }
                        break;
                        }

                    } catch (NullPointerException e) {
                        JOptionPane.showMessageDialog(null, "Error. No se permiten datos nulos. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                        EstadoStrings = false;
                    }
                        
                } while(EstadoStrings == false);
                
                if (Opcion_Datos >3) {
                    Opcion_Datos-=3;
                    do {
                        estado = true; 
                        CambiarPromedioAuto = true;
                        try {
                            switch(Opcion_Datos) {
                                case 1: 
                                    x.setNot1(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", "Captura de datos del Estudiante", 0)));
                                    break;   
                                case 2: 
                                    x.setNot2(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", "Captura de datos del Estudiante", 0)));
                                    break;
                                case 3: 
                                    x.setNot3(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", "Captura de datos del Estudiante", 0)));
                                    break;
                                case 4:
                                    x.setProm(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite el promedio académico del alumno.", "Captura de datos del Estudiante", 0)));
                                    CambiarPromedioAuto = false;
                                    break;
                                case 5:
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                                    break;
                            }
                            
                            if (CambiarPromedioAuto == true) {
                                x.setProm((float) ((0.3*(x.getNot1()+x.getNot2()))+(0.4*x.getNot3())));
                            }
                            
                            if (x.getId() == null || x.getId().isBlank()) {
                                JOptionPane.showMessageDialog(null, "No debe dejar en blanco esta casilla. Por favor intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                                estado = false;
                            }
                            if (x.getNombr() == null || x.getNombr().isBlank()) {
                                JOptionPane.showMessageDialog(null, "No debe usar valores negativos para las notas. Por favor intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                                estado = false;
                            }
                            if (x.getApel() == null || x.getApel().isBlank()) {
                                JOptionPane.showMessageDialog(null, "No debe usar valores negativos para las notas. Por favor intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                                estado = false;
                            }
                
                            if(x.getNot1() < 0 || x.getNot2() < 0 || x.getNot3() < 0) {
                                JOptionPane.showMessageDialog(null, "No debe usar valores negativos para las notas. Por favor intente de nuevo.", "Acutalización de Datos", JOptionPane.WARNING_MESSAGE);
                                estado = false;
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




public void informe(ArrayList<Registro> alumnos) {
        if (!alumnos.isEmpty()) {
            StringBuilder mostrar=new StringBuilder();
        String ver = null;
        for (Registro x:alumnos) {
            mostrar.append("__________________________________________________________________________________________\n");
            ver=x.mostrar();
            mostrar.append(ver);
        }
        JOptionPane.showMessageDialog(null, crearScroll(mostrar), "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La base de datos está vacía. Por favor llene los datos antes de consultar.", "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.WARNING_MESSAGE);
        }
    }
    
public int consultar(ArrayList<Registro> alumnos) {

    String CodigoMatricula;
    int posicion = -1;
    Registro x=new Registro();
    
    if (!alumnos.isEmpty()) {
        RespuestaGeneral = JOptionPane.showConfirmDialog(null, " **** CONSULTA INFORMACION DE ESTUDIANTES ****" + "\n¿Desea consultar al estudiante por índice?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (RespuestaGeneral == JOptionPane.YES_OPTION) {
            do {
                try {
                    posicion=Integer.parseInt(JOptionPane.showInputDialog(null, "\nIngrese el índice del estudiante a consultar.", "CONSULTA INFORMACION DE ESTUDIANTES", 0));
                    x=alumnos.get(posicion);
                    JOptionPane.showMessageDialog(null, crearScroll(x.mostrar()), "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.PLAIN_MESSAGE);
                } catch (IndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Error. Posición fuera de rango. Intente de nuevo.", "CONSULTA INFORMACION DE ESTUDIANTES", JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error. No se permiten datos alfanuméricos. Intente de nuevo.", "CONSULTA INFORMACION DE ESTUDIANTES", JOptionPane.WARNING_MESSAGE);
                }
            } while (posicion <0 || posicion >= alumnos.size());
        } else {
            CodigoMatricula=JOptionPane.showInputDialog(null, "\nIngrese código del estudiante a consultar.", "CONSULTA INFORMACION DE ESTUDIANTES", 0);
            posicion = busqueda(CodigoMatricula, alumnos);
            if (posicion != -1) { 
                x=alumnos.get(posicion);
                JOptionPane.showMessageDialog(null, crearScroll(x.mostrar()), "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.OK_OPTION);      
            } else {
                JOptionPane.showMessageDialog(null, "NO esta matriculado ese alumno...");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "La base de datos está vacía. Por favor llene los datos antes de consultar.", "SISTEMA DATOS DE ESTUDIANTES", JOptionPane.WARNING_MESSAGE);
    } 

    return posicion;
}


}


