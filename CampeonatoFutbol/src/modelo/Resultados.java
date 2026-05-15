/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ALVARO
 */
public class Resultados {
    
    private Partido partidoActual;
    private int golesLocal;
    private int golesVisitante;

    public Resultados() {
    }

    public Resultados(Partido partidoActual, int golesLocal, int golesVisitante) {
        this.partidoActual = partidoActual;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Partido getPartidoActual() {
        return partidoActual;
    }

    public void setPartidoActual(Partido partidoActual) {
        this.partidoActual = partidoActual;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
    
}
