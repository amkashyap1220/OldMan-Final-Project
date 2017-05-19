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
    public static BufferedImage 
    titlescreen,
    player,
    idle1,
    idle2,
    lvl1bg,
    instructions,
    slime1, slime2,
    flipidle1, flipidle2,
    gameover,
    lvl2bg,
    loadingscreen,
    deadscreen,
    cane1,
    cane2;
    /**
     * Loads all of the images (called by the init() in game)
     */
    public static void init()
    {
        titlescreen = ImageLoader.loadImage("resources/images/titlescreen.png");
        loadingscreen = ImageLoader.loadImage("resources/images/loadingscreen.png");
        deadscreen = ImageLoader.loadImage("resources/images/dead.png");
        player = ImageLoader.loadImage("resources/images/dalelewis.png");
        idle1 = ImageLoader.loadImage("resources/images/idleanim1.png");
        idle2 = ImageLoader.loadImage("resources/images/idleanim2.png");
        flipidle1 = ImageLoader.loadImage("resources/images/idleanimflip1.png");
        flipidle2 = ImageLoader.loadImage("resources/images/idleanimflip2.png");
        lvl1bg = ImageLoader.loadImage("resources/images/lvl1bg.png");
        lvl2bg = ImageLoader.loadImage("resources/images/lvl1bg.png");
        gameover = ImageLoader.loadImage("resources/images/lvl1bg.png");
        instructions = ImageLoader.loadImage("resources/images/instruct.png");
        slime1 = ImageLoader.loadImage("resources/images/slime1.png");
        slime2 = ImageLoader.loadImage("resources/images/slime2.png");
    }
}