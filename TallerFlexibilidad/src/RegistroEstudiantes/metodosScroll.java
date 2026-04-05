/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ALVARO
 */
public class metodosScroll {
    
    private JScrollPane scrollPagina;
    
     public JScrollPane crearScroll(String mostrar) {

        JTextArea text=new JTextArea(30, 90);
        this.scrollPagina=new JScrollPane(text);
        
        text.setText(mostrar);
        text.setEditable(false);
        
        return this.scrollPagina;
    }
}