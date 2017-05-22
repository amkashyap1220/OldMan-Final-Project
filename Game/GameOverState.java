
import java.awt.*;
/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverState extends State
{
    public GameOverState(game game)
    {
       super(game);
    }
    
    public void update(){
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.deadscreen,0,0,null);
    }
    public Slime getSlime(){
        return null;
    }
    public Snake getSnake(){
        return null;
    }
    public OldMan getOldMan(){
        return null;
    }
}
