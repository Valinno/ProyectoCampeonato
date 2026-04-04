/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ALVARO
 */

public class funcionesMenu {

    protected int RespuestaGeneral;

    void capturar_datos(ArrayList<Registro> alumnos) {
        
        do {
            
            Registro x=new Registro();
            
            try {
                
                x.setId(JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", "Captura de datos del Estudiante", 0));
                x.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", "Captura de datos del Estudiante", 0));
                x.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", "Captura de datos del Estudiante", 0));
                x.setNotas(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", "Captura de datos del Estudiante", 0))
                    , Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", "Captura de datos del Estudiante", 0))
                    , Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", "Captura de datos del Estudiante", 0)));
            
                x.setProm(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite promedio académico del alumno.", "Captura de datos del Estudiante", 0)));
            
                alumnos.add(x);
                
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error. No se permiten datos nulos para las notas. Intente de nuevo.", "Captura de datos del Estudiante", JOptionPane.WARNING_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error. No se permiten datos alfanuméricos para las notas. Intente de nuevo.", "Captura de datos del Estudiante", JOptionPane.WARNING_MESSAGE);
            }

            RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea seguir suministrando Informacion?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } while (RespuestaGeneral == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, "Proceso finalizado.");
    }
    
    
    
    // //////////////////////////
    JScrollPane crearScroll(StringBuilder mostrar) {
        
        JTextArea text=new JTextArea(30, 90);
        JScrollPane scroll=new JScrollPane(text);
        
        text.setText(mostrar.toString());
        text.setEditable(false);
        
        return scroll;
    }

    
    JScrollPane crearScroll(String mostrar) {
        
        JTextArea text=new JTextArea(30, 90);
        JScrollPane scroll=new JScrollPane(text);
        
        text.setText(mostrar);
        text.setEditable(false);
        
        return scroll;
    }
    // //////////////////////////
    
    
    
    
    
    void informe(ArrayList<Registro> alumnos) {
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
    
    
    
    
    // //////////////////////////    
    
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



int consultar(ArrayList<Registro> alumnos) {

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
            } while (posicion <0 & posicion >= alumnos.size());
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

void actualizar(ArrayList<Registro> alumnos) {

    int Posicion_Actualizar = -1;
    Registro x=new Registro();
    Posicion_Actualizar = consultar(alumnos);
    boolean estado;

    if (Posicion_Actualizar>=0 && Posicion_Actualizar<alumnos.size()) {
        
        x = alumnos.get(Posicion_Actualizar);
        RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea ACTUALIZAR los datos de este estudiante?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (RespuestaGeneral == JOptionPane.YES_OPTION) {
            
            int Respuesta;
            int Respuesta_Calculo;
            int Opcion_Datos;
            
            do {
                estado = true;
                Opcion_Datos = -1;
                Opcion_Datos=Integer.parseInt(JOptionPane.showInputDialog("¿Qué datos desea actualizar?\n1. Código\n2. Nombre\n3. Apellido\n4. Nota °1\n5. Nota °2\n6. Nota °3\n7. Promedio Académico"));
                try {
                    switch(Opcion_Datos) {

                    case 1 -> x.setId(JOptionPane.showInputDialog(null, "\nDigite C.C o D.I del alumno.", "Captura de datos del Estudiante", 0));
                    
                    case 2 -> x.setNombr(JOptionPane.showInputDialog(null, "\nDigite nombre del alumno.", "Captura de datos del Estudiante", 0));
                    
                    case 3 -> x.setApel(JOptionPane.showInputDialog(null, "\nDigite apellido del alumno.", "Captura de datos del Estudiante", 0));
                    
                    case 4 -> x.setNot1(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °1 del alumno.", "Captura de datos del Estudiante", 0)));
                    
                    case 5 -> x.setNot2(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °2 del alumno.", "Captura de datos del Estudiante", 0)));
                    
                    case 6 -> x.setNot3(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite nota °3 del alumno.", "Captura de datos del Estudiante", 0)));
                    
                    case 7 -> {
                        Respuesta_Calculo=JOptionPane.showConfirmDialog(null, "¿Desea calcular promedio académico por sistema o ingresar el dato?", "Confirmar", JOptionPane.YES_NO_OPTION);
                        
                        if (Respuesta_Calculo == JOptionPane.YES_OPTION) {
                            x.setProm((float) ((0.3*(x.getNot1()+x.getNot2()))+(0.4*x.getNot3())));
                        } else {
                            x.setProm(Float.parseFloat(JOptionPane.showInputDialog(null, "\nDigite Codigo del alumno.", "Captura de datos del Estudiante", 0)));
                        }
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
                } catch (NumberFormatException e) {
                    estado = false;
                    JOptionPane.showMessageDialog(null, "Error. No se permiten valores alfanuméricos para las notas. Intente de nuevo.", "Error de entrada", JOptionPane.WARNING_MESSAGE);
                }
                Respuesta=JOptionPane.showConfirmDialog(null, "¿Desea seguir actualizando datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
            } while (Respuesta == JOptionPane.YES_OPTION);
            
            if (estado != false) {
                JOptionPane.showMessageDialog(null, "Estudiante actualizado con exito.");
            }
            
        }
    }
}

void borrar(ArrayList<Registro> alumnos) {
    int pos = -1;

    pos = consultar(alumnos);

    if (pos>=0 && pos<alumnos.size()) {
        
        RespuestaGeneral=JOptionPane.showConfirmDialog(null, "¿Desea ELIMINAR este estudiante de la base de datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (RespuestaGeneral == JOptionPane.YES_OPTION) {
            
            alumnos.remove(pos);
            
            JOptionPane.showMessageDialog(null, "Estudiante eliminado del  con exito.");
        }
    }
}
}
