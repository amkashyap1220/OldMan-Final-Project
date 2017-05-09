import java.awt.*;

/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entity
{
    protected float x, y;
    
    public Entity( float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
}
