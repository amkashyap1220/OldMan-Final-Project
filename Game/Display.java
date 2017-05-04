import javax.swing.JFrame;
import java.awt.*;

/**
 * Write a description of class display here.
 * 
 * @author Alexander, Maggie, Justin
 * @version 1.0.0
 */
public class Display
{
    /**  
     * Height = height of the display
     * title = title of the display
     * frame = the frame for the display (JFrame)
     */
    private int width, height;
    private String title;
    
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
        frame = new JFrame(title); 
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        
        frame.add(canvas);
        frame.pack();
    }

}
