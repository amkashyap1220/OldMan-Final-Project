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
    titlescreen, loadingscreen, deadscreen,
    lvl1_1,lvl1_2,lvl1_3,lvl1_boss,
    player,
    idle1, idle2,
    walking1, walking2,
    throw1, throw2,
    flipwalking1, flipwalking2,
    flipthrow1, flipthrow2,
    lvl1bg, lvl2bg, lvl3bg,bossbg,
    instructions, nostory, credits,
    slime1, slime2,
    snake1, snake2,
    flipidle1, flipidle2,
    gameover,
    cane1, cane2,
    icon,
    healthbar,
    boss;
    /**
     * Loads all of the images (called by the init() in game)
     */
    public static void init()
    {
        titlescreen = ImageLoader.loadImage("resources/images/title.png");
        loadingscreen = ImageLoader.loadImage("resources/images/loadingscreen.png");
        lvl1_1 = ImageLoader.loadImage("resources/images/lvl1-1.png");
        lvl1_2 = ImageLoader.loadImage("resources/images/lvl1-2.png");
        lvl1_3 = ImageLoader.loadImage("resources/images/lvl1-3.png");
        lvl1_boss = ImageLoader.loadImage("resources/images/lvl1-boss.png");
        deadscreen = ImageLoader.loadImage("resources/images/dead.png");
        player = ImageLoader.loadImage("resources/images/dalelewis.png");
        idle1 = ImageLoader.loadImage("resources/images/idleanim1.png");
        idle2 = ImageLoader.loadImage("resources/images/idleanim2.png");
        walking1 = ImageLoader.loadImage("resources/images/walking1.png");
        walking2 = ImageLoader.loadImage("resources/images/walking2.png");
        flipwalking1 = ImageLoader.loadImage("resources/images/flipwalking1.png");
        flipwalking2 = ImageLoader.loadImage("resources/images/flipwalking2.png");
        throw1 = ImageLoader.loadImage("resources/images/throwanim1.png");
        throw2 = ImageLoader.loadImage("resources/images/throwanim2.png");
        flipthrow1 = ImageLoader.loadImage("resources/images/flipthrowanim1.png");
        flipthrow2 = ImageLoader.loadImage("resources/images/flipthrowanim2.png");
        flipidle1 = ImageLoader.loadImage("resources/images/idleanimflip1.png");
        flipidle2 = ImageLoader.loadImage("resources/images/idleanimflip2.png");
        lvl1bg = ImageLoader.loadImage("resources/images/lvl1bg.png");
        lvl2bg = ImageLoader.loadImage("resources/images/lvl1bg.png");
        lvl3bg = ImageLoader.loadImage("resources/images/lvl1bg.png");
        bossbg = ImageLoader.loadImage("resources/images/lvl1bg.png");
        gameover = ImageLoader.loadImage("resources/images/lvl1bg.png");
        instructions = ImageLoader.loadImage("resources/images/instruct.png");
        slime1 = ImageLoader.loadImage("resources/images/slime1.png");
        slime2 = ImageLoader.loadImage("resources/images/slime2.png");
        snake1 = ImageLoader.loadImage("resources/images/snake1.png");
        snake2 = ImageLoader.loadImage("resources/images/snake2.png");
        boss = ImageLoader.loadImage("resources/images/mrhayes1.jpg");
        cane1 = ImageLoader.loadImage("resources/images/cane.png");
        credits = ImageLoader.loadImage("resources/images/creditscreen.png");
        nostory = ImageLoader.loadImage("resources/images/oopsnostory.png");
        icon = ImageLoader.loadImage("resources/images/icon.png");
        healthbar = ImageLoader.loadImage("resources/images/healthbartransparent.png");
    }
}