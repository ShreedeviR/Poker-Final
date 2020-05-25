import java.awt.Color;
import java.util.ArrayList;


/**
 * 
 * This class represents a Computer Player that will play against the user In
 * this game we have three objects of this class playing.
 *
 * @author Shreedevi Rao and Malavika Nair
 * @version May 24, 2020
 * @author Period: 1
 * @author Assignment: PokerFinalProject
 *
 * @author Sources: none
 */
public class ComputerPlayer extends Player
{
    private String name;

    private Chips[] chip = new Chips[30];

    public ArrayList<Card> hand = new ArrayList<Card>();

    private int max;

    private int amount;

    private boolean hasMatched = false;

    private boolean hasRaised = false;

    private boolean hasRaisedMore = false;

    private boolean hasFolded = false;


    /**
     * This constructs a computer player from the player super class
     * 
     * @param name
     *            - the name of the person playing
     * @param card
     *            - Their first card in their hand
     * @param card1
     *            - their second card in their hand
     * @param card2
     *            - their third card in their hand
     * @param card3
     *            - their fourth card in their hand
     * @param card4
     *            - their fifth card in their hand
     */
    public ComputerPlayer(
        String name,
        Card card,
        Card card1,
        Card card2,
        Card card3,
        Card card4 )
    {
        super( name, card, card1, card2, card3, card4 );
        this.name = name;
        amount = 890;
    }


    /**
     * 
     * This models the strategy the computer will use to remove and add new
     * cards to their hand
     * 
     * @param hand
     *            this is the current hand of the computer
     * @param deck
     *            this is the deck that is made up of five cards
     */
    public void gStrat( ArrayList<Card> hand, Deck deck )
    {
        Deck uDeck = new Deck( hand );
        Hands userhand = new Hands( uDeck );
        int size = hand.size();
        if ( userhand.displayNoPrint().contains( "pair of" ) )
        {
            for ( int count = 0; count < hand.size(); )
            {
                // System.out.println (hand.get( count ).getRank());
                if ( !userhand.displayNoPrint()
                    .contains( hand.get( count ).getRank().toString() ) )
                {

                    hand.remove( count );
                }
                else
                {
                    count++;
                }
            }
            for ( int x = 0; x < 3; x++ )
            {
                hand.add( x, deck.deal() );
            }
            // System.out.println ("HAND SIZE PAIR OF " + hand.size());

            /*
             * for (int x = 0; x <hand.size(); x++) { System.out.println
             * (hand.get(x).toString()); }
             */

        }
        else if ( userhand.displayNoPrint().contains( "three of a kind" ) )
        {
            for ( int count = 0; count < hand.size(); )
            {
                if ( !userhand.displayNoPrint()
                    .contains( hand.get( count ).getRank().toString() ) )
                {
                    hand.remove( count );

                }
                else
                {
                    count++;
                }

                // for (int x = 0; x <hand.size(); x++)
                // {
                // System.out.println (hand.get(x).toString());
                // }
            }
            for ( int x = 0; x < 2; x++ )
            {
                hand.add( x, deck.deal() );
            }
            // System.out.println ("HAND SIZE THREE" + hand.size());

        }
        else if ( userhand.displayNoPrint().contains( "two pair" ) )
        {
            for ( int count = 0; count < hand.size(); )
            {
                if ( !userhand.displayNoPrint()
                    .contains( hand.get( count ).getRank() ) )
                {
                    hand.remove( count );

                }
                else
                {
                    count++;
                }

            }
            for ( int x = 0; x < 1; x++ )
            {
                hand.add( x, deck.deal() );
            }
            // System.out.println ("HAND SIZE TWO PAir " + hand.size());
        }
        else if ( userhand.displayNoPrint().contains( "high card" ) )
        {
            int max = 0;
            int temp = hand.get( 0 ).getValue();
            for ( int c = 0; c < hand.size(); c++ )
            {
                max = hand.get( c ).getValue();
                if ( temp > max )
                {
                    max = temp;
                }
            }
            for ( int count = 0; count < hand.size(); )
            {
                if ( hand.get( count ).getValue() != max )
                {
                    hand.remove( count );

                }
                else
                {
                    count++;
                }
            }
            for ( int x = 0; x < 4; x++ )
            {
                hand.add( x, deck.deal() );
            }
            // System.out.println ("HAND SIZE HIGh" + hand.size());

        }
    }


