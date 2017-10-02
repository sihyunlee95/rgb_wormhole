import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
public class NeedleH{
    public int[] x=new int[3];
    public int[] y=new int[3];
    public double ang;
    public int R;
    public int r;
    public int cent;
    double pi=3.1415926535897932384626433832795;
    Color c;
     Color k=new Color(0,0,0);
    public NeedleH(){
        R=220;
        r=10;
        cent=350;
        c=new Color(255,0,0);
    }
    public void Update(long t){
        ang=(t*pi/21600000.0)+(3*pi/2); /** the +3pi/2 term makes the correction for Korean Locale Time*/
        int B=((int) (ang*255/(2*pi)))%256;
        c=new Color(0,255,B);
        x[0]=(int) (cent+330+R*Math.sin(ang));
        x[1]=(int) (cent+330+r*Math.cos(ang));
        x[2]=(int) (cent+330-r*Math.cos(ang));
        y[0]=(int) (cent-R*Math.cos(ang));
        y[1]=(int) (cent+r*Math.sin(ang));
        y[2]=(int) (cent-r*Math.sin(ang));
    }
    public void draw(Graphics g,Color K){
        g.setColor(K);
        g.fillPolygon(x,y,3);
        g.setColor(k);
        g.drawPolygon(x,y,3);
    }
}