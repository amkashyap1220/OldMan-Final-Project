

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Creature extends Entity
{
    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 1.75f;
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    
    public Creature (float x, float y, int width, int height){
        super(x,y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    public void move()
    {
        x += xMove;
        y += yMove;
    }
    
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public float getSpeed()
    {
        return speed;
    }
    public void setSpeed(float speed)
    {
        this.speed = speed;
    }
    
    public float getXMove()
    {
        return xMove;
    }
    public void setXMove(float xMove)
    {
        this.xMove = xMove;
    }
    public float getYMove()
    {
        return yMove;
    }
    public void setYMove(float yMove)
    {
        this.yMove = yMove;
    }
    
}
