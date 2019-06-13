/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.image;


import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 * Operación nueva componente a componente, se ha intentado hacer
 * una operación parecia al ecualizador
 * @author maxigang
 */
public class CaCOp extends BufferedImageOpAdapter{
    
    /**
     * Método en el que se realiza la operación, componente a componente
     * 
     * @param src imagen de origen
     * @param dest imagen de destino
     * @return devuelve la imagen de destino
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
          }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        for (int x = 0; x < srcRaster.getWidth(); x++) {
            for (int y = 0; y < srcRaster.getHeight(); y++) {
                for (int band = 0; band < srcRaster.getNumBands(); band++) {
                    
                    int sample = srcRaster.getSample(x, y, band);
                    if (sample < 50){
                        sample=255;
                    }else if(sample >= 80){// si me acerco a 255 la imagen se haría más oscura o si me acerco a 0 la imagen se haría más clara.
                        sample=0;
                    }
                    destRaster.setSample(x, y, band, sample);
                }
            }
        }
        return dest;
    }
}

