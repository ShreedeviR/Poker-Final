/**
 * Description: A list of Card; used for a player's hand or a deck of cards
 * 
 * - cards - list of card; starts out empty Methods - shuffle() - randomly
 * shuffle all the card in the list - deal() - deal the 'top' card from the
 * hand/deck - add(card) - add card to the list of cards - __str__() - returns
 * string of all the cards in the hand like '[4d 10h As]'
 *
 * @author Malavika Nair and Shreedevi Rao
 * @version April 19, 2020
 * @author Period: 1
 * @author Assignment: Final Project
 *
 * @author Sources: None
 */
public class Deck
{

    Card [] deck;

    public Deck() 
    {
        deck = new Card [52];
    }


    public String deckToString()
    {
        String s = "[";
        for (Card c: deck )
        {
            if (deck.length == 1)
            {
                s = s + c.toString();
            }
            
            else 
            {
                s = s + ' ' + c.toString();
            }
            
        }
        s = s + "]";
             
            return s;
    }


   public void add (Card card1) 
   {
        for (int count = 0; count < deck.length; count++)
        {
            if (deck [count] == null)
            {
                deck[count] = card1;
                return;
            }
        }
                    
    }
   
   public Card[] getDeck ()
   {
       return deck;
   }


   public Card deal(Deck deck) 
   {
      deck.shuffle();
      return ;
   }


   public void shuffle() 
   {
         random.shuffle(this.cards)
    }
   
 /*  public Card [] getTwoCards ()
   {
       Card [] playerCards = new Card [2];
       int x = (int)Math.random() * 52;
       int c = (int)Math.random ()* 52;
       if (deck [x]!= null)
       {
           playerCards [0] = deck [x];
       }
    
       if (x != c)
       {
           playerCards[1] = deck [c];
           deck [c] = null;
       }
       
       else
       {
           playerCards [1] = deck [c + 5];
           deck [c + 5] = null;
       }
       deck [x] = null;
       
       
       return playerCards;
       
      
                      
   }
   */

}
