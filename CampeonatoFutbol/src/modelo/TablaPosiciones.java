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
public class TablaPosiciones {
    
    private ArrayList<Equipo> equiposTabla;
    
    private Campeonato campeonatoInfo;

    public TablaPosiciones() {
    }

    public TablaPosiciones(ArrayList<Equipo> equiposTabla, Campeonato campeonatoInfo) {
        this.equiposTabla = equiposTabla;
        this.campeonatoInfo = campeonatoInfo;
    }

    public ArrayList<Equipo> getEquiposTabla() {
        return equiposTabla;
    }
    
}
