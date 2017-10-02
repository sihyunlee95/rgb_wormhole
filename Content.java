import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.io.*;
import java.util.*;
public class Content extends JPanel
{    
    NeedleS s=new NeedleS();
    NeedleM m=new NeedleM();
    NeedleH h=new NeedleH();
    Rings r=new Rings();
    double pi=3.1415926535897932384626433832795;    
    public Content(){
    }
    public void update(long time){       
        m.Update(time);
        h.Update(time);
        if(s.Update(time)){
            /**
             * Whether r should be updated or not is determined only by which second we are at
             * Rings is updated only when the NeedleS signals to do so
             */
            r.Update(time);
        }
    }
    public void paint(Graphics g){
        /**
         * The paint method
         * 1) places the index points of the clock
         * 2) places the objects: Rings, NeedleS, NeedleM, NeedleH, and the Center Piece
         */
        
        /**drawing index points, one at r=230, one at r=330*/
        r.Draw(g);
        g.setColor(r.Opp());
        int dx, dy;
        
        /**60 small index points*/
        for(int i=0;i<60;i++){
            int r=4;
            dx=(int) (330*Math.sin(2*pi*i/60));
            dy=(int) (330*Math.cos(2*pi*i/60));
            g.fillOval(680+dx-r,350+dy-r,2*r,2*r);
            dx=(int) (230*Math.sin(2*pi*i/60));
            dy=(int) (230*Math.cos(2*pi*i/60));
            g.fillOval(680+dx-r,350+dy-r,2*r,2*r);
        }
        
        /** 12 big index points*/
        for(int i=0;i<12;i++){
            int r=8;
            dx=(int) (330*Math.sin(2*pi*i/12));
            dy=(int) (330*Math.cos(2*pi*i/12));
            g.fillOval(680+dx-r,350+dy-r,2*r,2*r);
            dx=(int) (230*Math.sin(2*pi*i/12));
            dy=(int) (230*Math.cos(2*pi*i/12));
            g.fillOval(680+dx-r,350+dy-r,2*r,2*r);
        }
        
        /**placing needles with colors related to the gradation*/
        s.draw(g,r.Sec());
        m.draw(g,r.Min());
        h.draw(g,r.Hr());
        
        r.DrawCenter(g); /**places center piece*/
    }
}