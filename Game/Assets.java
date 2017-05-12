import java.awt.image.*;
/**
 * Loads the images to be used in the game
 * 
 * @author Alexander, Maggie, and Justin
 * @version 1.0.0
 */
public class Assets
{
    //Add all assets here
    public static BufferedImage titlescreen,
    player,
    idle1,
    idle2;
    /**
     * Loads all of the images (called by the init() in game)
     */
    public static void init()
    {
        titlescreen = ImageLoader.loadImage("resources/images/therealtitlescreen.png");
        player = ImageLoader.loadImage("resources/images/dalelewis.png");
        idle1 = ImageLoader.loadImage("resources/images/idleanim1.png");
        idle2 = ImageLoader.loadImage("resources/images/idleanim2.png");
    }
}