/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;

/**
 * Enumerado que contiene todas las formas de esta práctica
 * @author maxigang
 */
public enum Forma {

    Elipse("sm.jmg.graficos.Elipse2D"),
    Rectangulo("sm.jmg.graficos.Forma.Rectangulo2D"),
    Linea("sm.jmg.graficos.Forma.Linea2D"),
    Lapiz("sm.jmg.graficos.Forma.Punto2D"),
    Area("sm.jmg.graficos.Forma.newArea"),
    Curva("sm.jmg.graficos.Forma.Curva2D");
    


    private final String nombreForma;
    
    /**
     * 
     * @param nombreForma nombre de la forma
     */
    Forma(String nombreForma) {
        this.nombreForma = nombreForma;
    }
    
    /** 
     * 
     * @return devuelve el nombre de la forma
     */
    public String getNombreForma() {
        return nombreForma;
    }
}
