/**
 * Game runs through here
 * 
 * @author Alexander, Maggie, Justin
 * @version 1.0.0
 */
public class Game implements Runnable
{
    /** description of instance variable x (add comment for each instance variable) */
    private Display display;
    public int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    /**
     * Default constructor for objects of class game
     */
    public Game(int width, int height, String title)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        
        //display = new Display(width, height, title);
    }
    /**
     * Initializer of the thread (runs once on game start)
     */
    private void init()
    {
       display = new Display(width, height, title); 
    }
    
    // BEGINING OF THE GAME LOOP & THREAD. RUNS UNTIL CLOSE AKA !running
    /**
     * 
     */
    private void update()
    {
        
    }
    
    /**
     * 
     */
    private void render()
    {
        
    }
    
    /**
     * 
     */
    public void run()
    {
        init();
        
        while(running) 
        {
            update();
            render();
        }
        
        stop();
    }
    // END OF GAME LOOP
    
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
}
