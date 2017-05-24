import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class MenuState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuState extends State //implements KeyListener
{
    public Image i = Assets.titlescreen;
    public Boss getBoss(){
     return null;   
    }
    /**
     * Default constructor for objects of class MenuState
     */
    public MenuState(game game)
    {
        super(game);
    }
    public void update(){
        
    }
    public void render(Graphics g){
        if(game.getKeyManager().up1){
            i = Assets.titlescreen;
        }else if(game.getKeyManager().down1){
            i = Assets.titlescreen1;
        }
        g.drawImage(i,0,0,null);
    }
    public Slime getSlime(){
        return null;
    }
    public Snake getSnake(){
        return null;
    }
    public OldMan getOldMan(){
        return null;
    }
}
