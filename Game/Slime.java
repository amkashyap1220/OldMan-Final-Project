import java.awt.*;

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends Creature
{
    private game game;
    public int count = 0;
    private boolean wall = false;
    public Slime(float x, float y, game game){
        super(x,y, 100, 75);
        this.game = game;
        xMove = -3;
    }
   
    
    public void tick(){
        if (x == 1)
           xMove = 3;
        if (x == 1000)
           xMove = -3;
        move();
    }
    
    public void render( Graphics g){
        if (count <40){
            g.drawImage(Assets.slime1, (int) x, (int) y, width, height, null);
        }else{
            if(count == 100){
                count = 0;
            }
            g.drawImage(Assets.slime2, (int) x, (int) y, width, height, null);
        }
        count++;
    }

}
