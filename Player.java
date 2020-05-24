import java.awt.Color;
import java.util.*;

public class Player
{
    private static final Object RED = Color.RED;
    private static final Object BLUE = Color.BLUE;
    private static final Object GREEN = Color.GREEN;
    private static final Object BLACK = Color.BLACK;
    private String name;
    private int amount;
    Chips [] playerChips;
    BoardPanel board;
    public ArrayList<Card> hand = new ArrayList<Card>();
    
    public Player (String n, Chips [] play, Card c, Card d, Card car1, Card card2, Card card3)
    {
        name = n;
        playerChips = play;
        hand.add( c );
        hand.add( d );
        hand.add( card2 );
        hand.add( card3 );
        hand.add( car1 );
     
        
        for (Chips ch: play)
        {
            if (ch.getColor().equals( Color.RED ))
            {
                amount += 5;
            }
            else if (ch.getColor().equals( Color.BLUE ))
            {
                amount += 10;
            }
            else if (ch.getColor().equals( Color.GREEN))
            {
                amount += 25;
            }
            else if (ch.getColor().equals( Color.BLACK ))
            {
                amount += 100;
            }
            
                
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setHand (Card c, int x)
    {
        hand.set(x,c);
    }
    
    public ArrayList <Card> getHand ()
    {
        return hand;
    }
   
    public String addName (String s)
    {
        name = s;
        return name;
    }
    public int getAmount()
    {
        return amount;
    }
    public void introduce()
    {
        System.out.println ("Hello, my name is" + name);
    }
    
    public void bet (int bet)
    {
       amount = amount - bet;
    }
    
    public void earn (int money)
    {
        amount += money;
    }
    public void addMoney (int amount1)
    {
        amount += amount1;
    }
    public void match( int bet )
    {
        this.bet( bet );

    }


    public void raise( int bet )
    {
        if ( this.amount < bet )
        {
            System.out.println( "You do not have enough money." );
        }
        else
        {
            this.bet( bet );
        }
    }

}
    

