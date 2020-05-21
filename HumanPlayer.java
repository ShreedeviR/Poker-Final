import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HumanPlayer extends Player implements MouseListener
{
    private String name;
    private Chips [] chip;
    private Card card;
    private Card card1;
    private int amount;
    private boolean myTurn;
    public HumanPlayer (String name, Chips [] chip, Card card, Card card1)
    {
        super (name, chip, card, card1);
        for (Chips ch: chip)
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
    
    public String addName (String s)
    {
        name = s;
        return name;
    }
    
    public String getTurn ()
    {
        myTurn = true;
        return "Your turn";
    }
    
    public String getWinMessage()
    {
        return "You won!";
    }
    
    public String getMoneyMessage()
    {
        return "You have $" + amount;
    }

    public void makeBet (int c)
    {
        super.bet(c);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
        if (!myTurn)
        {
            return;
        }
        
    }
    
    
    
    
    

}
