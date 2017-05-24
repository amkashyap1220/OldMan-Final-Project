import java.awt.*;

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Creature
{
    private game game;
    public int count = 0;
    private boolean wall = false;
    public int hitboxX, hitboxXFar, hitboxY, hitboxYFar;
    Rectangle hitbox;
    public Boss(float x, float y, game game){
        super(x,y, 173, 280);
        this.game = game;
        xMove = -3;
        hitbox = new Rectangle((int)x, (int)y, 173, 280);
    }
   
    
    public void tick(){
        hitbox = updateHitbox((int)x+10, (int)y+10, 173, 280);
        if (x <= 1)
           xMove = 2;
        if (x >= 925)
           xMove = -2;
        move();
    }
    
    public void render( Graphics g){
        if (count <40){
            g.drawImage(Assets.boss, (int) x, (int) y, width, height, null);
        }else{
            if(count == 100){
                count = 0;
            }
            g.drawImage(Assets.boss, (int) x, (int) y, width, height, null);
        }
        count++;
        //health
        Color black = new Color(255,255,255);
        g.setColor(black);
        g.drawRect(1000-201,0,201,26);
        g.setColor(Color.green);
        g.fillRect(999-199,1,20*getHealth()-1,25);
        g.setColor(black);
        g.drawString("Mr. Hayes HP",999-200,1+26+15);
        
        //g.drawRect((int)x+10, (int)y+10, 173,  280);
    }
    
    public void createHitbox(int hitboxX, int hitboxXFar, int hitboxY, int hitboxYFar)
    {
        this.hitboxX = hitboxX;
        this.hitboxXFar = hitboxXFar;
        this.hitboxY = hitboxY;
        this.hitboxYFar = hitboxYFar;
    }
    
    public Rectangle updateHitbox(int x, int y, int x2, int y2)
    {
        Rectangle wow = new Rectangle(x, y, x2, y2);
        return wow;
    }
    
    public void hit(int damage)
    {
        if(xMove == 1)
        {
            x = x - 200;
        }
        else
        {
            x = x + 200;
        }
        setHealth(health - damage);
    }

}
