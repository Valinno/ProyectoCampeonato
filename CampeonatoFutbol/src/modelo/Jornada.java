/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ALVARO
 */
public class Jornada {
    
    private int numeroJornada;
    private ArrayList<Partido> partidosJornada;

    public Jornada() {
    }

    public Jornada(int numeroJornada, ArrayList<Partido> partidosJornada) {
        this.numeroJornada = numeroJornada;
        this.partidosJornada = partidosJornada;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public ArrayList<Partido> getPartidosJornada() {
        return partidosJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public void setPartidosJornada(ArrayList<Partido> partidosJornada) {
        this.partidosJornada = partidosJornada;
    }
    
    
}
