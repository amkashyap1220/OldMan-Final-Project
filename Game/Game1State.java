
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
    private Snake snake;
    public Can can;
    public boolean fire = false;
    public Game1State(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       snake = new Snake(850, 550, game);
       can = new Can(player.getX(),player.getY(),70,30);
    }
    
    public void update(){
        if(player.punchbox.intersects(snake.hitbox))
        {
            if (game.getKeyManager().punch){
                snake.hit(1);
            }
        }
        if(player.hitbox.intersects(snake.hitbox)){
            player.hit(1);
        }
        if(game.getKeyManager().can){
            can = new Can((float) player.punchbox.getX(), (float) player.punchbox.getY(),70,30);
            fire = true;
            
        }
        if(can != null && can.hitbox.intersects(snake.hitbox)){
            fire = false;
            can = null;
            snake.hit(1);
        }
        if(fire && can != null && can.getX() <= 1000){
            can.tick();
        }
        if(can != null && can.getX() >= 1000){
            fire = false;
        }
        player.tick();
        snake.tick();
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.lvl2bg,0,0,null);
        player.render(g);
        snake.render(g);
        if(fire && can.getX() <= 1000){
            can.render(g);
        }
    }
    public Slime getSlime(){
        return null;
    }
    public Snake getSnake()
    {
        return snake;
    }
    public OldMan getOldMan(){
        return player;
    }
}