
import java.awt.*;
/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState extends State
{

    private OldMan player;
    public GameState(game game)
    {
       super(game);
       player = new OldMan(100,100, game);
    }
    
    public void update(){
        player.tick();
    }
    public void render(Graphics g){
        player.render(g);
    }

}
