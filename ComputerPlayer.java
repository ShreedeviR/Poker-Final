import java.awt.Color;
import java.util.ArrayList;

public class ComputerPlayer extends Player
{
    private String name;
    private Chips [] chip = new Chips [30];    
    public ArrayList<Card> hand = new ArrayList<Card>();
    private int max;
    private int amount;
    private boolean hasMatched = false;
    private boolean hasRaised = false;
    private boolean hasRaisedMore = false;
    public ComputerPlayer (String name, Chips [] chip, Card card, Card card1, Card card2, Card card3, Card card4)
    {
        super (name, chip, card, card1 ,card2, card3, card4);
        for ( Chips ch : chip )

            if ( ch.getColor().equals( Color.RED ) )
            {
                amount += 5;
            }
            else if ( ch.getColor().equals( Color.BLUE ) )
            {
                amount += 10;
            }
            else if ( ch.getColor().equals( Color.GREEN ) )
            {
                amount += 25;
            }
            else if ( ch.getColor().equals( Color.BLACK ) )
            {
                amount += 100;
            }
    }
    
   public void gStrat(ArrayList<Card> hand, Deck deck)
   {
       Deck uDeck = new Deck( hand );
       Hands userhand = new Hands( uDeck );
       int size = hand.size();
       if (userhand.displayNoPrint().contains("pair of")) 
       {
           for (int count = 0; count < hand.size(); )
           {
               if (!userhand.displayNoPrint().contains(hand.get(count).getRank().toString() ))
               {
                   
                   hand.remove (count);
               }
               else
               {
                   count++;
               }
           }
           for (int x = 0; x < 3; x++)
           {
               hand.add(x,deck.deal());
           }
           System.out.println ("HAND SIZE PAIR OF " + hand.size());
           
           /*
           for (int x = 0; x <hand.size(); x++)
           {
               System.out.println (hand.get(x).toString());
           }
           */
           
       }
       else if (userhand.displayNoPrint().contains("three of a kind"))
       {
           for (int count = 0; count < hand.size(); )
           {
               if (!userhand.displayNoPrint().contains(hand.get(count).getRank().toString() ))
               {
                   hand.remove (count);
                   
               }
               else
               {
                   count++;
               }
               
//               for (int x = 0; x <hand.size(); x++)
//               {
//                   System.out.println (hand.get(x).toString());
//               }
           }
           for (int x = 0; x < 2; x++)
           {
               hand.add( x, deck.deal() );
           }
          // System.out.println ("HAND SIZE THREE" + hand.size());
           
       }
       else if (userhand.displayNoPrint().contains("two pair"))
       {
           for (int count = 0; count < hand.size(); )
           {
               if (!userhand.displayNoPrint().contains(hand.get(count).getRank()))
               {
                   hand.remove (count);
                   
               }
               else
               {
                   count++;
               }
               
           } 
           for (int x = 0; x <  1; x++)
           {
               hand.add( x, deck.deal() );
           }
           System.out.println ("HAND SIZE TWO PAir " + hand.size());
       }
       else if (userhand.displayNoPrint().contains("high card"))
       {
           int max = 0;
           int temp = hand.get( 0 ).getValue();
           for (int c = 0; c < hand.size(); c++)
           {
               max = hand.get( c ).getValue();
               if (temp > max)
               {
                   max = temp;
               }
           }
           for (int count = 0; count < hand.size(); )
           {
               if (hand.get( count ).getValue() != max)
               {
                   hand.remove (count);
                   
               }
               else
               {
                   count++;
               }
           }
           for (int x = 0; x < 4; x++)
           {
               hand.add( x, deck.deal() );
           }
          // System.out.println ("HAND SIZE HIGh" + hand.size());
           
       }
   }

   
       public boolean hasMatched ()
       {
           return hasMatched == true;
       }
       
       public boolean hasRaised()
       {
           return hasRaised == true;
       }
       public boolean hasRaisedMore ()
       {
           return hasRaisedMore = true;
       }
   
   
   public String betStrat( ArrayList<Card> hand, int bet, String s, int pot )
   {
       Deck uDeck = new Deck( hand );
       //System.out.println ("UDECK SIZE:" + uDeck.getDeck().size());
       Hands userhand = new Hands( uDeck );
       if ( userhand.displayNoPrint().contains( "pair of" )
           || userhand.displayNoPrint().contains( "two pair" )
           || userhand.displayNoPrint().contains( "three of a kind" ) )
       {
           match( bet );
           pot += bet;
           System.out.println( "The computer has matched" );
           hasMatched = true;
           return "match";
       }
       else if ( userhand.displayNoPrint().contains( "high straight" )
           || userhand.displayNoPrint().contains( "full house" ) )
       {
           raise( bet + 15 );
           pot = pot + bet + 15;
           System.out.println( "The computer has raised by $15" );
           hasRaised = true;
           return "raise";
       }
       else if ( userhand.displayNoPrint().contains( "straight flush" )
           || userhand.displayNoPrint().contains( "flush" )
           || userhand.displayNoPrint().contains( "four of a kind" ) )
       {
           raise( bet + 50 );
           pot = pot + bet + 50;
           System.out.println( "The computer has raised by $50" );
           hasRaisedMore = true;
           return "raise";
       }
       else if ( userhand.displayNoPrint().contains( "high card" ) )
       {
           max = 0;
           int temp = hand.get( 0 ).getValue();
           for (int c = 0; c < hand.size(); c++)
           {
               max = hand.get( c ).getValue();
               if (temp > max)
               {
                   max = temp;
               }
           }
           System.out.println (max);
           if ( ( max <= 4 ) )
           {
               System.out.println ("The computer has folded.");
               return "fold";
           }
           else if ( ( max >= 5 ) )
           {
               if ( s.contains( "check" ))
               {
                   System.out.println( "The computer has checked!" );
                   return "check";
               }
               else
               {
                   match( bet );
                   System.out.println( "The computer has matched" );
                   hasMatched = true;
                   return "match";

               }
           }
       }
       return s;
      

   }
      
   public void setMatched ()
   {
       hasMatched = false;
   }
   public void setRaised()
   {
       hasRaised = false;
   }
   public void setRaisedMore()
   {
       hasRaisedMore = false;
   }
   
  

}