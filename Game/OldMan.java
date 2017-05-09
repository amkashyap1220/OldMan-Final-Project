import java.awt.*;

/**
 * Write a description of class OldMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldMan extends Creature
{
    public OldMan(float x, float y){
        super(x,y);
    }
    
    public void tick(){
        
    }
    
    public void render( Graphics g){
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
