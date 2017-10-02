import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
/**Ring[][] index, used 2-D array
     * first number: Ring No.
     * Ring[#][0]=diameter
     * Ring[#][1]=x-value
     * Ring[#][2]=y-value
     */
public class Rings{
    public int[][] Ring=new int[64][3];
    public Color[] Col=new Color[192];
    public int head; /**head stores the Color[] index for Ring[0]*/
    public Rings(){
        /**set size and place for all rings*/
        for(int i=0;i<64;i++){
            Ring[i][0]=26+24*i;
            Ring[i][1]=667-12*i;
            Ring[i][2]=337-12*i;
        }
        /**Rings are centered at 680, 350
         * The base radius is 26 and the distance between rings is 12
           */
        
        
        
        /** set Color[] such that it has a smooth gradation, alternating between six colors*/
        for(int i=0;i<32;i++){
            Col[i]=new Color(255,8*i,0);        //red->yellow
            Col[i+32]=new Color(255-8*i,255,0); //yellow->green
            Col[i+64]=new Color(0,255,8*i);     //green->cyan
            Col[i+96]=new Color(0,255-8*i,255); //cyan->blue
            Col[i+128]=new Color(8*i,0,255);    //blue->magenta
            Col[i+160]=new Color(255,0,255-8*i);//magenta->red
        }
        head=0;
    }
    public void Update(long t){
        /** shifts head into a random position
         * randomizing start color, rest of the rings' colors are determined automatically
         * because Col[] assigns the sequence of colors
         */
        Random rng=new Random();
        int k=rng.nextInt(16);
        head=head+k;
    }
    public void Draw(Graphics g){
        /** starting from outermost ring, draw very many rings on frame
         * the rings form a beautiful grdation
         */
        for(int i=63;i>0;i--){
            g.setColor(Col[(head+i)%192]);
            g.fillOval(Ring[i][1],Ring[i][2],Ring[i][0],Ring[i][0]);
        }
    }
    public void DrawCenter(Graphics g){
        /**draws center circle: covers the overlap region of the three needles, making clock look neater*/
        g.setColor(Opp());
        g.fillOval(668,338,24,24);
    }
    public Color Sec(){ /** returns color for NeedleS*/
        return Col[(head+63)%192];
    }
    public Color Min(){ /** returns color for NeeldeM*/
        return Col[(head+31)%192];
    }
    public Color Hr(){ /**returns color for NeedleH*/
        return Col[head%192];
    }
    public Color Opp(){ /**returns color for index points*/
        return Col[(head+96)%192];
    }
}