import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class MenuState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructState extends State //implements KeyListener
{
 
    /**
     * Default constructor for objects of class MenuState
     */
    public InstructState(game game)
    {
        super(game);
    }
    public void update(){
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.instructions,0,0,null);
    }
   public Slime getSlime(){
        return null;
    }
}
