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
    public OldMan(float x, float y, game game){
        super(x,y, 167, 250);
        this.game = game;
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
           xMove = -speed;
        if (game.getKeyManager().right)
           xMove = speed;
        
    }
    
    public void tick(){
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
        if (count <40){
            g.drawImage(Assets.idle1, (int) x, (int) y, width, height, null);
        }else{
            if(count == 100){
                count = 0;
            }
            g.drawImage(Assets.idle2, (int) x, (int) y, width, height, null);
        }
        count++;
    }
}
