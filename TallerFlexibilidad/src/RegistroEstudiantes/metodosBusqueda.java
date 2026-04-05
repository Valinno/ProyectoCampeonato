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
    private boolean Duplicados = false;
    
    public int getPosicion() {
        return this.posicionIdentidad;
    }
    public boolean getDuplicado() {
        return this.Duplicados;
    }
    
    private int busqueda(String id, ArrayList<Registro> alumnos) {
        this.posicionIdentidad = -1;
        for (Registro x:alumnos) {
            if(id.equals(x.getId())) {
                this.posicionIdentidad = alumnos.indexOf(x);
                JOptionPane.showMessageDialog(null, "Estudiante encontrado en la posicion " + this.posicionIdentidad);
                return this.posicionIdentidad;
            }
        }
        return this.posicionIdentidad;
    }
    
    private boolean busqueda(String id, ArrayList<Registro> alumnos, int contadorSimilitudes) {
        for (Registro x:alumnos) {
            if(id.equals(x.getId())) {
                contadorSimilitudes++;
            }
        }
        if (contadorSimilitudes >= 1) {
            JOptionPane.showMessageDialog(null, "Advertencia. Se han encontrado que el código ingresado ya se encuentra en el registro. Por favor revise el informe y corriga los datos.", "Verificación de Datos", JOptionPane.WARNING_MESSAGE);
            this.Duplicados = true;
        }
        return this.Duplicados;
    }
    
    private String busqueda(int i, ArrayList<Registro> alumnos) {
        Registro x=new Registro();
        x = alumnos.get(i);
        return x.mostrar();
    }
    
    protected metodosBusqueda(){}
    protected metodosBusqueda(String CodigoIdentidad, ArrayList<Registro> objeto){
        busqueda(CodigoIdentidad, objeto);
    }
    protected metodosBusqueda(int Indice, ArrayList<Registro> objeto){
        busqueda(Indice, objeto);
    }
    protected metodosBusqueda(String CodigoIdentidad, ArrayList<Registro> objeto, int Contador){
        busqueda(CodigoIdentidad, objeto, Contador);
    }
}
