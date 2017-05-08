import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class MenuState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuState extends State implements KeyListener
{
 
    /**
     * Default constructor for objects of class MenuState
     */
    public MenuState()
    {
        
    }
    public void update(){
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.titlescreen,0,0,null);
    }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    @Override

    public void keyTyped(KeyEvent e) 
    {
        //if (e == '\n')
        {
           // return true;
        }
       // else
        {
          //  return false;
        }
    }
}
