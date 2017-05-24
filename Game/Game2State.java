import java.awt.*;
/**
 * Write a description of class Game2State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game2State extends State
{
    private OldMan player;
    private Slime slime;
    public Can can;
    public boolean fire = false;
    public boolean canpunch = true;
    public boolean cancane = true;
    public int canpunch1 = 0;
    public int cancane1 = 0;
    int count = 0;
    public Snake snake;
    public Game2State(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       slime = new Slime(850, 550, game);
       snake = new Snake(800, 500, game);
       can = new Can(player.getX(),player.getY(),70,30);
    }
    public Boss getBoss(){
     return null;   
    }
    public void update(){
        if(player.punchbox.intersects(slime.hitbox))
        {
            if (game.getKeyManager().punch && canpunch){
                slime.hit(1);
                cancane  = false;
            }
        }
        if(player.punchbox.intersects(snake.hitbox))
        {
            if (game.getKeyManager().punch && canpunch){
                snake.hit(1);
                cancane  = false;
            }
        }
        if(player.hitbox.intersects(snake.hitbox)){
            player.hit(1);
        }
        if(player.hitbox.intersects(slime.hitbox)){
            player.hit(1);
        }
        if(game.getKeyManager().can && cancane){
            can = new Can((float) player.punchbox.getX(), (float) player.punchbox.getY(),70,30);
            fire = true;
            cancane = false;
        }
        if(can != null && can.hitbox.intersects(slime.hitbox)){
            fire = false;
            can = null;
            slime.hit(1);
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
        slime.tick();
        snake.tick();
        if(!cancane && cancane1 >= (60*3)){
            cancane = true;
            cancane1 = 0;
        }
        if(!canpunch && canpunch1 >= (60*1)){
            cancane = true;
            cancane1 = 0;
        }
        cancane1++;
        canpunch1++;
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.lvl1_3,0,0,null);
        if(count >=90){
            g.drawImage(Assets.lvl3bg,0,0,null);
            player.render(g);
            slime.render(g);
            snake.render(g);
            if(fire && can.getX() <= 1000){
                can.render(g);
            }
        }
        count++;
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