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

    Chips[] playerChips;

    public ArrayList<Card> hand = new ArrayList<Card>();


    public Player(
        String n,
        Chips[] play,
        Card c,
        Card d,
        Card card1,
        Card card2,
        Card card3 )
    {
        name = n;
        playerChips = play;
        hand.add( c );
        hand.add( d );
        hand.add( card1 );
        hand.add( card2 );
        hand.add( card3 );

        for ( Chips ch : play )
        {
            if ( ch.getColor().equals( RED ) )
            {
                amount += 5;
            }
            else if ( ch.getColor().equals( BLUE ) )
            {
                amount += 10;
            }
            else if ( ch.getColor().equals( GREEN ) )
            {
                amount += 25;
            }
            else if ( ch.getColor().equals( BLACK ) )
            {
                amount += 100;
            }

        }
    }

    public String getMoneyMessage()
    {
        return "You have $" + amount;
    }
    public String getName()
    {
        return name;
    }


    public void setHand( Card c, int i )
    {
        hand.set( i, c );

    }


    public ArrayList<Card> getHand()
    {
        return hand;
    }


    public String addName( String s )
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
        System.out.println( "Hello, my name is" + name );
    }


    public void bet( int bet )
    {
        amount -= bet;
    }


    public void earn( int money )
    {
        amount += money;
    }


    public void addMoney( int amount1 )
    {
        amount = amount + amount1;
    }

    public String getRoundWinMessage()
    {
        return "Yay! You won this round! You now have $" + amount;
    }
    public String getWinGameMessage()
    {
        return "Congratulations! You have won the entire game!";
    }
    public String getLoseGameMessage()
    {
        return "You lost the game to computer. You have lost $" + (890 - amount);
    }
    public String getLoseRoundMessage ()
    {
        return "You lost this round to the computer! Better luck next time. You now have $" + amount +
                        " Let's start the next round.";
    }

    public void match( int bet )
    {
        amount = amount - bet;

    }


    public void raise( int bet )
    {
        if ( this.amount < bet )
        {
            System.out.println( "You do not have enough money." );
        }
        else
        {
            amount = amount - bet;
        }
    }

}