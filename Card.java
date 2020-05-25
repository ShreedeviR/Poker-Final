import java.util.*;


/**
 * 
 * This class represents a single card in a deck or a hand
 *
 * @author Shreedevi and Malavika
 * @version Apr 27, 2020
 * @author Period: 1
 * @author Assignment: PokerFinalProject
 *
 * @author Sources:
 */
public class Card
{
    private char[] suit = { 's', 'c', 'h', 'd' };

    private char mySuit;

    private static String[] rank = { "A", "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "J", "Q", "K" };

    private String myRank;


    /**
     * This constructs a Card from a given suit and rank
     * 
     * @param s
     *            the suit, either s, c, d, or h of the card
     * @param r
     *            the rank of the card
     */
    public Card( char s, String r )
    {
        mySuit = s;
        myRank = r;

        int counter = 0;
        for ( int count = 0; count < suit.length; count++ )
        {
            if ( s == suit[count] )
            {
                counter++;
                break;
            }
        }

        if ( counter == 0 )
        {
            throw new IllegalArgumentException();
        }

        int number = 0;
        for ( int num = 0; num < suit.length; num++ )
        {
            if ( s == suit[num] )
            {
                number++;
                break;
            }
        }

        if ( number == 0 )
        {
            throw new IllegalArgumentException();
        }

    }


    /**
     * 
     * Returns the suit of this card
     * 
     * @return the suit of this card
     */
    public char getSuit()
    {
        return mySuit;
    }


    /**
     * 
     * Returns the rank of this card
     * 
     * @return the rank of this card
     */
    public String getRank()
    {

        return myRank;

    }


    /**
     * 
     * Gets the value of the card by its rank
     * 
     * @return the value of the card
     */
    public int getValue()
    {
        if ( myRank.equals( "A" ) )
        {
            return 1;
        }
        if ( myRank.equals( "J" ) )
        {
            return 11;
        }
        if ( myRank.equals( "Q" ) )
        {
            return 12;
        }
        if ( myRank.equals( "K" ) )
        {
            return 13;
        }
        if ( myRank.equals( "10" ) )
        {
            return 10;
        }
        else
        {
            Character num = myRank.charAt( 0 );
            return num.getNumericValue( num );

        }

    }


    /**
     * 
     * returns the rank as a String
     * 
     * @param __rank
     *            the index of the rank array
     * @return the rank as a String
     */
    public static String rankAsString( int __rank )
    {

        return rank[__rank];

    }


    /**
     * Returns the String of the card in a "rank" of "suit" format
     * 
     * @return the String of the card in a "rank" of "suit" format
     */
    public String toString()
    {
        String s = "";
        if ( myRank.equals( "1" ) )
        {
            s += "Ace";
        }
        else if ( myRank.equals( "K" ) )
        {
            s += "King";
        }
        else if ( myRank.equals( "J" ) )
        {
            s += "Jack";
        }
        else if ( myRank.equals( "Q" ) )
        {
            s += "Queen";
        }
        else
        {
            s += "" + myRank;
        }
        s += " of ";
        if ( mySuit == 's' )
        {
            s += "spades";
        }
        else if ( mySuit == 'c' )
        {
            s += "clubs";
        }
        else if ( mySuit == 'h' )
        {
            s += "heart";
        }
        else if ( mySuit == 'd' )
        {
            s += "diamond";
        }
        return s;
    }

}