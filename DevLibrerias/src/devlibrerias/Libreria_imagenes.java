package devlibrerias;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author fredy
 */
public class Libreria_imagenes {
   public BufferedImage getImageResize(String rutaImagen, int ancho, int alto) {
       try{
            BufferedImage img = ImageIO.read(new File(rutaImagen));
            BufferedImage imgResize = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = imgResize.createGraphics();
            g2d.drawImage(img, 0, 0, ancho  , alto, null);
            g2d.dispose();
            return imgResize;
       }catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
