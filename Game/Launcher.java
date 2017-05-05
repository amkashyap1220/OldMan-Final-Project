import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Game runs through here
 * 
 * @author Alexander, Maggie, Justin
 * @version 1.0.0
 */
public class Launcher 
{
    // page dimentions
    private static final int PAGE_WIDTH = 1000;
    private static final int PAGE_HEIGHT = 640;
    // page title 
    private static final String PAGE_TITLE = new String("Old Man With A Plan");
    /**
     * main method of the game
     */
    public static void main(String[] args)
    {
        Game game = new Game(PAGE_HEIGHT,PAGE_WIDTH,PAGE_TITLE);
        game.start();
    }


}
