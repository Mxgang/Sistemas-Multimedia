/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.GeneralPath;

/**
 * Esta clase crea un punto dado un punto inicial y final
 * @author maxigang
 */
public class Punto2D extends myShape{
    
    /**
     * Constructor de Punto2D
     * 
     * @param shape figura seleccionada para poder dibujarla 
     * con todos los atributos
     */
    public Punto2D(myShape shape) {
        this.copyAttributes(shape);
        this.figura = new Line2D.Float();
    }
    
    /**
     * Asigna el punto final e inicial
     * 
     * @param p1 punto inicial
     * @param p2 punto final
     */
    public void setPoints(Point2D p1, Point2D p2) {

        figura = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
}