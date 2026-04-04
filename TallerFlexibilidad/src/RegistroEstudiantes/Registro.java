/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegistroEstudiantes;

/**
 *
 * @author ALVARO
 */

// //////////////////////// DECLARACIÓN DE REGISTRO DE DATOS, EJERCICIO DE ENCAPSULAMIENTO.

public class Registro {
        
        private String CODIGO = null;
        private String NOMBRE = null;
        private String APELLIDO = null;
        private float NOTA1;
        private float NOTA2;
        private float NOTA3;
        private float PROM;
        
        public Registro(){}
        
        public String getId() {
        return CODIGO;
        }
        public void setId(String code) {
        this.CODIGO=code;
        }
        
        
        public String getNombr() {
        return NOMBRE;
        }
        public void setNombr(String nombre) {
        this.NOMBRE=nombre;
        }
        
        
        public String getApel() {
        return APELLIDO;
        }
        public void setApel(String ape) {
        this.APELLIDO=ape;
        }
        
        
        public float getNot1() {
        return NOTA1;
        }
        public void setNot1(float nota1) {
        this.NOTA1=nota1;
        }
        
        
        public float getNot2() {
        return NOTA2;
        }
        public void setNot2(float nota2) {
        this.NOTA2=nota2;
        }
        
        
        public float getNot3() {
        return NOTA3;
        }
        public void setNot3(float nota3) {
        this.NOTA3=nota3;
        }
        
        public void setNotas(float nota1, float nota2, float nota3) {
        this.NOTA1=nota1;
        this.NOTA2=nota2;
        this.NOTA3=nota3;
        }
        
        public float getProm() {
        return PROM;
        }
        public void setProm(float Prom) {
        this.PROM=Prom;
        }
        
        public String mostrar() {
        
        StringBuilder mostrarDatos=new StringBuilder();
        
        mostrarDatos.append("IDENTIDAD \tNOMBRE \tAPELLIDO \tNOTA °1 \tNOTA °2 \tNOTA °3 \tPROMEDIO\n" 
                + CODIGO + "\t" + NOMBRE + "\t" + APELLIDO + "\t" + NOTA1 + "\t" + NOTA2 + "\t" + NOTA3 + "\t" + PROM + "\n\n");
        
        return mostrarDatos.toString(); 
        }
    }
