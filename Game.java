import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  shree
 *  @version May 20, 2020
 *  @author  Period: TODO
 *  @author  Assignment: PokerFinalProject
 *
 *  @author  Sources: TODO
 */
public class Game extends JFrame implements ActionListener
{  
   private static final Object SOUTH = null;
   private static Chips [] chip = new Chips [30];
   private static JTextField display;
   private static int ante;
   static Deck deck = new  Deck ();
   private static int pot = 0;
   private static Scanner input = new Scanner (System.in);
   private static BoardPanel board;
   private JButton raise;
   private JButton check;
   private JButton fold;
   private JButton next;
   private JPanel j;
  

   
   public static Chips [] fillChips ()
   {
  
       for (int count = 0; count < chip.length; count++)
       {
           if (count>= 0 && count < 8)
           {

               chip [count] = new Chips (5, Color.RED);
           }
           else if (count >=8 && count < 18 )
           {
               chip [count] = new Chips (10, Color.BLUE);
           }
           else if (count >=18 && count < 24)
           {
               chip [count] = new Chips (25, Color.GREEN);
           }
           else if (count >= 24 && count < 30)
           {
               chip [count] = new Chips (100, Color.BLACK);
           }
       }
       return chip;
   }

  /* private Player pickRandomPlayer (Player one, Player two, Player three, Player four)
   {
       Player [] play = {one, two, three, four};
       int x = (int)Math.random() * 4;
       return play [x];
       
       }
       */
   public Game ()
   {
      // PokerGame poker = new PokerGame();
       Color background = new Color (200,200,200);
       setResizable (false);
       j = new JPanel ();
       display = new JTextField (20);
       display.setBackground (background);
       display.setText( "Welcome to Poker!" );
       board = new BoardPanel();
       display.setEditable(false);
       j.add( display,BorderLayout.NORTH );
       j.add( board, BorderLayout.SOUTH);
       raise = new JButton("Raise");
       check = new JButton ("Check");
       fold = new JButton ("Fold");
       next = new JButton ("Press Next to Continue");
       fold.addActionListener (this); 
       raise.addActionListener (this);
       next.addActionListener(this);
       check.addActionListener(this);
       j.add( fold );
       j.add( check );
       j.add( next );
       j.setSize( new Dimension (300,300));
       j.add( raise );
       add (j);
       
       

       //c.add( button, BorderLayout.SOUTH );
       
       
   }
   


   public static void play ()
   {
      chip = fillChips ();
    
      ComputerPlayer player1 = new ComputerPlayer ("Kim", chip, null, null,null,null,null);
      HumanPlayer user = new HumanPlayer (null, chip, null, null, null, null, null);
      System.out.println ( (user.getMoneyMessage()));
   
          
      System.out.println ("What is your name?");
   
      String name = input.next();
      user.addName(name );
      System.out.println ("Hello " + name + "!");
      
      
      System.out.println ("How much do you want to bet?");
      ante = input.nextInt ();
      pot += ante;
      user.bet( ante );
      player1.bet( ante );
      deck.shuffle();
 
      for (int count = 0 ; count <= 4; count++)
      {
          user.setHand(  deck.deal(), count);
          player1.setHand(  deck.deal(), count );
      }

      ArrayList <Card> compHand = player1.getHand();
      ArrayList <Card> hand = user.getHand();
      
      for (int x = 0; x < hand.size(); x++)
      {
          System.out.println (hand.get( x).toString());
      }
    
      
      System.out.println ("Do you want to raise, check, or fold");
      String s = input.next();
      
      if (s.contains( "fold" ))
      {
          System.out.println (user.getLoseRoundMessage());
         
      }
      else if (s.contains( "raise" ))
      {
          System.out.println ("How much do you want to raise?");
          int bet = input.nextInt();
          pot += bet;
          user.bet( bet );
          board.repaint();
        
      }
      else if (!s.contains( "check" ))
      {
          System.out.println ("Please type in either check, raise, or fold");
      }
     
      
      

    }
   
  /* public void bettingRound ()
   {
       
       }
       
   }
   */
   
  
   
    
   
     
       

  public static void main (String [] args)
  {
      Game game = new Game();
      game.setTitle( "Poker Game" );
      game.setBounds (500,100,500,400);
      game.setVisible (true);
      
      play ();
     
      
  }

@Override
public void actionPerformed( ActionEvent arg0 )
{
   if (arg0.getSource() == fold)
   {
       display.setText( "You lost! Better luck next time!" );
       display.setBackground(Color.RED );
       
   }
   
   else if (arg0.getSource() == raise)
   {
       display.setBackground (Color.LIGHT_GRAY);
       int s = Integer.parseInt (JOptionPane.showInputDialog (null, "How much do you want to raise?"));
       display.setText ("You have raised $" + s);
       pot += s;
       
       
   }
   
   else if (arg0.getSource() == check)
   {
       display.setText("It is the computer's turn");
   }
   else if (arg0.getSource() == next)
   {
       String s = JOptionPane.showInputDialog(null, "What is your name");
       display.setText( "Hello " + s );
   }
   

   
    
}


  }



