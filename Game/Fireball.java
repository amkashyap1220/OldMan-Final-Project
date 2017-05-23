import java.awt.*;

/**
 * Write a description of class Can here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Creature
{
    /** description of instance variable x (add comment for each instance variable) */

    Rectangle hitbox;
    /**
     * Default constructor for objects of class Can
     */
    public Fireball(float x, float y, int width, int height)
    {
        super(x, y, width, height);
        hitbox = new Rectangle((int)x, (int)y,60,56);
    }

    public void tick()
    {
        hitbox = new Rectangle((int)x, (int)y,30,28);
        x -= 6;
        
    }
    public void render(Graphics g)
    {
        
        g.drawImage(Assets.fireball, (int) x, (int) y, width, height, null);
        g.drawRect((int)x, (int)y,30,28);
    }
    
    

}
