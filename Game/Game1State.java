
import java.awt.*;
/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game1State extends State
{

    private OldMan player;
    private Slime slime;
    public Game1State(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       slime = new Slime(850, 550, game);
    }
    
    public void update(){
        if(player.hitbox.intersects(slime.hitbox))
        {
            if (game.getKeyManager().punch)
                slime.hit();
            else
                player.hit();
        }
        player.tick();
        slime.tick();
    }
    public void render(Graphics g){
        g.drawImage(Assets.lvl2bg,0,0,null);
        player.render(g);
        slime.render(g);
    }
    public Slime getSlime(){
        return slime;
    }
    public OldMan getOldMan(){
        return player;
    }
}