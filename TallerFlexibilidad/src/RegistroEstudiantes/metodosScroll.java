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
    
    public JScrollPane crearScroll(String mostrarDatos, int alto, int ancho) {

        JTextArea text=new JTextArea(alto, ancho);
        this.scrollPagina=new JScrollPane(text);
        
        text.setText(mostrarDatos);
        text.setEditable(false);
        
        return this.scrollPagina;
    }
    
    public JScrollPane crearScroll(StringBuilder mostrarDatos, int alto, int ancho) {
        
        JTextArea text=new JTextArea(alto, ancho);
        this.scrollPagina=new JScrollPane(text);
        
        text.setText(mostrarDatos.toString());
        text.setEditable(false);
        
        return this.scrollPagina;
    }
}