import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Game runs through here
 * 
 * @author Alexander Kashyap, Maggie Sanborn  
 * @version 1.0.0
 */
public class game
{
    // page dimentions
    private static final int PAGE_WIDTH = 1000;
    private static final int PAGE_HEIGHT = 640;
    
    // page title 
    private static final String PAGE_TITLE = new String("Old Man With A Plan");
    public static Scanner test = new Scanner(System.in);
    // 
    /**
     * Default constructor for objects of class game
     */
    public static void main(String[] args)throws InterruptedException
    {
        // Create frame and set the afformentioned dimentions and title
        JFrame frame = new JFrame();
        frame.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        frame.setTitle(PAGE_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Title
        TitleComponent title = new TitleComponent();
        frame.add(title);
        
        //Make frame visible
        frame.setVisible(true); 
        
        // Animate the frame - Call nextFrame() from each component to animate
        // Loop until each level is over
        boolean cycle_title = true;
        while(cycle_title) // repaint in nextFrame() method
        {
            Thread.sleep(100); 
        }
        
    }


}
