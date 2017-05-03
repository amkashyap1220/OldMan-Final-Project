import java.awt.*;
import javax.swing.*;

/**
 * Title component - holds info on the title
 * 
 * @author Alexander Kashyap, Maggie Sanborn  
 * @version 1.0.0
 */
public class TitleComponent extends JComponent 
{
    int x,y;
    Graphics2D g2; 
    Image Title_Screen;
    //Picture Title_Screen;
    public TitleComponent()
    {
        Title_Screen = Toolkit.getDefaultToolkit().getImage("resources\\images\\titlescreen.png");
        //Title_Screen = new Picture("resources\\images\\titlescreen.png");
    }
    
    public void paintComponent(Graphics g)
    {
        // recover Graphics2D
        g2 = (Graphics2D) g;
        g2.drawImage(Title_Screen,0,0,this);
    }
}
