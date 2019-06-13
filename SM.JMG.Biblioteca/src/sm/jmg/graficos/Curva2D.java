/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;

import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

/**
 * Esta clase crea una curva dado un punto inicial, un punto de control
 * y un punto final
 * @author maxigang
 */
public class Curva2D extends myShape{
    /**
     * Constructor de Curva2D
     * 
     * @param shape figura seleccionada para poder dibujarla 
     * con todos los atributos
     */
    public Curva2D(myShape shape) {
        this.copyAttributes(shape);
        this.figura = new QuadCurve2D.Double();
    }
    /**
     * Asigna el punto inicial, de control y final de la curva
     * 
     * @param p1 punto inicial de la curva
     * @param p2 punto de control de la curva
     * @param p3 punto final de la curva
     */
    public void setPoints(Point2D p1, Point2D p2, Point2D p3) {
        figura = new QuadCurve2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    
}
