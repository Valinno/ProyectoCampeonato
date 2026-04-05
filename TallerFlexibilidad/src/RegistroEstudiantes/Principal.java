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
public class Principal { 

public static void main(String[] args) {
    
    ArrayList<Registro> alumnos=new ArrayList<>();
    funcionesMenu displ=new funcionesMenu();
    int Respuesta;
    boolean activo = true;
    
    do {
        int op = 0;
        do {
            
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué desea hacer?\n\n1. \tRegistrar Datos \n"
                + "\t2. Listado del Registro \n"
                + "\t3. Consultar Datos \n"
                + "\t4. Actualizar Datos \n"
                + "\t5. Borrar Datos \n"
                + "\t6. Salir del Sistema \n" + " ", "MENU DE GESTIÓN DE DATOS ACADÉMICOS", JOptionPane.DEFAULT_OPTION)); 
            } catch (NumberFormatException e) {
            }
            
        } while (op<=0 || op>6);

        switch(op) {
        case 1 -> displ.capturar_datos(alumnos);
        case 2 -> displ.informe(alumnos);
        case 3 -> displ.consultar(alumnos);
        case 4 -> {try {
                displ.actualizar(alumnos);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción no válida. Será regresado al menú.", "Actualización de Datos", JOptionPane.WARNING_MESSAGE);
            }
}
        case 5 -> displ.borrar(alumnos);
        case 6 -> { 
            Respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (Respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Saliendo...");
                activo = false;
            }
            }
        default -> JOptionPane.showMessageDialog(null, "Entrada no valida.");
    }
    } while (activo==true);
}
}


