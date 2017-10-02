import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
public class NeedleM{
    public int[] x=new int[3];
    public int[] y=new int[3];
    public double ang;
    public int R;
    public int r;
    public int cent; //center
    double pi=3.1415926535897932384626433832795;
    Color c;
     Color k=new Color(0,0,0);
    public NeedleM(){
        R=280;
        r=7;
        cent=350;
    }
    public void Update(long t){
        ang=t*pi/1800000.0;
        int Red=((int) (ang*256/(2*pi)))%256;
        c=new Color(Red,0,255);
        x[0]=(int) (cent+330+R*Math.sin(ang));
        x[1]=(int) (cent+330+r*Math.cos(ang));
        x[2]=(int) (cent+330-r*Math.cos(ang));
        y[0]=(int) (cent-R*Math.cos(ang));
        y[1]=(int) (cent+r*Math.sin(ang));
        y[2]=(int) (cent-r*Math.sin(ang));
    }
    public void draw(Graphics g, Color K){
        g.setColor(K);
        g.fillPolygon(x,y,3);
        g.setColor(k);
        g.drawPolygon(x,y,3);
    }
}