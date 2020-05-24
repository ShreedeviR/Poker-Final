import java.util.*;


public class Hands
{
    private ArrayList<Card> hand = new ArrayList<Card>();

    private Card[] cards;

    private int[] value;

    private int[] ranks;


    public Hands( Deck d )
    {
        value = new int[6];
        // hand = player.hand() + community cards//
        // CHANGE
        cards = new Card[5];
        for ( int x = 0; x < 5; x++ )
        {
            //System.out.println (d.getDeck().size());
            cards[x] = d.getDeck().get( x );
        }
        ranks = new int[14];
        for ( int x = 0; x <= 13; x++ )
        {
            ranks[x] = 0; // zero the contents of the array
        }
        for ( int x = 0; x <= 4; x++ )
        {
            ranks[cards[x].getValue()]++; // increment rank array at the index of each card's rank
                                          
                                          
        }
        int sameCards = 1; // we know there will be at least one card of any rank
                           

        int groupRank = 0;

        for ( int x = 13; x >= 1; x-- ) // loop going from 13 to 1

        {

            if ( ranks[x] > sameCards ) // If more cards of rank x than same Cards
                                        

            {

                sameCards = ranks[x]; // set sameCards to that number of cards

                groupRank = x; // and record the rank of the cards

            }
        }

        sameCards = 1;

        int sameCards2 = 1;// initialze to 1
        int largeGroupRank = 0;

        int smallGroupRank = 0;
        for ( int x = 13; x >= 1; x-- ) // x is rank of cards, ranks[x] is
                                        // number of cards of that rank

        {

            if ( ranks[x] > sameCards )

            {

                if ( sameCards == 1 ) // if sameCards was not assigned to
                                      // already

                {

                    largeGroupRank = x;
                }

                else
                {

                    sameCards2 = sameCards; // if sameCards was assigned to,
                                            // write data from

                    smallGroupRank = x; // top group to low group

                }

                sameCards = ranks[x]; // update sameCards to new greatest
                                      // sameCards value in ranks
                largeGroupRank = x;


            }
            else if ( ranks[x] > sameCards2 )

            {

                sameCards2 = ranks[x];

                smallGroupRank = x;

            }

        }
        boolean flush = true; // assume there is a flush
        for ( int x = 0; x < 4; x++ )
        {
            if ( cards[x].getSuit() != cards[x + 1].getSuit() )

                flush = false;
        }
        int topStraightValue = 0;

        boolean straight = false; // assume no straight

        for ( int x = 1; x <= 9; x++ ) // can't have straight with lowest value of more than 10
                                       

        {

            if ( ranks[x] == 1 && ranks[x + 1] == 1 && ranks[x + 2] == 1
                && ranks[x + 3] == 1 && ranks[x + 4] == 1 )

            {

                straight = true;

                topStraightValue = x + 4; // 4 above bottom value

                break;

            }

        }

        if ( ranks[10] == 1 && ranks[11] == 1 && ranks[12] == 1
            && ranks[13] == 1 && ranks[1] == 1 ) // ace high

        {

            straight = true;

            topStraightValue = 14; // higher than king

        }
        int[] orderedRanks = new int[5];

        int index = 0;

        if ( ranks[1] == 1 ) // if ace, run this before because ace is highest
                             // card

        {

            orderedRanks[index] = 14; // record an ace as 14 instead of one, as
                                      // its the highest card

            index++; // increment position

        }
        for ( int x = 13; x >= 2; x-- )

        {

            if ( ranks[x] == 1 ) // we have already written code to handle the
                                 // case of their being two cards of the same rank
                                 

            {

                orderedRanks[index] = x;

                index++;

            }

        }
        // start hand evaluation

        if ( sameCards == 1 )
        { // if we have no pair...

            value[0] = 1; // this is the lowest type of hand, so it gets the
                          // lowest value

            value[1] = orderedRanks[0]; // the first determining factor is the
                                        // highest card,

            value[2] = orderedRanks[1]; // then the next highest card,

            value[3] = orderedRanks[2]; // and so on

            value[4] = orderedRanks[3];

            value[5] = orderedRanks[4];

        }

        if ( sameCards == 2 && sameCards2 == 1 ) // if 1 pair

        {

            value[0] = 2; // pair ranked higher than high card

            value[1] = largeGroupRank; // rank of pair

            value[2] = orderedRanks[0]; // next highest cards.

            value[3] = orderedRanks[1];

            value[4] = orderedRanks[2];

        }

        if ( sameCards == 2 && sameCards2 == 2 ) // two pair

        {

            value[0] = 3;

            value[1] = largeGroupRank > smallGroupRank ? largeGroupRank
                : smallGroupRank; // rank of greater pair

            value[2] = largeGroupRank < smallGroupRank ? largeGroupRank
                : smallGroupRank; // rank of smaller pair

            value[3] = orderedRanks[0]; // extra card

        }

        if ( sameCards == 3 && sameCards2 != 2 ) // three of a kind (not full
                                                 // house)

        {

            value[0] = 4;

            value[1] = largeGroupRank;

            value[2] = orderedRanks[0];

            value[3] = orderedRanks[1];

        }

        if ( straight )

        {

            value[0] = 5;

            value[1] = topStraightValue; // if we have two straights, the one
                                         // with the highest top cards wins

        }

        if ( flush )

        {

            value[0] = 6;

            value[1] = orderedRanks[0]; // tie determined by ranks of cards

            value[2] = orderedRanks[1];

            value[3] = orderedRanks[2];

            value[4] = orderedRanks[3];

            value[5] = orderedRanks[4];

        }

        if ( sameCards == 3 && sameCards2 == 2 ) // full house

        {

            value[0] = 7;

            value[1] = largeGroupRank;

            value[2] = smallGroupRank;

        }

        if ( sameCards == 4 ) // four of a kind

        {

            value[0] = 8;

            value[1] = largeGroupRank;

            value[2] = orderedRanks[0];

        }

        if ( straight && flush ) // straight flush

        {

            value[0] = 9;

            value[1] = topStraightValue;

        }

    }


