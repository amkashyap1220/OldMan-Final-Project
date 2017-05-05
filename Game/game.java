import java.awt.image.*;
import java.awt.*;
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
    
    private BufferStrategy bs;
    private Graphics g;
    
    private BufferedImage testimage;
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
       testimage = ImageLoader.loadImage("resources/images/titlescreen.png");
    }
    
    // game loop - running
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
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width,height);
        //Draw Here
        g.drawImage(testimage,0,0,null);
        //End Drawing
        bs.show();
        g.dispose();
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
}
