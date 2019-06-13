/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Esta clase crea una línea dado un punto inicial y un punto final
 * @author maxigang
 */
public class Linea2D extends myShape{
    
    /**
     * Constructor de Linea2D
     * 
     * @param shape figura seleccionada para poder dibujarla 
     * con todos los atributos
     */
    public Linea2D(myShape shape) {
        this.copyAttributes(shape);
        this.figura = new Line2D.Float();
    }
    
    /**
     * Asigna el punto inicial y final de la linea 
     * 
     * @param p1 punto inicial de la linea
     * @param p2 punto final de la linea
     */
    public void setPoints(Point2D p1, Point2D p2) {
        ((Line2D)figura).setLine(p1, p2);
    }
    
}