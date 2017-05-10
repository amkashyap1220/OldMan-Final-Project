import javax.swing.JFrame;
import java.awt.*;
/**
 * Write a description of class display here.
 * 
 * @author Alexander, Maggie, and Justin
 * @version 1.0.0
 */
public class Display
{
    // width, height, and title of the page made in Launcher.java
    private int width, height;
    private String title;
    // frame (widow) the game runs through and the canvas to be drawn on
    private JFrame frame;
    private Canvas canvas;
    /**
     * Default constructor for objects of class display
     * @param Height, Width, and Title of a display
     */
    public Display(int height, int width, String title)
    {
        this.width = width; 
        this.height = height; 
        this.title = title; 
        
        createDisplay();
    }
    /**
     * Creates a display and sets visable
     */
    private void createDisplay()
    {
        // Creates frame based off of the parameters passed in Display constructor
        frame = new JFrame(title); 
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Creates the canvas that is drawn on
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        //add the canvas to the window
        frame.add(canvas);
        //pack the window (kinda like sealing it off)
        frame.pack();
    }
    /**
     * The get method for the canvas
     * @return the canvas
     */
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
}
