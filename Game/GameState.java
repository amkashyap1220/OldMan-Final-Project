
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
    public Slime slime;
    public Can can;
    public boolean fire = false;
    public GameState(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       slime = new Slime(850, 550, game);
       can = new Can((float) player.punchbox.getX(), (float) player.punchbox.getY(),70,30);
    }
    
    public void update(){
        if(player.punchbox.intersects(slime.hitbox))
        {
            if (game.getKeyManager().punch){
                slime.hit(1);
            }
        }
        if(player.hitbox.intersects(slime.hitbox)){
            player.hit(1);
        }
        if(game.getKeyManager().can){
            can = new Can((float) player.punchbox.getX(), (float) player.punchbox.getY(),70,30);
            fire = true;
            
        }
        if(can != null && can.hitbox.intersects(slime.hitbox)){
            fire = false;
            can = null;
            slime.hit(1);
        }
        if(fire && can != null && can.getX() <= 1000){
            can.tick();
        }
        if(can != null && can.getX() >= 1000){
            fire = false;
        }
        player.tick();
        slime.tick();
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.lvl1bg,0,0,null);
        player.render(g);
        slime.render(g);
        if(fire && can.getX() <= 1000){
            can.render(g);
        }
    }
    public Slime getSlime(){
        return slime;
    }
    public Snake getSnake(){
        return null;
    }
    public OldMan getOldMan(){
        return player;
    }
}
