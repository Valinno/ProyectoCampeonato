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
public class NumPrimoenRango {
    public static void main(String[] args) {
        try {
            Integer x, y;
        boolean primo;
        Integer ContadorPrimos = 0;
        
        x = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el indice inicial para evaluar numeros primos en el rango: "));
        y = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el indice final para evaluar numeros primos en el rango: "));

        for (int i=x; i<=y; i++) {
            
            primo = true;
            
            if (i != 2) {
                if (i<=1) {
                    primo = false;
                }
                if (i==2) {
                    primo = true;
                }
                if (i%2==0) {
                    primo = false;
                }
            
                for (int j=2;j<=Math.sqrt(i);j+=1) {
                    if (i%j==0) {
                        primo = false;
                    }
                }
            } else {
                primo = true;
            }
            
            if (primo==true) {
                ContadorPrimos++;
                System.out.println("Primo encontrado #" + ContadorPrimos + ": " + i);
            }
            
        }
        
        if (ContadorPrimos>=1) {
            System.out.println(System.lineSeparator() + "Total numeros primos en el rango (" + x + ", " + y + "): " + ContadorPrimos + System.lineSeparator());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron numeros primos en el rango (" + x + ", " + y + ")");
        }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato invalido. Ingresee unicamente numeros enteros.");
        }
    }
}
