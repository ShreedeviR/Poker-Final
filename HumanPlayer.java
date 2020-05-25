import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * 
 * This class represents the human player or the user who is playing
 * the game through the console.
 *
 *  @author  Shreedevi Rao and Malavika Nair
 *  @version May 24, 2020
 *  @author  Period: TODO
 *  @author  Assignment: PokerFinalProject
 *
 *  @author  Sources: TODO
 */
public class HumanPlayer extends Player implements MouseListener
{
    private String name;

    private Chips[] chip;

    public ArrayList<Card> hand = new ArrayList<Card>();

    private int amount;

    private boolean myTurn;

/**
 * This constructs a human player from the player super class
 * @param name - the name of the person playing
 * @param card - Their first card in their hand
 * @param card1 - their second card in their hand
 * @param card2 - their third card in their hand
 * @param card3 - their fourth card in their hand
 * @param card4 - their fifth card in their hand
 */
    public HumanPlayer(
        String name,
       
        Card card,
        Card card1,
        Card card2,
        Card card3,
        Card card4 )
    {
        super( name,  card, card1, card2, card3, card4 );
        amount = 890;
    }

/**
 * Sets the name of the person to the String parameter
 * @param s the name it should be changed to
 * @return returns the new name of the person
 */
    public String addName( String s )
    {
        name = s;
        return name;
    }
 
    /**
     * Bets the amount of money from the player
     * @param bet is the amount to bet
     */
    public void bet (int bet)
    {
        amount = amount - bet;
        
    }
    


   


    public void mouseClicked( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    public void mouseEntered( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    public void mouseExited( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    public void mousePressed( MouseEvent e )
    {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseReleased( MouseEvent e )
    {
        if ( !myTurn )
        {
            return;
        }

    }

}