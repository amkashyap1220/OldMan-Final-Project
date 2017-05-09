

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Creature extends Entity
{
    protected int health;
    
    public Creature (float x, float y){
        super(x,y);
        health = 10;
    }
    
    
}
