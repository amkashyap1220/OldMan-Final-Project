
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
    private Slime slime;
    public GameState(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       slime = new Slime(850, 550, game);
    }
    
    public void update(){
        if(player.hitbox.intersects(slime.hitbox))
            player.hit();
        player.tick();
        slime.tick();
    }
    public void render(Graphics g){
        g.drawImage(Assets.lvl1bg,0,0,null);
        player.render(g);
        slime.render(g);
    }

}
