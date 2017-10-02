import java.awt.*;
import javax.swing.*;
public class Application
{
   public static void main(String[] args){
       JFrame frame = new JFrame("RGB Wormhole Clock");
       /** This is a RGB Wormhole Clock
        *  There is a clock in the center, a radial gradation of colors, and 5-second interval warps between gradations
        *  The warp makes a very colorful random set of rings
        */
       Content con = new Content();
       frame.add(con);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setSize(1360+frame.getInsets().left + frame.getInsets().right, 760+frame.getInsets().top + frame.getInsets().bottom);
       long currentTime = System.currentTimeMillis();
       while (true){
            long frameStart = System.currentTimeMillis();
            con.update(currentTime%86400000);
            /**
             * Each day is 86400000 seconds long, and the System.currentTimeMillis() method returns the number of ms elapsed from 1970.01.01. 00:00:00AM. 
             * Therefore currentTime%86400000 gives times elapsed since the start of the day, which is the refined form of the necessary data required in other methods
             */
            frame.repaint();
            currentTime = frameStart;
       }
   }
}