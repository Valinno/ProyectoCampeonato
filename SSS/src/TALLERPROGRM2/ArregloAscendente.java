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
public class ArregloAscendente {
    public static void main(String[] args) {
        Integer[] Codigos=new Integer[20];
        Integer auxiliar;
        
        for (int i = 0; i < Codigos.length; i++) {
            Codigos[i]=Integer.valueOf(JOptionPane.showInputDialog("Introduzca el codigo " + i + ": "));
        }
        
        for (int i = 0; i < Codigos.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((Codigos[i] <= Codigos[j]) && Codigos[j] != 0) {
                    auxiliar = Codigos[i];
                    Codigos[i] = Codigos[j];
                    Codigos[j] = auxiliar;
                }
            }
        }
        
        System.out.println("Lista de codigos: \n");
        for (int i=0; i<Codigos.length; i++) {
            System.out.println("" + Codigos[i]);
        }
        
    }
}
