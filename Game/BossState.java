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
    public Fireball fireball;
    public boolean firefireball = false;
    public boolean fire = false;
    public boolean canpunch = true;
    public boolean cancane = true;
    public int canpunch1 = 0;
    int count = 0;
    public int cancane1 = 0;
    int firetimer = 0;
    float randomNum;
    public BossState(game game)
    {
       super(game);
       player = new OldMan(100,408, game);
       MRHAYES = new Boss(850, 400, game);
       can = new Can(player.getX(),player.getY(),70,30);
       fireball = new Fireball((float) MRHAYES.hitbox.getX() - 30, (float) MRHAYES.hitbox.getY() + 30,30,28);
    }
    
    public void update(){
        randomNum = MRHAYES.getY() + (float)(Math.random() * 280);
        if(player.punchbox.intersects(MRHAYES.hitbox))
        {
            if (game.getKeyManager().punch && canpunch){
                MRHAYES.hit(1);
                cancane  = false;
            }
        }
        if(player.hitbox.intersects(MRHAYES.hitbox)){
            player.hit(1);
        }
        if(game.getKeyManager().can && cancane){
            can = new Can((float) player.punchbox.getX(), (float) player.punchbox.getY(),70,30);
            fire = true;
            cancane = false;
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
        
        if(firetimer == 120){
            fireball = new Fireball((float) MRHAYES.hitbox.getX() - 30, randomNum,30,28);
            firefireball = true;
            firetimer = 0;
        }
        if(fireball != null && fireball.hitbox.intersects(player.hitbox)){
            firefireball = false;
            fireball = null;
            player.hit(2);
        }
        if(firefireball && fireball != null && fireball.getX() >= 0){
            fireball.tick();
        }
        if(fireball != null && fireball.getX() <= 0){
            firefireball = false;
        }
        player.tick();
        MRHAYES.tick();
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
        firetimer++;
        
    }
    public void render(Graphics g){
        g.drawImage(Assets.lvl1_boss,0,0,null);
        if(count >=90){
            g.drawImage(Assets.bossbg,0,0,null);
            player.render(g);
            MRHAYES.render(g);
            if(fire && can.getX() <= 1000){
                can.render(g);
            }
            
            if(firefireball && fireball.getX() >= 0){
                fireball.render(g);
            }
        }
        count++;
    }
    public Slime getSlime(){
        return null;
    }
    public Snake getSnake(){
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
