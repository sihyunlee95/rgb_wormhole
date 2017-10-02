import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
public class NeedleS{
    public int[] x=new int[3];
    public int[] y=new int[3];
    /** x[0] and y[0] stores the needlepoint's position
     * x[1], y[1], x[2], y[2] stores the needle base's positions
     * all needles are very sharp isosceles triangles
       */
    public double ang; /**angle with respect to vertical (12o'clock)*/
    public int R;
    public int r;
    public int cent;/**center position*/
    double pi=3.1415926535897932384626433832795;
    Color c;
    Color k=new Color(0,0,0);
    public NeedleS(){
        R=330;
        r=3;
        cent=350;
    }
    public boolean Update(long t){
        /**sets the position of the three vertices of the needle*/
        ang=t*pi/30000.0; /**angular velocity pi/30000*/
        x[0]=(int) (cent+330+R*Math.sin(ang));
        x[1]=(int) (cent+330+r*Math.cos(ang));
        x[2]=(int) (cent+330-r*Math.cos(ang));
        y[0]=(int) (cent-R*Math.cos(ang));
        y[1]=(int) (cent+r*Math.sin(ang));
        y[2]=(int) (cent-r*Math.sin(ang));
        
        /**signals update of Rings every time big index point is reached*/
        int G=((int) (ang*20*12/(2*pi)))%20;
        
        return G==0;
        /**used % operator: this controls warp time. 
         * The longer the number in place of 20 is, the shorter the warp time
         * for a short time the NeedleS Update method continuously returns true
         * This makes the Rings Update method recalled continuously,
         * therefore making chaotic random colored rings for a flash of time
         * 
           */
    }
    public void draw(Graphics g, Color K){
        /**draws the Needle on the frame*/
        g.setColor(K);
        g.fillPolygon(x,y,3);
        g.setColor(k);
        g.drawPolygon(x,y,3);
    }
}