    /**
     * This tells if the computer has matched or not
     * 
     * @return true if the computer has matched, false if it did not
     */
    public boolean hasMatched()
    {
        return hasMatched == true;
    }


    /**
     * This tells if the computer has raised 15 dollars or not
     * 
     * @return true if the computer has raised 15 dollars, false if it did not
     */
    public boolean hasRaised()
    {
        return hasRaised == true;
    }


    /**
     * This tells if the computer has raised by 50 dollars or not
     * 
     * @return true if the computer has raised by 50 dollars , false if it did
     *         not
     */
    public boolean hasRaisedMore()
    {
        return hasRaisedMore = true;
    }


    /**
     * 
     * This is the betting strategy of the computer player. It matches, raises,
     * folds, or checks based on its hand
     * 
     * @param hand
     *            the hand that it currently has
     * @param bet
     *            the ante, or the amount that the computer will match to
     * @param s
     *            the string of what the player before it did
     * @param pot
     *            the total amount of money bet
     * @return a string representing what the computer player did
     */
    public String betStrat( ArrayList<Card> hand, int bet, String s, int pot )
    {
        Deck uDeck = new Deck( hand );
        // System.out.println ("UDECK SIZE:" + uDeck.getDeck().size());
        Hands userhand = new Hands( uDeck );
        if ( userhand.displayNoPrint().contains( "pair of" )
            || userhand.displayNoPrint().contains( "two pair" )
            || userhand.displayNoPrint().contains( "three of a kind" ) )
        {
            match( bet );
            pot += bet;

            System.out.println( name + " has matched" );
            hasMatched = true;
            return "match";
        }
        else if ( userhand.displayNoPrint().contains( "high straight" )
            || userhand.displayNoPrint().contains( "full house" ) )
        {
            raise( bet + 15 );
            pot = pot + bet + 15;
            System.out.println( name + " has raised by $15" );
            hasRaised = true;
            return "raise";
        }
        else if ( userhand.displayNoPrint().contains( "straight flush" )
            || userhand.displayNoPrint().contains( "flush" )
            || userhand.displayNoPrint().contains( "four of a kind" ) )
        {
            raise( bet + 50 );
            pot = pot + bet + 50;
            System.out.println( name + " has raised by $50" );
            hasRaisedMore = true;
            return "raise";
        }
        else if ( userhand.displayNoPrint().contains( "high card" ) )
        {
            max = 0;
            int temp = hand.get( 0 ).getValue();
            for ( int c = 0; c < hand.size(); c++ )
            {
                max = hand.get( c ).getValue();
                if ( temp > max )
                {
                    max = temp;
                }
            }
            // System.out.println (max);
            if ( ( max <= 4 ) )
            {
                System.out.println( name + " has folded." );
                hasFolded = true;
                return "fold";
            }
            else if ( ( max >= 5 ) )
            {
                if ( s.contains( "check" ) )
                {
                    System.out.println( name + " has checked!" );
                    return "check";
                }
                else
                {
                    match( bet );
                    System.out.println( name + " has matched" );
                    hasMatched = true;
                    return "match";

                }
            }
        }
        return s;

    }


    /**
     * 
     * Returns true if the computer has folded
     * 
     * @return true if the computer has folded
     */
    public boolean getFolded()
    {
        return hasFolded;
    }


    /**
     * 
     * Sets the boolean variable asFolded to false so that it can reset to the
     * next round
     */
    public void setFolded()
    {
        hasFolded = false;
    }


    /**
     * 
     * Sets the hasMatched boolean field to false to reset for the next round
     */
    public void setMatched()
    {
        hasMatched = false;
    }


    /**
     * 
     * Sets the hasRaised boolean field to false to reset for the next round
     */
    public void setRaised()
    {
        hasRaised = false;
    }


    /**
     * 
     * Sets the hasRaisedMore boolean field to false to reset for the next round
     */
    public void setRaisedMore()
    {
        hasRaisedMore = false;
    }

}