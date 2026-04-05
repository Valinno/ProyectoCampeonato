/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALVARO
 */
public class metodosBusqueda {
    
    private int posicionIdentidad;
    
    public int getPosicion() {
        return this.posicionIdentidad;
    }
    
    private int busqueda(String id, ArrayList<Registro> alumnos) {
        this.posicionIdentidad = -1;
        for (Registro x:alumnos) {
            if(id.equals(x.getId())) {
                this.posicionIdentidad = alumnos.indexOf(x);
                JOptionPane.showMessageDialog(null, "Estudiante encontrado en la posicion " + this.posicionIdentidad);
            }
        }
        return this.posicionIdentidad;
    }
    private String busqueda(int i, ArrayList<Registro> alumnos) {
        Registro x=new Registro();
        x = alumnos.get(i);
        return x.mostrar();
    }
    
    protected metodosBusqueda(String CodigoIdentidad, ArrayList<Registro> objeto){
        busqueda(CodigoIdentidad, objeto);
    }
    protected metodosBusqueda(int Indice, ArrayList<Registro> objeto){
        busqueda(Indice, objeto);
    }
}
