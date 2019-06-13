/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

/**
 * Esta clase crea un rectángulo dado un punto inicial y un punto final
 * 
 * @author maxigang
 */
public class Rectangulo2D extends myShape{
    
    /**
     * Constructor de Rectangulo2D
     * 
     * @param shape figura seleccionada para poder dibujarla 
     * con todos los atributos
     */
    public Rectangulo2D(myShape shape) {
        this.copyAttributes(shape);
        this.figura = new Rectangle2D.Float();
    }
    /**
     * Asigna el punto inicial y final del rectágulo
     * 
     * @param p1 punto inicial del rectángulo
     * @param p2 punto final del rectángulo
     */
    public void setPoints(Point2D p1, Point2D p2) {
        ((Rectangle2D)figura).setFrameFromDiagonal(p1, p2);
    }
    
}
