/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ALVARO
 */
public class Campeonato {
    
    private String nombreCampeonato;
    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;

    public Campeonato() {
    }

    public Campeonato(String nombreCampeonato, ArrayList<Equipo> equipos, ArrayList<Partido> partidos) {
        this.nombreCampeonato = nombreCampeonato;
        this.equipos = equipos;
        this.partidos = partidos;
    }

    public String getNombreCampeonato() {
        return nombreCampeonato;
    }

    public void setNombreCampeonato(String nombreCampeonato) {
        this.nombreCampeonato = nombreCampeonato;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    
    
}
