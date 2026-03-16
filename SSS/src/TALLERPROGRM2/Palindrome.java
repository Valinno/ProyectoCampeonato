/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TALLERPROGRM2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author ALVARO
 */
public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String Palabra;
        ArrayList<Character> Normal=new ArrayList<>();
        ArrayList<Character> Reversa=new ArrayList<>();
        Integer posicion = 0;
        
        System.out.println("Ingrese una palabra para analizar si es palindrome: ");
        Palabra = leer.readLine();
        
        for (int i = 0; i < Palabra.length(); i++) {
            Normal.add(Palabra.charAt(i));
            Reversa.add(Palabra.charAt(Palabra.length()-i-1));
        }
        
        if (Reversa.equals(Normal)) {
            System.out.println("La palabra " + Palabra + " es palindrome.");
        } else {
            System.out.println("La palabra " + Palabra + " NO es palindrome. Evite utilizar mayusculas para una comparacion mas precisa.");
        }
        
    }
}
