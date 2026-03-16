/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TALLERPROGRM2;

import javax.swing.JOptionPane;

/**
 *
 * @author ALVARO
 */
public class CobroAutobus {
    public static void main(String[] args) {
        
        Integer estudiantes;
        Double renta;
        Double cobro;
        
        estudiantes=Integer.valueOf(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes para el transporte en autobus: "));
        if (estudiantes < 30) {
            renta = 4000.0;
            JOptionPane.showMessageDialog(null, "Para " + estudiantes + " estudiantes, la renta del autobus sera de " + renta + " euros. \n No se le cobrará a ningun estudiante.");
        } else if (estudiantes >=30 & estudiantes <=49) {
            cobro = 95.0;
            renta = cobro*estudiantes;
            JOptionPane.showMessageDialog(null, "Para " + estudiantes + " estudiantes, la renta del autobus sera de " + renta + " euros. \n Se le cobrarán " + cobro + " euros a cada estudiante.");
        } else if (estudiantes >=50 & estudiantes <=99) {
            cobro = 70.0;
            renta = cobro*estudiantes;
            JOptionPane.showMessageDialog(null, "Para " + estudiantes + " estudiantes, la renta del autobus sera de " + renta + " euros. \n Se le cobrarán " + cobro + " euros a cada estudiante.");
        } else if (estudiantes >= 100) {
            cobro = 65.0;
            renta = cobro*estudiantes;
            JOptionPane.showMessageDialog(null, "Para " + estudiantes + " estudiantes, la renta del autobus sera de " + renta + " euros. \n Se le cobrarán " + cobro + " euros a cada estudiante.");
        }
    }
}
