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

    private ArrayList<Card> hand = new ArrayList<Card>();


    /**
     * This constructs a human player from the player super class
     * 
     * @param n
     *            - the name of the person playing
     * @param card
     *            - Their first card in their hand
     * @param d
     *            - their second card in their hand
     * @param card1
     *            - their third card in their hand
     * @param card2
     *            - their fourth card in their hand
     * @param card3
     *            - their fifth card in their hand
     */
    public Player(
        String n,

        Card c,
        Card d,
        Card card1,
        Card card2,
        Card card3 )
    {
        name = n;
        hand.add( c );
        hand.add( d );
        hand.add( card1 );
        hand.add( card2 );
        hand.add( card3 );

        amount = 890;
    }


    /**
     * 
     * Returns the amount of money in a message
     * 
     * @return the current amount of money the person has
     */
    public String getMoneyMessage()
    {
        return "You have $" + amount;
    }


    /**
     * 
     * Accessor method to get the player's name
     * 
     * @return the player's name
     */
    public String getName()
    {
        return name;
    }


    /**
     * 
     * Sets a card in the hand of the player
     * 
     * @param c
     *            the card that will be added to the hand
     * @param i
     *            the index of the arraylist where the card will be added
     */
    public void setHand( Card c, int i )
    {
        hand.set( i, c );

    }


    /**
     * 
     * Returns the player's hand
     * 
     * @return the player's current hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }


    /**
     * 
     * Helps to add a name to the player
     * 
     * @param s
     *            the name that will be set
     * @return the name of the player
     */
    public String addName( String s )
    {
        name = s;
        return name;
    }


    /**
     * Accesser method to return the amount that the player has
     * 
     * @return the amount of money the player has.
     */
    public int getAmount()
    {
        return amount;
    }


    /**
     * Introduces the player to the other players
     * 
     */
    public void introduce()
    {
        System.out.println( "Hello, my name is " + name );
    }


    /**
     * 
     * Bets the amount of money that is placed in the parameter
     * 
     * @param bet
     *            this is the amount of money bet
     */
    public void bet( int bet )
    {
        amount -= bet;
    }


    /**
     * 
     * Adds money to a player's amount when they have won
     * 
     * @param amount1
     *            how much money to add to player's amount
     */
    public void addMoney( int amount1 )
    {
        amount = amount + amount1;
    }


    /**
     * 
     * Message sent to a player when they win a round
     * 
     * @return the message when they win a round
     */
    public String getRoundWinMessage()
    {
        return "Yay! You won this round! You now have $" + amount;
    }


    /**
     *
     * Message sent to a player when they win a game
     * 
     * @return the message when they win a game
     */
    public String getWinGameMessage()
    {
        return "Congratulations! You have won the entire game!";
    }


    /**
     * 
     * Message sent to a player when they lose a game
     * 
     * @return the message when they lose a game
     */
    public String getLoseGameMessage()
    {
        return "You lost the game to computer. You have lost $"
            + ( 890 - amount );
    }


    /**
     * 
     * Message sent to a player when they lose a round
     * 
     * @return the message when they lose a round
     */
    public String getLoseRoundMessage()
    {
        return "You lost this round to the computer! Better luck next time. You now have $"
            + amount + " Let's start the next round.";
    }


    /**
     * 
     * Helps the player match the bet that was placed before
     * 
     * @param bet
     *            the amount of money the player has bet
     */
    public void match( int bet )
    {
        amount = amount - bet;

    }


    /**
     * 
     * Helps a player raise, this is when they choose to bet more than the ante
     * 
     * @param bet
     *            the amount they will bet
     */
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