/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.iu;
import sm.jmg.graficos.*;
import java.awt.BasicStroke;
import java.awt.Composite;
import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.Paint;
import java.awt.GradientPaint;
import java.awt.Stroke;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.lang.Object;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.RectangularShape;
import java.awt.Dimension;

/**
 * Clase Lienzo donde se asignan los valores seleccionados del escritorio
 * además de gestionar los eventos del ratón
 * 
 * @author maxigang
 */


public class Lienzo extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo
     */
    
    // Variables necesarias para las figuras
    private Forma forma;
    Point punto;
    private myShape myshape = new myShape();
    boolean curvaIniciada = false;

    Linea2D l;
    Punto2D lapiz;
    Point2D p, p1, p2;
    Point2D pI, pC, pF;
    newArea area;
    Elipse2D elipse;
    Rectangulo2D rectangulo;
    Curva2D curva, curva2;
    
    List<myShape> vShape;
    
    /**
     * Constructor por defecto, inicializa los componentes
     */
    public Lienzo() {
        this.vShape = new ArrayList();
        this.forma = Forma.Lapiz;
        initComponents();
    }
    /**
     * Asigna el valor del punto inicial de la figura
     * @param p1 punto inicial de la figura
     */
    public void setP1(Point2D p1){
        myshape.setP1(p1);
    }
    
    /**
     * Asigna el valor del punto final de la figura
     * @param p2 punto final de la figura
     */
    public void setP2(Point2D p2){
        myshape.setP2(p2);
    }
    /**
     * Devuelve el color predeterminado
     * 
     * @return puede ser azul, rojo, negro, amarillo o verde
     */
    public Color getColor(){
        
        return myshape.getColor();
    }
    
    /**
     * Asigna el color predeterminado
     * 
     * @param color puede ser azul, rojo, negro, amarillo o verde
     */
    public void setColor(Color color){
        myshape.setColor(color);    
    }
    
    /**
     * Devuelve el color del relleno
     * 
     * @return puede ser azul, rojo, negro, amarillo o verde
     */
    public Color getColorRelleno(){
        
        return myshape.getColorRelleno();
    }
    
    /**
     * Asigna el color del relleno
     * 
     * @param color puede ser azul, rojo, negro, amarillo o verde
     */
    public void setColorRelleno(Color color){
        myshape.setColorRelleno(color);    
    }
    
    /**
     * Devuelve el color del trazo
     * 
     * @return puede ser azul, rojo, negro, amarillo o verde
     */
    public Color getColorTrazo(){
        
        return myshape.getColorTrazo();
    }
    
    /**
     * Asigna el color de frente del degradado
     * @param color puede ser negro, azul, amarillo, verde o rojo
     * 
     */
    public void setColorFrente(Color color){
        myshape.setColorFrente(color);
    }
    
    /**
     * Asigna el color de fondo del degradado
     * @param color puede ser negro, azul, amarillo, verde o rojo
     * 
     */
    public void setColorFondo(Color color){
        myshape.setColorFondo(color);
    }
    
    /**
     * Asigna el color del trazo
     * 
     * @param color puede ser azul, rojo, negro, amarillo o verde
     */
    public void setColorTrazo(Color color){
        myshape.setColorTrazo(color);    
    }
    
    /**
     * Devuelve el valor de colorPlano para saber si se está
     * seleccionando un color predeterminado o no.
     * 
     * @return true o false
     */
    public boolean getEsPlano(){
        
        return myshape.getEsPlano();
    }
    
    /**
     * Asigna el colorPlano para saber si se está seleccionando
     * un color predeterminado o no
     * @param colorPlano true o false
     */
    public void setEsPlano(boolean colorPlano){
        myshape.setEsPlano(colorPlano);    
    }
    
    /**
     * Asigna el tipo de forma
     * 
     * @param forma puede ser lápiz, elipse, rectángulo, línea o el nuevo área
     */
    public void setForma(Forma forma) {
        this.forma = forma;
    }
    
    /**
     * Devuelve el tipo de forma
     * 
     * @return puede ser lápiz, elipse, rectángulo, línea o el nuevo área
     */
    public Forma getForma() {
        return forma;
    }
    
    /**
     * Devuelve el tipo de relleno seleccionado
     * 
     * @return puede ser sin relleno, con relleno o degradado
     */
    public String getRelleno() {
        return myshape.getRelleno();
    }

    /**
     * Asigna el tipo de relleno
     * 
     * @param relleno puede ser sin relleno, con relleno o degradado
     */
    public void setRelleno(String relleno) {
        myshape.setRelleno(relleno);
    }
    
    /**
     * Devuelve si el botón alisado está pulsado o no
     * 
     * @return true o false
     */
    public boolean getAlisado(){
        return myshape.getAlisado();
    }
    
    /**
     * Asigna para que la figura se alise o no
     * @param alisado true o false
     */
    public void setAlisado(boolean alisado){
        myshape.setAlisado(alisado);
    }
    
    /**
     * Devuelve si la figura tiene un trazo discontinuo o no
     * 
     * @return true o false
     */
    public boolean getDiscontinuidad(){
        return myshape.getDiscontinuidad();
    }
    
    /**
     * Asigna para que la figura esté discontinua o no
     * 
     * @param discontinuidad true o false
     */
    public void setDiscontinuidad(boolean discontinuidad){
        myshape.setDiscontinuidad(discontinuidad);
    }
    
    /**
     * Devuelve el valor del spinner del grosor
     * @return un valor tipo float
     */
    public float getSpinner(){
        return myshape.getSpinner();
    }
    
    /**
     * Asigna el valor del spinner del grosor
     * @param valorSpinner  un valor tipo float
     */
    public void setSpinner(float valorSpinner){
        myshape.setSpinner(valorSpinner);
    }
    
    /**
     * Devuelve el valor del spinner de transparencia
     * 
     * @return un valor tipo float
     */
     public float getSpinnerTrans(){
        return myshape.getSpinnerTrans();
    }
    
     /**
      * Asigna el valor del spinner de transparencia
      * @param valorSpinnerTrans un valor tipo float
      */
    public void setSpinnerTrans(float valorSpinnerTrans){
        myshape.setSpinnerTrans(valorSpinnerTrans);
    }
    
    /**
     * Devuelve si la figura está lista para editar
     * @return true o false
     */
    public boolean getEditar() {
        return myshape.getEditar();
    }
    
    /**
     * Asigna si la figura está lista para editar
     * @param editar true o false
     */
    public void setEditar(boolean editar) {
        myshape.setEditar(editar);
    }
    
   
    /**
     * Método sobrecargado de paint, recorremos el vector de figuras y
     * llamamos al paint de la clase myShape
     * @param g valor tipo Graphics
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        for( myShape s: vShape) { //Para cada figura del vector
            s.paint(g2d);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Eventos al hacer click
     * @param evt evento actual
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        punto = evt.getPoint();
        this.repaint();
        
    }//GEN-LAST:event_formMouseClicked
    
    /**
     * Eventos al mantener presionado el click
     * @param evt evento actual
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p = evt.getPoint();
        if(forma==Forma.Lapiz){
            lapiz = new Punto2D(myshape);
            vShape.add(lapiz);
        }
        else if(forma==Forma.Linea){
            l = new Linea2D(myshape);
            vShape.add(l);
        }
        else if(forma==Forma.Rectangulo){
            rectangulo = new Rectangulo2D(myshape);
            vShape.add(rectangulo);
        }
        else if(forma==Forma.Elipse){
             elipse = new Elipse2D(myshape);
             vShape.add(elipse);
                    
        }
        else if(forma==Forma.Area){
            area = new newArea(p.getX(),p.getY(), myshape);
            vShape.add(area);
        }
        else if(forma == Forma.Curva){
            
            if(curvaIniciada){
                curva = new Curva2D(myshape);
                vShape.add(curva);
            }
            else{
                curva2 = new Curva2D(myshape);
                vShape.remove(curva);
                vShape.add(curva2);
            }
        }

    }//GEN-LAST:event_formMousePressed
    /**
     * Evento al liberar el click
     * @param evt evento actual
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseExited
    
    /**
     * Evento al arrastrar el cursor
     * 
     * @param evt evento actual
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(forma == Forma.Lapiz){
            lapiz.setPoints(p,p);
        }
        else if(forma==Forma.Linea)
            l.setPoints(p,evt.getPoint());
        else if(forma==Forma.Rectangulo){
            setP1(p);
            setP2(evt.getPoint());
            rectangulo.setPoints(p, evt.getPoint());
        }
        else if(forma==Forma.Elipse){
            setP1(p);
            setP2(evt.getPoint());
            elipse.setPoints(p, evt.getPoint());
        }
        else if(forma==Forma.Curva && curvaIniciada == false){
             pI = p;
             pF = evt.getPoint();
            curvaIniciada = true;
        }
        else if(forma == Forma.Curva && curvaIniciada == true){
             pC = p;
            curva2.setPoints(pI, pC, pF);
            curvaIniciada = false;
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

 
}
