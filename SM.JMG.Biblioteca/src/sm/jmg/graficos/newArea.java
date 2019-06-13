/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;
import java.awt.Dimension;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;



/**
 * Esta clase crea un área nueva, que en este caso es un área en forma de cruz
 * @author maxigang
 */
public class newArea extends myShape{
    
    /**
     * Constructor del nuevo área
     * 
     * @param p1 valor de la coordenada X del punto donde estemos
     * @param p2 valor de la coordenada Y del punto donde estemos
     * @param shape figura seleccionada para poder dibujarla 
     * con todos los atributos
     */
    public newArea(double p1, double p2,myShape shape) {
        this.copyAttributes(shape);
        this.figura = new Line2D.Double(p1-10,p2+10,p1+10,p2-10);
        this.figuraArea = new Line2D.Double(p1-10,p2-10,p1+10,p2+10);

    }
    
}
