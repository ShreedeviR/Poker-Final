import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame

{
    

    private static int ante;
    private static Deck deck = new Deck();
    private static int pot = 0;
    private static Scanner input = new Scanner( System.in );
    private static int rounds;
    private static ComputerPlayer player1;
    private static ComputerPlayer player2;
    private static ComputerPlayer player3;
    private static HumanPlayer user;
    private static Integer round;
    private static boolean folded = false;
    private static int temp = 0;
    private static ArrayList <Card> compHand;
    private static ArrayList <Card> compHand1;
    private static ArrayList <Card> compHand2;
    private static ArrayList <Card> hand;
    private static Deck uDeck;
    private static Deck cDeck;
    private static Deck cDeck1;
    private static Deck cDeck2;
    private static Hands userhand;
    private static Hands cHand1;
    private static Hands cHand2;
    private static Hands cHand;
    private static String playerBetDecision;

//    public static Chips[] fillChips()
//    {
//
//        for ( int count = 0; count < chip.length; count++ )
//        {
//            if ( count >= 0 && count < 8 )
//            {
//
//                chip[count] = new Chips( 5, Color.RED );
//            }
//            else if ( count >= 8 && count < 18 )
//            {
//                chip[count] = new Chips( 10, Color.BLUE );
//            }
//            else if ( count >= 18 && count < 24 )
//            {
//                chip[count] = new Chips( 25, Color.GREEN );
//            }
//            else if ( count >= 24 && count < 30 )
//            {
//                chip[count] = new Chips( 100, Color.BLACK );
//            }
//        }
//        return chip;
//    }
    public PokerGame ()
    {
       
        player1 = new ComputerPlayer( "Karen",
            null,
            null,
            null,
            null,
            null );
        player2 = new ComputerPlayer( "Chad",
            null,
            null,
            null,
            null,
            null );
        player3 = new ComputerPlayer( "Lisa",
            null,
            null,
            null,
            null,
            null );
        user = new HumanPlayer( null,
            null,
            null,
            null,
            null,
            null );
       // System.out.println (player1.getName());
       // System.out.println (player2.getName());
       // System.out.println (player3.getName());
        
    }
    public static void play()
    {
      
        
        System.out.println( user.getMoneyMessage() );
        System.out.println( "How much do you want to bet?" );
        ante = input.nextInt();
        while( ante > user.getAmount() )
        {
            System.out.println(
                "You do not have that much money. Enter a valid amount." );
            ante = input.nextInt ();
        }
       
        pot += ante;
        user.makeBet(ante);
        System.out.println (user.getMoneyMessage());
        //System.out.println(player1.getMoneyMessage());
        player1.bet( ante );
        player2.bet( ante );
        player3.bet( ante );
        pot+= ante;
        pot+= ante;
        pot += ante;
        //System.out.pintln(player1.getMoneyMessage());
        deck.shuffle();

        for ( int count = 0; count <= 4; count++ )
        {
            user.setHand( deck.deal(), count );
            player1.setHand( deck.deal(), count );
            player2.setHand( deck.deal(), count );
            player3.setHand( deck.deal(), count );
        }
       
        compHand = player1.getHand();
        compHand1 = player2.getHand();
        compHand2 = player3.getHand();
        hand = user.getHand();
        
        cDeck1 = new Deck (compHand1);
        cDeck2 = new Deck (compHand2);
        uDeck = new Deck( hand );
        cDeck = new Deck( compHand );
        userhand = new Hands( uDeck );
        cHand = new Hands( cDeck );
        cHand1 = new Hands (cDeck1);
        cHand2 = new Hands (cDeck2);
        userhand.display();

        userhand.displayAll();

       
    }



public static void drawRound() {
    if (folded)
    {
        return;
    }
    System.out.println("Would you like to remove cards?");
    String s = input.next();
    if (s.contains( "yes" )) 
    {
        System.out.println("How many cards would you like to exchange?");
        int numCards = input.nextInt();
        //ArrayList<Card> toRemove = new ArrayList<Card>();
        for (int i = 0; i <numCards; i++) {
            System.out.println("Please enter the card you would like to remove."
                + " Enter the Rank of the card followed by the suit of the card.");
            String str = input.nextLine();
             str = input.nextLine();
          //  System.out.println("This is the string" + str);
            for (int k = 0; k< user.getHand().size();) {
                if (str.equals( user.getHand().get(k).toString() ))
                {
                  user.getHand().remove(k);   
                  //System.out.println("Hi");
                }
                else 
                {
                    k++;
                }
            }
             
        }//System.out.println("Hi 3");
        
        for (int i = 0; i <numCards; i++) {
            user.getHand().add( i, deck.deal() );
        }
        
        System.out.println ("These are your new cards:");
        for (int x = 0; x < user.getHand().size(); x++)
        { 
         System.out.println (user.getHand().get( x).toString());
        }
           

    }
    player1.gStrat( compHand, deck);
    player2.gStrat( compHand1, cDeck1 );
    player3.gStrat(compHand2, cDeck2);
    }
public static Hands findWinner ()
{
    Hands [] playList = {userhand, cHand, cHand1, cHand2};
    Hands winner = userhand;
    for (int count = 1; count < playList.length; count ++)
    {
        if (winner.compareTo (playList [count]) == -1)
        {
            winner = playList [count];
        }
    }
    return winner;
    
    
}
public static String getRoundWinner()
{
 
    Hands winner = findWinner();
    if (winner.equals( userhand ))
    {
        user.addMoney( pot );
        pot = 0;
        return user.getRoundWinMessage();
    }
    else if (winner.equals( cHand ) )
    {
      
        player1.addMoney( pot );
        pot = 0;
       // System.out.println (user.getMoneyMessage());
        return player1.getName() + " has won this round. " + user.getLoseRoundMessage();
    }
    else if (winner.equals( cHand1 ) )
    {
     
        player2.addMoney( pot );
        pot = 0;
       // System.out.println (user.getMoneyMessage());
        return player2.getName() + " has won this round. " + user.getLoseRoundMessage();
    }
    else if (winner.equals( cHand2 ) )
    {
       
        player3.addMoney( pot );
        pot = 0;
     
        return player3.getName() + " has won this round. " + user.getLoseRoundMessage();
    }
   
   
    else
    {
        return "";
    }
}
public static String getGameWinner()
{
    int [] money = {user.getAmount(), player1.getAmount(), player2.getAmount(), player3.getAmount()};
    int winner = user.getAmount();
    for (int count = 1; count < money.length; count++)
    {
        if (winner < money [count])
        {
            winner = money [count];
        }
        
    }
    if (winner == user.getAmount())
    {
        pot = 0;
        return user.getWinGameMessage();  
    }
    if (winner == player1.getAmount())
    {
        pot = 0; 
        return player1.getName() + " has won the game!" + user.getLoseGameMessage();            
    }
    if (winner == player2.getAmount())
    {
        pot = 0; 
        return player2.getName() + " has won the game!" + user.getLoseGameMessage();            
    }
    if (winner == player3.getAmount())
    {
        pot = 0; 
        return player3.getName() + " has won the game!" + user.getLoseGameMessage();            
    }

    else
    {
        return "";
    }
}

public static void reset ()
{
    for (int count = 0; count < user.getHand().size(); count++)
    {
        user.setHand( null, count );
        player1.setHand(null, count);
        player2.setHand( null, count );
        player3.setHand( null, count );
    }
    folded = false;
    player1.setFolded();
    player2.setFolded();
    player3.setFolded();
    deck = new Deck();
    pot = 0;
    
}
public static void bettinground()
{
    if (folded)
    {
        return;
    }
    System.out.println( "Do you want to raise, check, match or fold?" );
    String string = input.next();
    while ( !string.equals( "fold" ) && !string.equals( "raise" )
        && !string.equals( "check" )&& !string.equals("match") )
    {
        System.out.println(
            "Please type in either check, match, raise, or fold" );
        string = input.next();
    }
    if ( string.contains( "fold" ) )
    {
        System.out.println( user.getLoseRoundMessage() );
        folded = true;
        
        playerBetDecision = "fold";
        return;

    }
    else if ( string.contains( "raise" ) )
    {
        System.out.println( "How much do you want to raise?" );
        int bet = input.nextInt() + ante;
        pot += bet;
        //ante = bet;
        user.raise( bet  );
        folded = false;
        playerBetDecision = "raise";

    }
    else if ( string.contains( "match" ) )
    {
        pot += ante;
        user.match( ante );
        //System.out.println (user.getMoneyMessage());
        folded = false;
        playerBetDecision = "match";
    }
    else if ( string.contains( "check" ) )
    {
        folded = false;
        System.out.println( "It's now the computer's turn" );
        playerBetDecision = "check";

    }
   // System.out.println (compHand.size());  

}
public static void computerBettingRound ()
{
    String s = "";
    String str = "";
    ComputerPlayer [] comp = {player1, player2, player3};
 
    for (int count = 0; count < comp.length; count++)
    {
        if (comp [count].getFolded())
        {
            comp [count] = null;
        }
    }
    if (comp [0] != null)
    {
        s = comp[0].betStrat (compHand, ante, playerBetDecision, pot);
    }
    else 
    {
        s = playerBetDecision;
    }
    if (comp [0] == null && comp [1] == null && comp [2] == null)
    {
        folded = true;
        user.addMoney (pot);
        pot = 0;
        reset ();
    }
    ArrayList <Card > h = compHand1;
    for (int x = 1; x < comp.length; x ++)
    {
        if (x == 2)
        {
            h = compHand2;
        }
        if (comp [x] != null)
        {
          str = comp [x].betStrat( h, ante, s , pot);
           
        }
       
        s = str;
    }
    
    
    if (player1.hasMatched())
    {
        pot += ante;
        player1.setMatched();
    }
    else if (player1.hasRaised())
    {
        pot += ante + 15;
        player1.setRaised();
    }
    else if (player1.hasRaisedMore())
    {
        pot += ante + 50;
        player1.setRaisedMore();
    }
    
    if (player2.hasMatched())
    {
        pot += ante;
        player2.setMatched();
    }
    else if (player2.hasRaised())
    {
        pot += ante + 15;
        player2.setRaised();
    }
    else if (player2.hasRaisedMore())
    {
        pot += ante + 50;
        player2.setRaisedMore();
    }
    
    if (player3.hasMatched())
    {
        pot += ante;
        player3.setMatched();
    }
    else if (player3.hasRaised())
    {
        pot += ante + 15;
        player3.setRaised();
    }
    else if (player3.hasRaisedMore())
    {
        pot += ante + 50;
        player3.setRaisedMore();
    }
    
}

public static void main( String[] args )
{
    PokerGame poker = new PokerGame();
    System.out.println(
        "How many rounds do you want to play? Please input an integer under 5." );
    round = input.nextInt();
    System.out.println( "What is your name?" );

    String name = input.next();

    System.out.println( "Hello " + name + "!" );
    for ( int count = 0; count < round; count++ )
    {
        temp++;
        play();
        bettinground();
        computerBettingRound();
        drawRound();
        bettinground();
        computerBettingRound();
        System.out.println("These are " + player1.getName() + "'s cards");
        cHand.display();
        cHand.displayAll();
        System.out.println("These are " + player2.getName() + "'s cards");
        cHand1.display();
        cHand1.displayAll();
        System.out.println("These are " + player3.getName() + "'s cards");
        cHand2.display();
        cHand2.displayAll();
        
        System.out.println( getRoundWinner() );
        //System.out.println(player1.getAmount());
        reset();
        if (temp < round)
        {
            System.out.println ("It is time for round " + (temp + 1));
        }

    }
    
    System.out.println (getGameWinner());

}

}