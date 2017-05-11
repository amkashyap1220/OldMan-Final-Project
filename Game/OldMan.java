import java.awt.*;

/**
 * Write a description of class OldMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldMan extends Creature
{
    private game game;
    public OldMan(float x, float y, game game){
        super(x,y);
        this.game = game;
    }
    
    public void tick(){
        if(game.getKeyManager().up)
           y-=3;
        if(game.getKeyManager().down)
           y+=3;
        if(game.getKeyManager().left)
           x-=3;
        if(game.getKeyManager().right)
           x+=3;
    }
    
    public void render( Graphics g){
        g.drawImage(Assets.idle1, (int) x, (int) y, null);
    }
}
