/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jmg.iu;
import sm.jmg.iu.Lienzo;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

/**
 * Gestiona la imagen situaada en la zona central de la ventana interna
 * 
 *
 * @author maxigang
 */
public class Lienzo2DImagen extends Lienzo{
  
    private BufferedImage img = null;
    
    /**
     * Modifica la imagen vinculada al panel
     * 
     * @param img imagen vinculada al panel
     */
    public void setImage(BufferedImage img){
        this.img = img;
        if(img!=null) {
            setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        }
    }
    
    /**
     * Obtiene la imagen vinculada al panel
     * 
     * @return una imagen tipo BufferedImage
     */
    public BufferedImage getImage(){
        return img;
    }
    
    /**
     * Obtiene la imagen vinculada al panel con todo lo que hemos pintado
     * sobre ella
     * @param drawVector true o false
     * @return una imagen tipo BufferedImage
     */
    public BufferedImage getImage(boolean drawVector){
        if (drawVector) {
            BufferedImage imgAux = new BufferedImage(this.img.getWidth(), this.img.getHeight(), this.img.getType());
            Graphics2D g2d = imgAux.createGraphics();
            this.paint(g2d);
            this.img = imgAux;
            return img;
        }
        else{
            return getImage();
        }
    }
    
    /**
     * Método para visualizar la imagen y el vector de formas
     * @param g valor de tipo Graphics
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null){
            g.drawImage(img,0,0,this);
        }
    }
}

