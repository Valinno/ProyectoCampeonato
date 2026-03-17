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
public class LectorCifras {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String NumString;
        Integer Cifras = 0;
        Integer CifrasDeci = 0;
        Integer posicion = 0;
        Integer ComaPunto = 0;
        Double Numero;
        
        System.out.println("Ingrese un numero para leer sus cifras: ");
        NumString = leer.readLine();
        Numero = Double.valueOf(NumString);
        
        for (int i = 0; i < NumString.length(); i++) {
            
            if (i>=1) {
                if (".".equals(NumString.substring(i,(i+1))) || ",".equals(NumString.substring(i,(i+1)))) {
                    ComaPunto++;
                    posicion = i;
                }
            }
            if (ComaPunto<=1) {
                Cifras++;
            }
        }
        
        Cifras--;

        
        if (ComaPunto==1) {
            for (int i = posicion+1; i < NumString.length(); i++) {
                CifrasDeci++;
            }
            if ("0".equals(NumString.substring(0, 1))) {
                for (int i = 0; i <= posicion; i++) {
                    if ("0".equals(NumString.substring(i,(i+1)))) {
                        Cifras--;
                    }
                }
            }
        } else if (ComaPunto>1) {
            System.out.println("Error. No debe introducir multiples puntos decimales en su numero. No se permiten comas.");
        }
        System.out.println("Su numero contiene " + Cifras + " cifras totales, con " + CifrasDeci + " cifras decimales y " + (Cifras-CifrasDeci) + " cifras a la izquierda.  ");
        } catch (NumberFormatException e) {
            System.out.println("Error. Solo se permite una sola entrada numerica decimal o entera.");
        }
    }
}
