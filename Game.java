import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;

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
public class Game
{  
   static Chips [] chip = new Chips [30];
   private static int ante;
   static Deck deck = new  Deck ();
   private static int pot = 0;
   private static Scanner input = new Scanner (System.in);
  

   
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
   
   public static void play ()
    {
      chip = fillChips ();
    
       ComputerPlayer player1 = new ComputerPlayer ("Kim", chip, null, null,null,null,null);
      HumanPlayer user = new HumanPlayer (null, chip, null, null, null, null, null);
      System.out.println (user.getMoneyMessage());
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
      //System.out.println (deck.deal().toString());
      ArrayList <Card> compHand = player1.getHand();
      ArrayList <Card> hand = user.getHand();
      for (int x = 0; x < hand.size(); x++)
      {
          System.out.println (hand.get( x).toString());
      }
    
      boolean marker = false;
      while (marker = false)
      {
      System.out.println ("Do you want to raise, check, or fold");
      String s = input.next();
      if (s.contains( "fold" ))
      {
          user.getLoseMessage();
          marker = true;
      }
      else if (s.contains( "raise" ))
      {
          System.out.println ("How much do you want to raise?");
          int bet = input.nextInt();
          pot += bet;
          user.bet( bet );
          marker = true;
      }
      else if (s.contains ("check"))
      {
          marker = true;
      }
      else if (!s.contains( "check" ))
      {
          System.out.println ("Please type in either check, raise, or fold");
      }}
       

    }
   
  /* public void bettingRound ()
   {
       
       }
       
   }
   */
   
  
   
    
   
     
       

  public static void main (String [] args)
  {
      BoardPanel hello = new BoardPanel ();
      
      play();
      
  }
  }



