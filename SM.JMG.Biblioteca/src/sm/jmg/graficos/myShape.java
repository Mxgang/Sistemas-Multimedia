/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.graficos;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Composite;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;

/**
 * Clase propia de Shape donde se gestiona todos los atributos de las figuras
 * así como poder pintarlas.
 * 
 * @author maxigang
 */
public class myShape {
    Point punto;
    Point2D p1,p2;
    Color color, colorRelleno, colorTrazo, colorFrente, colorFondo;
    boolean colorPlano;
    boolean transparencia, alisado, editar, discontinuidad;
    String valorRelleno;
    float valorSpinner;
    float valorSpinnerTrans;
    RenderingHints render;
    RenderingHints noRender;
    Composite comp;
    Composite noComp;
    Stroke trazo;
    Shape figura;
    Shape figuraArea;
    GradientPaint relleno;
    
    
    /**
     * Constructor de la clase donde inicializamos todas las variables
     * con un valor predeterminado a la hora de pintar cualquier figura
     */
    public myShape(){
        colorPlano = false;
        color = color.BLACK;
        colorRelleno = color.BLACK;
        colorTrazo = color.BLACK;
        colorFrente = color.BLACK;
        colorFondo = color.BLACK;
        alisado = false;
        discontinuidad = false;
        editar = false;
        valorRelleno = "sinRelleno";
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        noComp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        noRender = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_OFF);
        trazo = new BasicStroke(0);  
    }
    
    /**
     * Hace una copia a los atributos del shape actual para que no se pierdan
     * 
     * @param otherShape figura actual en el que le recordamos qué atributos 
     * tiene para que así los guarde en el vector y no se cambien
     * cuando se crea otra figura
     */
    protected void copyAttributes(myShape otherShape){
        this.p1 = otherShape.p1;
        this.p2 = otherShape.p2;
        this.colorFrente = otherShape.colorFrente;
        this.colorFondo = otherShape.colorFondo;
        this.colorPlano = otherShape.colorPlano;
        this.color = otherShape.color;
        this.colorRelleno = otherShape.colorRelleno;
        this.colorTrazo = otherShape.colorTrazo;
        this.valorRelleno = otherShape.valorRelleno;
        this.alisado = otherShape.alisado;
        this.editar = otherShape.editar;
        this.valorSpinner = otherShape.valorSpinner;
        this.valorSpinnerTrans = otherShape.valorSpinnerTrans;
        this.trazo = new BasicStroke(valorSpinner);
        this.discontinuidad = otherShape.discontinuidad;
        if(discontinuidad){
            float patronDiscontinuidad[] = {15.0f, 15.0f};
            trazo = new BasicStroke(valorSpinner, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidad, 0.0f);
        }
        this.comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, valorSpinnerTrans);
    }
    
    /**
     * Asigna el valor del punto inicial de la figura
     * @param p1 punto inicial de la figura
     */
    public void setP1(Point2D p1){
        this.p1 = p1;
    }
    
    /**
     * Asigna el valor del punto final de la figura
     * @param p2 punto final de la figura
     */
    public void setP2(Point2D p2){
        this.p2 = p2;
    }
    
    /**
     * Devuelve el valor del punto inicial de la figura
     * @return un punto2D
     */
    public Point2D getP1(){
        return p1;
    }
    
    /**
     * Devuelve el valor del punto final del a figura
     * @return un punto2D
     */
    public Point2D getP2(){
        return p2;
    }
    
    /**
     * Devuelve el valor de colorPlano para saber si se está
     * seleccionando un color predeterminado o no.
     * 
     * @return true o false
     */
    public boolean getEsPlano(){
        return colorPlano;
    }
    
    /**
     * Asigna el colorPlano para saber si se está seleccionando
     * un color predeterminado o no
     * 
     * @param colorPlano puede ser true o false
     */
    public void setEsPlano(boolean colorPlano){
        this.colorPlano = colorPlano;
    }
    
    /**
     * Devuelve el color predeterminado
     * 
     * @return valor de color (blue, yellow, red, black o green)
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Asigna un color predeterminado
     * 
     * @param color puede ser green, yellow, blue, black o red
     */
    public void setColor(Color color){
        this.color = color;
    }
    
    /**
     * Devuelve el color del relleno
     * 
     * @return valor del color: red, green, black, blue o yellow
     */
    public Color getColorRelleno(){
        return colorRelleno;
    }
    
    /**
     * Asigna el color de relleno
     * 
     * @param colorRelleno puede ser red, green, black, blue o yellow
     */
    public void setColorRelleno(Color colorRelleno){
        this.colorRelleno = colorRelleno;
    }
    
    /**
     * Devuelve el color del trazo
     * 
     * @return  puede ser red, green, black, blue o yellow
     */
    public Color getColorTrazo(){
        return colorTrazo;
    }
    
    /**
     * Asigna el color del trazo
     * 
     * @param colorTrazo puede ser red, green, black, blue o yellow
     */
    public void setColorTrazo(Color colorTrazo){
        this.colorTrazo = colorTrazo;
    }
    
    /**
     * Asigna el color frente del degradado
     * @param colorFrente puede ser rojo, verde, negro, azul o amarillo
     */
    public void setColorFrente(Color colorFrente){
        
        this.colorFrente = colorFrente;
    }
    
    /**
     * Asigna el color de fondo del degradado
     * 
     * @param colorFondo puede ser rojo, verde, negro, azul o amarillo
     */
    public void setColorFondo(Color colorFondo){
        this.colorFondo = colorFondo;
    }
    /**
     * Devuelve el tipo de relleno seleccionado
     * 
     * @return los valores son: con relleno, sin relleno o degradado
     */
    public String getRelleno() {
        return valorRelleno;
    }
    
    /**
     * Asigna el tipo de relleno 
     * 
     * @param valorRelleno (sin relleno, con relleno o
     * degradado)
     */
    public void setRelleno(String valorRelleno) {
        this.valorRelleno = valorRelleno;
    }
    
    /**
     * Nos devuelve si la el botón alisado está pulsado o no
     * 
     * @return true o false
     */
    public boolean getAlisado(){
        return alisado;
    }
    
    /**
     * Asigna para que la figura se alise o no
     * 
     * @param alisado puede ser true o false
     */
    public void setAlisado(boolean alisado){
        this.alisado = alisado;
    }
    
    /**
     * Devuelve si la figura tiene un trazo discontinuo o no
     * 
     * @return true o false
     */
    public boolean getDiscontinuidad(){
        return discontinuidad;
    }
    
    /**
     * Asigna para que la figura esté discontinua o no
     * 
     * @param discontinuidad true o false
     */
    public void setDiscontinuidad(boolean discontinuidad){
        this.discontinuidad= discontinuidad;
    }
    
    /**
     * Devuelve el valor del spinner del grosor
     * 
     * @return un valor tipo float
     */
    public float getSpinner(){
        return valorSpinner;
    }
    
    /**
     * Asigna el valor del spinner del grosor
     * 
     * @param valorSpinner un valor tipo float
     */
    public void setSpinner(float valorSpinner){
        this.valorSpinner = valorSpinner;
    }
    
    /**
     * Devuelve el valor del spinner de transparencia
     * 
     * @return valor tipo float
     */
    public float getSpinnerTrans(){
        return valorSpinner;
    }
    
    /**
     * Asigna el valor del spinner de transparencia
     * 
     * @param valorSpinnerTrans valor tipo float
     */
    public void setSpinnerTrans(float valorSpinnerTrans){
        this.valorSpinnerTrans = valorSpinnerTrans;
    }
    
    /**
     * Devuelve si la figura está lista para ser editada o no
     * 
     * @return true o false
     */
    public boolean getEditar() {
        return editar;
    }

    /**
     * Asigna para que la figura esté lista para ser editada o no
     * 
     * @param editar true o false
     */
    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    /**
     * Implementacion del método paint donde dependiendo del valor
     * de algunos valores, se realizarán cambios en la figura o no
     * 
     * @param g2d valor de tipo Graphics2D en uso
     */      
    public void paint(Graphics2D g2d) {
        
       
        if(colorPlano)
            g2d.setColor(color);
        
        g2d.setStroke(trazo);
        
        
        if (valorSpinnerTrans!=0) {
            g2d.setComposite(comp);
        }
        else
            g2d.setComposite(noComp);

        if (alisado) {
            g2d.setRenderingHints(this.render);
        } 
        else
            g2d.setRenderingHints(noRender);
        
        if (getRelleno()=="conRelleno" && !colorPlano){
            
            g2d.setColor(colorRelleno);
            g2d.fill(figura);
            g2d.setColor(colorTrazo);
            g2d.draw(figura);
        }
        else if(getRelleno()=="conRelleno" && colorPlano)
            g2d.fill(figura);
        
        else if (getRelleno()=="sinRelleno"){
            
            g2d.draw(figura);
            if(figuraArea!=null)
                g2d.draw(figuraArea);
        }
        else if(getRelleno()=="Degradado" && (p1 != null || p2 != null)){
            relleno = new GradientPaint(p1, colorFrente, p2, colorFondo);
            g2d.setPaint(relleno);
            g2d.fill(figura);
        }
        
        
    }
}
