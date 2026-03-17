/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TALLERPROGRM2;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author ALVARO
 */
public class MenuSecuencias {
    
    double SumaFibonacci(double ant, double post) {
        double fibo;
        
        fibo = ant+post;
        ant = post;
        post = fibo;
        
        return fibo;
    }
    
    void Fibonacci() {
        
        int n;
        ArrayList<Double> Fibo=new ArrayList<>();
        ArrayList<String> Mostrar=new ArrayList<>();
        
        n=Integer.parseInt(JOptionPane.showInputDialog("///////// SUCESIÓN DE FIBONACCI /////////////" 
                    + "\n¿Cuántos términos desea ver de la sucesión?"));
        
        Fibo.add(0.0);
        Fibo.add(1.0);
        
        for (int i = 1; i <= n; i++) {
            
            Fibo.add(SumaFibonacci(Fibo.get(i-1), Fibo.get(i)));
        }
        for (int i = 0; i < Fibo.size(); i++) {
            Mostrar.add(Double.toString(Fibo.get(i)));
        }
        
        String[] ListaTerminos = Mostrar.toArray(String[]::new);
        JList<String> lista = new JList<>(ListaTerminos);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        
        JOptionPane.showMessageDialog(null, scrollPane, "///////// SUCESIÓN DE FIBONACCI /////////////", JOptionPane.INFORMATION_MESSAGE);
    }
    
    void Exponencial() {
        int n;
        Double a;
        ArrayList<Double> Expo=new ArrayList<>();
        ArrayList<String> MostrarExpo=new ArrayList<>();
        
        a=Double.valueOf(JOptionPane.showInputDialog("///////// SUCESIÓN EXPONENCIAL /////////////" 
                    + "\n¿Con qué termino desea realizar la sucesión?"));
        n=Integer.parseInt(JOptionPane.showInputDialog("///////// SUCESIÓN EXPONENCIAL /////////////" 
                    + "\n¿Cuántos términos desea ver de la sucesión?"));

        for (int i = 0; i <= n; i++) {
            
            Expo.add(Math.pow(a, i));
        }
        for (int i = 0; i < Expo.size(); i++) {
            MostrarExpo.add(Double.toString(Expo.get(i)));
        }
        
        String[] ListaTerminos = MostrarExpo.toArray(String[]::new);
        JList<String> lista = new JList<>(ListaTerminos);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        
        JOptionPane.showMessageDialog(null, scrollPane, "///////// SUCESIÓN EXPONENCIAL /////////////", JOptionPane.INFORMATION_MESSAGE);
    }
    
    void menu() {
        
        boolean activo = true;
        int op;
        
        do {
            op=Integer.parseInt(JOptionPane.showInputDialog("///////// MENU DE OPCIONES SECUENCIAS MATEMÁTICAS /////////////" 
                    + "\n1. Sucesión de Fibonacci" 
                    + "\n2. Sucesión exponencial a^n" 
                    + "\n3. Salir"));
            
            switch(op) {
                case 1:
                    Fibonacci();
                    break;
                case 2:
                    Exponencial();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    activo = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrada invalida.");
                    break;
            }
        } while (activo==true);
        
    }
    
    public static void main(String[] args) {
        
        MenuSecuencias ob=new MenuSecuencias();
        ob.menu();
    }
}
