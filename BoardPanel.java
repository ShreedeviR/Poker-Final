import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardPanel extends JPanel
{
    private ArrayList <Card> hand;
    
    private int amount;
    public BoardPanel()
    {
        hand = new ArrayList <Card>();
        
        setPreferredSize( new Dimension( 450, 300) );
        setBackground( Color.WHITE );
        amount = 890;
    }
    
    public void paintComponent (Graphics g)
    {
       super.paintComponent( g );
       g.drawString( "You have this much money: $" + amount, 15, 145 );
       g.drawString("player1 has this much money", 15 , 130 );
       g.drawString ("Your cards", 285, 100);
       
       g.drawRect(250, 120, 40, 60 );   //draws the cards
       
       g.drawRect(300, 120, 40, 60 );
       g.drawRect(350, 120, 40, 60 );
       g.drawRect(275, 200, 40, 60);
       g.drawRect(325,200, 40, 60 );
       
       g.fillOval(70, 25, 30, 30 ); //draws the chips
       g.setColor (Color.BLUE);
       g.fillOval( 140, 25, 30, 30 );
       g.setColor( Color.GREEN );
       g.fillOval( 210, 25, 30, 30 );
       g.setColor( Color.RED );
       g.fillOval( 280, 25, 30, 30 );
      
      
    }
    
    public ArrayList <Card> getHand ()
    {
        return hand;
    }
    
    public void setAmount (int amount1)
    {
        amount= amount1;
        
    }
    
    
   
    

}
