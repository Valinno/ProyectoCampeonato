/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ALVARO
 */

// EJERCICIO DE CONSTRUCTORES.
public class OperacionesMatematicas {
    
    int Numero;
    float NumeroReal;
    
    public OperacionesMatematicas(){}
    
    public OperacionesMatematicas(float n){
    
        JTextArea textoMultiplicacion=new JTextArea(30,20);
        JScrollPane scroll=new JScrollPane(textoMultiplicacion);
        StringBuilder TablaMultiplicarReales=new StringBuilder();
        String Num = null;
        float Resultado = 0;
        OperacionesMatematicas objeto=new OperacionesMatematicas();
        try {
            Num = JOptionPane.showInputDialog(null, "¿Hasta qué número n desea multiplicar?", "Multiplicación de Números", JOptionPane.INFORMATION_MESSAGE);
            if (objeto.ConfirmarEntero(Num) == true) {
                if (Integer.parseInt(Num)<0) {
                    for (int i = 1; i >= Integer.parseInt(Num); i--) {
                        Resultado = n*Float.valueOf(i);
                        TablaMultiplicarReales.append(n).append(" x ").append(i).append(" = ").append(Resultado).append("\n\n");
                    }
                } else {
                    for (int i = 1; i <= Integer.parseInt(Num); i++) {
                        Resultado = n*Float.valueOf(i);
                        TablaMultiplicarReales.append(n).append(" x ").append(i).append(" = ").append(Resultado).append("\n\n");
                    }
                }
                textoMultiplicacion.setText(TablaMultiplicarReales.toString());
                JOptionPane.showMessageDialog(null, scroll, "Tabla de Multiplicación", JOptionPane.PLAIN_MESSAGE);
            } 
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Solo se permiten valores sucesivos de n enteros. Intente de nuevo", "Tabla de Exponentes", JOptionPane.WARNING_MESSAGE);
            
        }
    
    }
    public OperacionesMatematicas(int n){
        JTextArea textoMultiplicacion=new JTextArea(30,20);
        JScrollPane scroll=new JScrollPane(textoMultiplicacion);
        StringBuilder TablaMultiplicarEnteros=new StringBuilder();
        int Num;
        try {
            Num = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Hasta qué número n desea multiplicar?", "Multiplicación de Números", JOptionPane.INFORMATION_MESSAGE));
            if (Num<0) {
                for (int i = 1; i >= Num; i--) {
                    TablaMultiplicarEnteros.append(n).append(" x ").append(i).append(" = ").append(n*i).append("\n\n");
            }
            } else {
                for (int i = 1; i <= Num; i++) {
                    TablaMultiplicarEnteros.append(n).append(" x ").append(i).append(" = ").append(n*i).append("\n\n");
                }
            }
            textoMultiplicacion.setText(TablaMultiplicarEnteros.toString());
            JOptionPane.showMessageDialog(null, scroll, "Tabla de Multiplicación", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Solo se permiten valores sucesivos de n enteros. Intente de nuevo", "Tabla de Exponentes", JOptionPane.WARNING_MESSAGE);
        }
    
    }
    public OperacionesMatematicas(int n, String Tipo){
        
        JTextArea textoExponentes=new JTextArea(30,20);
        JScrollPane scroll=new JScrollPane(textoExponentes);
        StringBuilder TablaExponentesEnteros=new StringBuilder();
        int Num;
        try {
            Num = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Hasta qué exponente n desea elevar el número " + n + "?", "Potenciación de Números "+Tipo, JOptionPane.INFORMATION_MESSAGE));
            if (Num<0) {
                for (int i = 0; i >= Num; i--) {
                    TablaExponentesEnteros.append(n).append(" ^ ").append(i).append(" = ").append(Math.pow(n, i)).append("\n\n");
                }
            } else {
                for (int i = 0; i <= Num; i++) {
                    TablaExponentesEnteros.append(n).append(" ^ ").append(i).append(" = ").append(Math.pow(n, i)).append("\n\n");
                }
            }
            textoExponentes.setText(TablaExponentesEnteros.toString());
            JOptionPane.showMessageDialog(null, scroll, "Tabla de Exponentes", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Solo se permiten valores de exponentes enteros. Intente de nuevo", "Tabla de Exponentes", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    public OperacionesMatematicas(String Tipo, float n){
        JTextArea textoExponentes=new JTextArea(30,20);
        JScrollPane scroll=new JScrollPane(textoExponentes);
        StringBuilder TablaExponentesReales=new StringBuilder();
        int Num;
        try {
            Num = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Hasta qué exponente n desea elevar el número " + n + "?", "Potenciación de Números "+Tipo, JOptionPane.INFORMATION_MESSAGE));
            if (Num<0) {
                for (int i = 0; i >= Num; i--) {
                    TablaExponentesReales.append(n).append(" ^ ").append(i).append(" = ").append(Math.pow(n, i)).append("\n\n");
                }
            } else {
                for (int i = 0; i <= Num; i++) {
                    TablaExponentesReales.append(n).append(" ^ ").append(i).append(" = ").append(Math.pow(n, i)).append("\n\n");
                }
            }
            textoExponentes.setText(TablaExponentesReales.toString());
            JOptionPane.showMessageDialog(null, scroll, "Tabla de Exponentes", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Solo se permiten valores de exponentes enteros. Intente de nuevo", "Tabla de Exponentes", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public OperacionesMatematicas(String Tipo, int n){
        
        JTextArea textoSumatoria=new JTextArea(30, 40);
        JScrollPane scroll=new JScrollPane(textoSumatoria);
        String TablaSumatoria = null;
        StringBuilder conversor=new StringBuilder();
        int Num;
        int val = 0;
        try {
            Num = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Hasta qué número n desea realizar la sumatoria x+n de " + n + "?", Tipo + "Sumatoria de Números "+Tipo, JOptionPane.INFORMATION_MESSAGE));
            if (Num<0 && n<0) {
                Num=Math.abs(Num*2);
            }
            if (Num<0) {
                for (int i = n; i >= Num; i--) {
                    val+=n+i;
                    conversor.append(n).append(" + (").append(i).append(") = ").append(val).append("\n");
                }
            } else {
                for (int i = n; i <= Num; i++) {
                    val+=n+i;
                    if (i<0) {
                        conversor.append(n).append(" + (").append(i).append(") = ").append(val).append("\n");
                    } else {
                        conversor.append(n).append(" + ").append(i).append(" = ").append(val).append("\n");
                    }

                }
            }
            TablaSumatoria = conversor.toString();
            textoSumatoria.setText(TablaSumatoria);
            JOptionPane.showMessageDialog(null, scroll, "Tabla de Sumatoria", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Solo se permiten valores de n enteros. Intente de nuevo", "Tabla de " + Tipo, JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    boolean ConfirmarEntero(String Num) {
        try {
            Integer.valueOf(Num);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número no es entero. Intente de nuevo.", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    boolean MenuSucesiones(String Num, boolean tipoDato){
        
        OperacionesMatematicas objetoFunciones;
        int OpcionesMenu;
        boolean checkEstado;
        boolean MenuActivo = true;
        boolean SalirMenu = false;
        
        do {
           do {
               checkEstado = true;
               try {
                   OpcionesMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Qué desea hacer?\n\n1. Tabla de multiplicación de " + Num + "\n2. Sumatoria de " + Num + " hasta n\n3. Lista potencias de " + Num + " hasta el exponente n" + "\n4. Salir del menú", "Menu de Operaciones Matemáticas", JOptionPane.QUESTION_MESSAGE));
                   switch(OpcionesMenu) {
                       case 1:
                           if (tipoDato == false) {
                               objetoFunciones=new OperacionesMatematicas(Float.parseFloat(Num));
                           } else {
                               objetoFunciones=new OperacionesMatematicas(Integer.parseInt(Num));
                           }
                           break;
                       case 2:
                           if (!tipoDato) {
                               JOptionPane.showMessageDialog(null, "Esta sección solo está disponible para números enteros.", "Tabla de Multiplicación", JOptionPane.PLAIN_MESSAGE);
                           } else {
                               objetoFunciones=new OperacionesMatematicas("Sumatoria", Integer.parseInt(Num));
                           }
                           break;
                       case 3:
                           if (!tipoDato) {
                               objetoFunciones=new OperacionesMatematicas("Reales", Float.parseFloat(Num));
                           } else {
                               objetoFunciones=new OperacionesMatematicas(Integer.parseInt(Num), "Enteros");
                           }
                           break;
                       case 4:
                           int Respuesta;
                           Respuesta = JOptionPane.showConfirmDialog(null, "¿Desea volver al menú principal?", "Confirmar", JOptionPane.YES_NO_OPTION);
                           if (Respuesta == JOptionPane.YES_OPTION) {
                               JOptionPane.showMessageDialog(null, "Regresando...");
                               SalirMenu = true;
                               MenuActivo = false;
                           }
                           break;
                       default:
                           JOptionPane.showMessageDialog(null, "Opción no válida. Por favor intente nuevamente.");
                           break;
                   }
               } catch (NumberFormatException | NullPointerException e) {
                   JOptionPane.showMessageDialog(null, "Valor no válido. Por favor intente nuevamente.");
                   checkEstado = false;
               }
           } while (checkEstado == false); 
        }while(MenuActivo == true); 
        return true;
    }
    
    public static void main(String[] args) {
        
        OperacionesMatematicas ob = new OperacionesMatematicas();
        
        String[] Opciones={"Real", "Entero", "Salir"};
        int Indice;
        boolean checkEstado;
        StringBuilder NumeroString;
        String conversor;
        boolean SistemaActivo = true;
        
        do {
            Indice = JOptionPane.showOptionDialog(null, "¿Con qué número desea trabajar?", "Elegir Número", 0, 0, null, Opciones, Opciones[0]);
            NumeroString=new StringBuilder();
            switch(Indice) {
                case 0:
                    do {
                        checkEstado = true;
                        try {
                            ob.NumeroReal = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese un numero.", "Numeros Reales", JOptionPane.QUESTION_MESSAGE));
                        } catch (NumberFormatException | NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Valor no válido. Por favor intente nuevamente.");
                            checkEstado = false;
                        }
                    } while (checkEstado == false);
                    NumeroString.append(ob.NumeroReal);
                    conversor = NumeroString.toString();
                    SistemaActivo = ob.MenuSucesiones(conversor, ob.ConfirmarEntero(conversor));
                    break;
                    
                case 1:
                    do {
                        checkEstado = true;
                        try {
                            ob.Numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero.", "Numeros Enteros", JOptionPane.QUESTION_MESSAGE));
                        } catch (NumberFormatException | NullPointerException e) {
                            JOptionPane.showMessageDialog(null, "Valor no válido. Por favor intente nuevamente.");
                            checkEstado = false;
                        }
                    } while (checkEstado == false);
                    NumeroString.append(ob.Numero);
                    conversor = NumeroString.toString();
                    SistemaActivo = ob.MenuSucesiones(conversor, ob.ConfirmarEntero(conversor));
                    break;
                case 2:
                    int Respuesta;
                    Respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (Respuesta == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        SistemaActivo = false;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no disponible.");
                    break;
            }
        }while(SistemaActivo == true);
    }
}
