/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

import java.util.ArrayList;

/**
 *
 * @author ALVARO
 */
public class Validaciones {
    
    private int contadorErrores;
    private ArrayList<String> DatosLista=new ArrayList<>();
    
    public int getContador(){
        return this.contadorErrores;
    }
    
    public ArrayList<String> getLista() {
        return this.DatosLista;
    }
    
    public void setContador(int contador){
        this.contadorErrores = contador;
    }
    
    public void setLista(ArrayList<String> Lista) {
        this.DatosLista = Lista;
    }
    
    public Validaciones(){}
    
    protected Validaciones ValidacionString(String cadena, String tipoVariable, String Titulo) {
        if (cadena == null || cadena.isBlank()) {
            this.DatosLista.add(tipoVariable);
            this.contadorErrores++;
        }

        return this;
    }
   
    protected  Validaciones ValidacionNumeros(float Numero, String tipoVariable, String Titulo) {
        try {
        if (Numero < 0 || Numero > 5) {
            this.DatosLista.add(tipoVariable);
            this.contadorErrores++;
        }
        } catch (NumberFormatException e) {
            this.DatosLista.add(tipoVariable);
            this.contadorErrores++;
        }
        return this;
    }
}
