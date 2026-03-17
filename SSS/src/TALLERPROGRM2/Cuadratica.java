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
public class Cuadratica {
    
    
    public static void main(String[] args) {
        
        Double a, b, c;
        
        Double x1, x2;
        
        Cuadratica ob=new Cuadratica();
        Double Raiz;
        
        a=Double.valueOf(JOptionPane.showInputDialog("SISTEMA FORMULA CUADRATICA" + "\nIngrese el primer termino de su forma cuadratica: "));
        b=Double.valueOf(JOptionPane.showInputDialog("SISTEMA FORMULA CUADRATICA" + "\nIngrese el segundo termino de su forma cuadratica: "));
        c=Double.valueOf(JOptionPane.showInputDialog("SISTEMA FORMULA CUADRATICA" + "\nIngrese el tercer termino de su forma cuadratica: "));
        
        if (a!=0) {
            
            Raiz = Math.pow(b, 2.0)-(4*a*c);
            JOptionPane.showMessageDialog(null, "Raiz discriminante: " + Raiz);
        
            if (Raiz>=0) {
                x1 = (-b+Math.sqrt(Raiz))/2*a;
                x2 = (-b-Math.sqrt(Raiz))/2*a;
                JOptionPane.showMessageDialog(null, "Los valores de x son: " + "\n x_1= " + x1 + "\n x_2=" + x2);
            } else {
                JOptionPane.showMessageDialog(null, "La raiz para esta ecuacion es negativa. No tiene soluciones reales.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El termino 'a' debe ser mayor que cero. Solo se permiten ecuaciones de segundo grado.");
        }
    }
}
