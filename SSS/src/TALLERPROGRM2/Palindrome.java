/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TALLERPROGRM2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALVARO
 */
public class Palindrome {
    public static void main(String[] args) {
        String Palabra;
        ArrayList<Character> Normal=new ArrayList<>();
        ArrayList<Character> Reversa=new ArrayList<>();
        Integer posicion = 0;
        
        
        Palabra = JOptionPane.showInputDialog("Ingrese una palabra para analizar si es palindrome: ");
        
        for (int i = 0; i < Palabra.length(); i++) {
            Normal.add(Palabra.charAt(i));
            Reversa.add(Palabra.charAt(Palabra.length()-i-1));
        }
        
        if (Reversa.equals(Normal)) {
            JOptionPane.showMessageDialog(null, "La palabra " + Palabra + " es palindrome.");
        } else {
            JOptionPane.showMessageDialog(null, "La palabra " + Palabra + " NO es palindrome. Evite utilizar mayusculas para una comparacion mas precisa.");
        }
        
    }
}
