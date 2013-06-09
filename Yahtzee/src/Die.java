import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Die extends JButton implements MouseListener{
    int face; //number of dots showing 1-6
    boolean keep;

    //Constructor
    public Die(boolean k){
    	keep = k;
        //roll(); //activate this if you want the dice to automatically roll

        setPreferredSize( new Dimension(100,100));
        setEnabled(true);
        addMouseListener(this);
        setBackground(new Color(255,25,0));
        repaint();
        setBackground(new Color(255,25,0));
    }
    
	@Override
	public void mousePressed(MouseEvent e) {}
	public void mouseClicked (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited	 (MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		keep = !keep;
		repaint();
		setBackground(Color.lightGray);
	}

    //new random number for the Die
    public void roll(){
        if(!keep){ face = (int)(Math.random()*6+1); }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        if (keep){ 
        	setEnabled(false); 
        	setOpaque(true); 
        }
        else { 
        	setEnabled(true);
        	setOpaque(false);
        }
        
        int a = 20, b = 45, c = 70;

        if (face==1 || face==3 || face==5){
            g.fillOval(b,b,10,10);
        }
        if (face>1){
            g.fillOval(a,a,10,10);
            g.fillOval(c,c,10,10);
        }
        if (face==4 || face==5 || face==6){
            g.fillOval(c,a,10,10);
            g.fillOval(a,c,10,10);
        }
        if(face==6){
            g.fillOval(a,b,10,10);
            g.fillOval(c,b,10,10);
        }
    }
}