import java.awt.*;

/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class State
{
    private static State currentstate = null;
    protected game game;
    
    public State(game game){
        this.game = game;
    }
    
    public static void setState(State state){
        currentstate = state;
    }
    public static State getState(){
        return currentstate;
    }
    public abstract Slime getSlime();
    public abstract Snake getSnake();
    public abstract OldMan getOldMan();
    public abstract Boss getBoss();
    public abstract void update();
    public abstract void render(Graphics g);
}
