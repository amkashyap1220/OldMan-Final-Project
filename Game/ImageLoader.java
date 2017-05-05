import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Write a description of class ImageLoader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImageLoader
{
    public static BufferedImage loadImage(String path)
    {
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
