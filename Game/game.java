import java.awt.image.*;
import java.awt.*;
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
    /**
     * Default constructor for objects of class game
     * @params the width, height, and title of the window 
     */
    public game(int width, int height, String title)
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
       //testimage = ImageLoader.loadImage("resources/images/titlescreen.png");
       Assets.init();
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
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width,height);
        
        //Draw Here
        //g.drawImage(testimage,0,0,null);
        g.drawImage(Assets.titlescreen,0,0,null);
        
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
