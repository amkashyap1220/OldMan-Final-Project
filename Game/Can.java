import java.awt.*;

/**
 * Write a description of class Can here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Can extends Creature
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

    /**
     * Default constructor for objects of class Can
     */
    public Can(float x, float y, int width, int height)
    {
        super(x, y, width, height);
    }

    public void tick()
    {
        xMove = 3;
        move();
    }
    public void render(Graphics g)
    {
        
        g.drawImage(Assets.cane1, (int) x, (int) y, width, height, null);
        
    }
    
    

}
