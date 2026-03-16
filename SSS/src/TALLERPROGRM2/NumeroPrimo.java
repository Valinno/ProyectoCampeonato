/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TALLERPROGRM2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author ALVARO
 */
public class NumeroPrimo {
    
    public static void main(String[] args) throws IOException {

        Integer x;
        boolean primo = true;
        
        x = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el numero para evaluar si es primo: "));

        if (x<=1) {
            primo = false;
        }
        if (x==2) {
            primo = true;
        }
        if (x%2==0) {
            primo = false;
        }
        for (int i=2;i<=Math.sqrt(x);i+=1) {
            if (x%i==0) {
                primo = false;
            }
        }
        
        if (primo==true) {
            JOptionPane.showMessageDialog(null, "El numero " + x + " es primo.");
        } else {
            JOptionPane.showMessageDialog(null, "El numero " + x + " NO es primo.");
        }
        
    }
}