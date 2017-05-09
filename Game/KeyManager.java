import java.awt.event.*;

/**
 * Write a description of class KeyManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyManager implements KeyListener
{
    private boolean[] keys;
    public boolean up, down, left, right;
    public KeyManager(){
        keys = new boolean[256];
    }
    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }
    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
    public void keyTyped(KeyEvent e){
        
    }
}
