/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *  Esta clase crea la forma elipse dado un punto inicial y final
 * @author maxigang
 */
public class Elipse2D extends myShape{
    
    /**
     * Constructor de Elipse2D
     * 
     * @param shape figura seleccionada para poder dibujarla 
     * con todos los atributos
     */
    public Elipse2D(myShape shape) {
        this.copyAttributes(shape);
        this.figura = new Ellipse2D.Double();
    }
    /**
     * Asigna los puntos inicial y final de la elipse
     * 
     * @param p1 punto inicial de la elipse
     * @param p2 punto final de la elipse
     */
    public void setPoints(Point2D p1, Point2D p2) {
        ((Ellipse2D)figura).setFrameFromDiagonal(p1, p2);
    }
    
}
