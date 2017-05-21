import java.awt.*;
/**
 * Write a description of class Game2State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossState extends State
{
    private OldMan player;
    private Boss MRHAYES;
    public Can can;
    public boolean fire = false;
    public BossState(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       MRHAYES = new Boss(850, 400, game);
       can = new Can(player.getX(),player.getY(),70,30);
    }
    
    public void update(){
        if(player.punchbox.intersects(MRHAYES.hitbox))
        {
            if (game.getKeyManager().punch){
                MRHAYES.hit(1);
            }
        }
        if(player.hitbox.intersects(MRHAYES.hitbox)){
            player.hit(1);
        }
        if(game.getKeyManager().can){
            can = new Can((float) player.punchbox.getX(), (float) player.punchbox.getY(),70,30);
            fire = true;
            
        }
        if(can != null && can.hitbox.intersects(MRHAYES.hitbox)){
            fire = false;
            can = null;
            MRHAYES.hit(1);
        }
        if(fire && can != null && can.getX() <= 1000){
            can.tick();
        }
        if(can != null && can.getX() >= 1000){
            fire = false;
        }
        player.tick();
        MRHAYES.tick();
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.bossbg,0,0,null);
        player.render(g);
        MRHAYES.render(g);
        if(fire && can.getX() <= 1000){
            can.render(g);
        }
    }
    public Slime getSlime(){
        return null;
    }
    public Boss getBoss()
    {
        return MRHAYES;
    }
    public OldMan getOldMan(){
        return player;
    }
}