    public String display()

    {

        String s;

        switch ( value[0] )

        {

            case 1:

                s = "high card";

                break;

            case 2:

                s = "pair of " + Card.rankAsString( value[1] ) + "\'s";

                break;

            case 3:

                s = "two pair " + Card.rankAsString( value[1] ) + " "
                    + Card.rankAsString( value[2] );

                break;

            case 4:

                s = "three of a kind " + Card.rankAsString( value[1] ) + "\'s";

                break;

            case 5:

                s = Card.rankAsString( value[1] ) + " high straight";

                break;

            case 6:

                s = "flush";

                break;

            case 7:

                s = "full house " + Card.rankAsString( value[1] ) + " over "
                    + Card.rankAsString( value[2] );

                break;

            case 8:

                s = "four of a kind " + Card.rankAsString( value[1] );

                break;

            case 9:

                s = "straight flush " + Card.rankAsString( value[1] )
                    + " high";

                break;

            default:

                s = "error in Hand.display: value[0] contains invalid value";

        }

        s = "               " + s; // this just moves the output over a little
                                   // in the console so its easier to see when
                                   // viewing the output

        System.out.println( s );
        return s;

    }

    public String displayNoPrint()

    {

        String s;

        switch ( value[0] )

        {

            case 1:

                s = "high card";

                break;

            case 2:

                s = "pair of " + Card.rankAsString( value[1] ) + "\'s";

                break;

            case 3:

                s = "two pair " + Card.rankAsString( value[1] ) + " "
                    + Card.rankAsString( value[2] );

                break;

            case 4:

                s = "three of a kind " + Card.rankAsString( value[1] ) + "\'s";

                break;

            case 5:

                s = Card.rankAsString( value[1] ) + " high straight";

                break;

            case 6:

                s = "flush";

                break;

            case 7:

                s = "full house " + Card.rankAsString( value[1] ) + " over "
                    + Card.rankAsString( value[2] );

                break;

            case 8:

                s = "four of a kind " + Card.rankAsString( value[1] );

                break;

            case 9:

                s = "straight flush " + Card.rankAsString( value[1] )
                    + " high";

                break;

            default:

                s = "error in Hand.display: value[0] contains invalid value";

        }

        s = "               " + s; // this just moves the output over a little
                                   // in the console so its easier to see when
                                   // viewing the output

       return s;

    }

    void displayAll()

    {
        for ( int x = 0; x < 5; x++ )
        {
            System.out.println( cards[x] );
        } // calls cards[x].toString()
    }


    public int getRank( Hands that )
    {
        String s = that.displayNoPrint();
        if ( s.contains( "high card" ) )
        {
            return 1;
        }
        else if ( s.contains( "pair of" ) )
        {
            return 2;
        }
        else if ( s.contains( "two pair" ) )
        {
            return 2;
        }
        else if ( s.contains( "three of a kind" ) )
        {
            return 3;
        }
        else if ( s.contains( "high straight" ) )
        {
            return 4;
        }
        else if ( s.contains( "flush" ) )
        {
            return 5;
        }
        else if ( s.contains( "full house" ) )
        {
            return 6;
        }
        else if ( s.contains( "four of a kind" ) )
        {
            return 7;
        }
        else if ( s.contains( "straight flush" ) )
        {
            return 8;
        }
        return 0;
    }

    public int [] getValue()
    {
        return value;
    }
    public int compareTo( Hands that )
    {
        if (getRank(this)>getRank(that)){
            
            return 1;

        }else if (getRank(that)>getRank(this)) {
            return -1;
        }
        else {
            if (this.getValue()[1] > that.getValue()[1]) {
                return 1;
            }
            else {
                return -1;
            }
        }
         // if hands are equal
    }


    
    public static void main(String[] args) {
        
               for (int i=0; i<1; i++)
        
               {
        
               Deck deck= new Deck();
               deck.shuffle();
        
               Hands hand= new Hands(deck);
        
               Hands hand2= new Hands(deck);
        
               hand.display();
        
               hand.displayAll();
        
               hand2.display();
        
               hand2.displayAll();

               System.out.println(hand.compareTo(hand2));

               }
        
           }


}