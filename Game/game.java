import java.awt.*;
import java.awt.image.*;
/**
 * contains the game constructor and game loop
 * 
 * @author Alexander, Maggie, Justin
 * @version 1.0.0
 */
public class game implements Runnable
{
    // Display
    private Display display;
    // width, height, and title of the page made in Launcher.java
    public int width, height;
    public String title;
    // instance variables for the actual game thread
    private boolean running = false; // keeps the game going
    private Thread thread;
    // Buffer Strategy is used to organize things on canvas before it appears on the frame
    private BufferStrategy bs;
    // normal graphics object (like the pen or paper) draws everything
    private Graphics g;
    //private BufferedImage testimage;
    public int timeforswap = 0;
    private State gamestate, menustate, instructionsstate,
    game1state, game2state, bossstate, gameover, loadingstate,
    creditstate;
    
    public boolean set = false;;
    private KeyManager keyManager;
    /**
     * Default constructor for objects of class game
     * @params the width, height, and title of the window 
     */
    public game(int width, int height, String title)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        
        //display = new Display(width, height, title);
    }
    /**
     * Initializer of the thread (runs once on game start)
     */
    private void init()
    {
       display = new Display(width, height, title); 
       display.getFrame().addKeyListener(keyManager);
       //testimage = ImageLoader.loadImage("resources/images/therealtitlescreen.png");
       Assets.init();
       gamestate = new GameState(this);
       game1state = new Game1State(this);
       game2state = new Game2State(this);
       bossstate = new BossState(this);
       menustate = new MenuState(this);
       instructionsstate = new InstructState(this);
       gameover = new GameOverState(this);
       loadingstate = new LoadingState(this); 
       creditstate = new CreditState(this);
       
       //temp
       
       State.setState(menustate);
    }
    // game loop - running
    /**
     * 
     */
    private void update()
    {
        keyManager.tick();
        
        if(State.getState() != null)
        {
            State.getState().update();
        }
    }
    /**
     * 
     */
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width+1000,height+1000);
        //Draw Here
        if(State.getState() != null)
        {
            State.getState().render(g);
        }
        //End Drawing
        bs.show();
        g.dispose();
        //swap through states
        if(keyManager.enter && State.getState() == menustate)
        {
            State.setState(loadingstate);
            set = true; 
        }else if(keyManager.enter && State.getState() == instructionsstate){
            State.setState(gamestate);
            set = false;
            timeforswap= 0;
        }else if(State.getState() == gamestate && gamestate.getSlime().getHealth() == 0){
            State.setState(game1state);
            //State.setState(instructionsstate);
        }else if(State.getState().getOldMan() != null && State.getState().getOldMan().getHealth() <= 0){
            State.setState(gameover);
            set = true;
        }else if(timeforswap >= 50 && State.getState() == loadingstate){
            State.setState(instructionsstate);
        }else if(State.getState() == gameover && timeforswap == 200){
            State.setState(menustate);
            reset();
            gamestate.getOldMan().setHealth(10);
            game1state.getOldMan().setHealth(10);
            set = false; 
            timeforswap= 0;
        }else if(State.getState() == game1state && game1state.getSnake().getHealth() == 0){
            State.setState(game2state);
        }else if(State.getState() == game2state && game2state.getSnake().getHealth() == 0&& game2state.getSlime().getHealth() == 0){
            
                    State.setState(bossstate);
                
            
            //State.setState(bossstate);
        }else if(State.getState() == bossstate && bossstate.getBoss().getHealth() == 0){
            State.setState(creditstate);
        }else if(State.getState() ==creditstate&& keyManager.enter){
            State.setState(menustate);
            reset();
            gamestate.getOldMan().setHealth(10);
            game1state.getOldMan().setHealth(10);
            set = false; 
            timeforswap= 0;
        }
        
        if(set){
            timeforswap+=1;
        }
    }
    /**
     * 
     */
    public void run()
    {
        init();
        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); 
        while(running) 
        {
            now =System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;
            if(delta >= 1){
                update();
                render();
                delta--;
            }
        }
        stop();
    }
    
    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    // end game loop - !running
    /**
     * 
     */
    public synchronized void start()
    {
        if (running)
        {
            return;
        }
        else
        {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    /**
     * 
     */
    public synchronized void stop()
    {
        if (!running)
        {
            return;
        }
        else
        {
            running = false;
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void reset()
    {
        gamestate = new GameState(this);
        game1state = new Game1State(this);
        game2state = new Game2State(this);
        bossstate = new BossState(this);
    }
}
