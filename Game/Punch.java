import java.awt.*;

/**
 * Write a description of class Punch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punch
{
    Rectangle OldMans;
    Rectangle hitbox;
    public Punch(Rectangle OldMan)
    {
        OldMans = OldMan;
        hitbox = new Rectangle((int) OldMans.getX() + 167, (int) OldMans.getY() + 170, 50, (int) OldMans.getHeight());
    }
    
    public void tick()
    {
        hitbox = null;
    }
    

}
