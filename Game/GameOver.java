import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends State
{
    /**
     * Default constructor for objects of class MenuState
     */
    public GameOver(game game)
    {
        super(game);
    }
    public void update(){
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.deadscreen,0,0,null);
    }
    public Slime getSlime(){
        return null;
    }

}
