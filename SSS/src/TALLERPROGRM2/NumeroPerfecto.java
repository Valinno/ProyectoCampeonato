/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TALLERPROGRM2;

import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author ALVARO
 */
public class NumeroPerfecto {
    public static void main(String[] args) {
        Integer x;
        boolean perfecto = false;
        Integer ContadorPerfecto = 0;
        
        x = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el numero para evaluar si es primo: "));

        for (int i=1;i<=x/2;i+=1) {
            if (x%i==0) {
                ContadorPerfecto+=i;
            }
        }
        
        if (Objects.equals(ContadorPerfecto, x)) {
            perfecto = true;
        }
        
        if (perfecto==true) {
            JOptionPane.showMessageDialog(null, "El numero " + x + " es un numero perfecto. La suma de sus multiplos da " + ContadorPerfecto + ".");
        } else {
            if (ContadorPerfecto==1) {
                JOptionPane.showMessageDialog(null, "El numero " + x + " NO es un numero perfecto. La suma de sus multiplos solamente da " + ContadorPerfecto + ". Parece ser que este número es un número primo.");
            } else {
                JOptionPane.showMessageDialog(null, "El numero " + x + " NO es un numero perfecto. La suma de sus multiplos solamente da " + ContadorPerfecto + ".");
            }
        }
    }
}
