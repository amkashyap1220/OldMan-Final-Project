import java.awt.*;

/**
 * Write a description of class OldMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldMan extends Creature
{
    private game game;
    public int count = 0;
    public int hitboxX, hitboxXFar, hitboxY, hitboxYFar;
    Rectangle hitbox,punchbox;
    boolean left = false;
    boolean anim = false;
    public OldMan(float x, float y, game game){
        super(x,y, 167, 250);
        this.game = game;
        hitbox = new Rectangle((int)x, (int)y+40,167,170);
        punchbox = new Rectangle((int)x+167,(int)y+165,50,50);
    }
    
    private void getInput()
    {
        xMove = 0;
        yMove = 0;
        
        if (game.getKeyManager().up)
           yMove = -speed;
        if (game.getKeyManager().down)
           yMove = speed;
        if (game.getKeyManager().left)
        {
           xMove = -speed;
           left = true;
           anim = true;
        }
        if (game.getKeyManager().right)
        {
           xMove = speed;
           left = false;
           anim = true;
        }
           
           
        
    }
    
    public void tick(){
        hitbox = new Rectangle((int)x, (int)y+40,167,170);
        punchbox = new Rectangle((int)x+167,(int)y+110,50,50);
        getInput();
        move();
    }
    
    public void render( Graphics g){
        if(x<0){
            x=0;
        }else if(x>900){
            x = 900;
        }
        
        if(y<318){
            y=318;
        }else if (y>450){
            y = 450;
        }
        if (count <20 && left){
            g.drawImage(Assets.idle1, (int) x, (int) y, width, height, null);
        }
        else if (count <20 && !left)
        {
            g.drawImage(Assets.flipidle1, (int) x, (int) y, width, height, null);
        }
        else if (!left)
        {
            if(count == 40){
                count = 0;
            }
            if(anim){
                g.drawImage(Assets.flipidle2, (int) x, (int) y, width, height, null);
            }else{
                g.drawImage(Assets.flipidle1, (int) x, (int) y, width, height, null);
            }     
        }
        else{
            if(count == 40){
                count = 0;
            }
            
            if(anim){
                g.drawImage(Assets.idle2, (int) x, (int) y, width, height, null);
            }else{
                g.drawImage(Assets.idle1, (int) x, (int) y, width, height, null);
            }   
        }
        anim = false;
        count++;
        //health
        g.setColor(Color.gray);
        g.drawRect(0,0,201,26);
        g.setColor(Color.green);
        g.fillRect(1,1,20*getHealth(),25);
        
        //temp
        g.drawRect((int)x+167,(int)y+110,50,50);
        g.drawRect((int)x, (int)y+40,167,170);
    }
    
    public void hit()
    {
        x = x - 50;
        setHealth(health - 1);
    }
    
   
}
