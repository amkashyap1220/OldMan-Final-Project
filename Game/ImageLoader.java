import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Image Loader class loads in images from resources folder
 * 
 * @author Alexander, Maggie, and Justin
 * @version 1.0.0
 */
public class ImageLoader
{
    public static BufferedImage loadImage(String path)
    {
        //Try to get the image and if 
        try
        {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
