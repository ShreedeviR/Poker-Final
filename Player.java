import java.awt.Color;

public class Player
{
    private static final Object RED = Color.RED;
    private static final Object BLUE = Color.BLUE;
    private static final Object GREEN = Color.GREEN;
    private static final Object BLACK = Color.BLACK;
    private String name;
    private int amount;
    Chips [] playerChips;
    Card card;
    Card card1;
    
    public Player (String n, Chips [] play, Card c, Card ca)
    {
        name = n;
        playerChips = play;
        card = c;
        card1 = ca;
        
        for (Chips ch: play)
        {
            if (ch.getColor().equals( RED ))
            {
                amount += 5;
            }
            else if (ch.getColor().equals( BLUE ))
            {
                amount += 10;
            }
            else if (ch.getColor().equals( GREEN))
            {
                amount += 25;
            }
            else if (ch.getColor().equals( BLACK ))
            {
                amount += 100;
            }
            
                
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    /*public Card addCard ()
    {
        
    }
    */
   
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
       amount =- bet;
    }
    
    public void earn (int money)
    {
        amount += money;
    }
    public void addMoney (int amount1)
    {
        amount += amount1;
    }
    

}
