import java.awt.Color;

public class Game
{
   Chips [] chip = new Chips [30];
   private int bigBlind = 100;
   private int smallBlind = 50;
   Deck deck = new Deck ();
   private int pot = 0;
   public Chips [] fillChips ()
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

   private Player pickRandomPlayer (Player one, Player two, Player three, Player four)
   {
       Player [] play = {one, two, three, four};
       int x = (int)Math.random() * 4;
       return play [x];
       
       }
   
   public void play ()
    {
      chip = this.fillChips ();
      Card [] player1cards = deck.getTwoCards();
      Card [] player2cards = deck.getTwoCards();
      Card []player3cards = deck.getTwoCards();
      Card [] player4cards = deck.getTwoCards();
      
     
      Player player1 = new Player ("Bob", chip, player1cards[0], player1cards[1] );
      Player player2 = new Player ("Marley", chip ,player2cards[0], player2cards[1] );
      Player player3 = new Player ("Martha", chip, player3cards [0], player3cards [1]);
      Player player4 = new Player ("Kim", chip, player4cards [0], player4cards [1]);
      
      player1.bet( bigBlind );
      pot += bigBlind;
      player2.bet( smallBlind );
      pot += smallBlind;
      
      
      
      
      
     
   
       
        
      

    }
   
  
   }
    
   
     
       

 



