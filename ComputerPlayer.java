
public class ComputerPlayer extends Player
{
    private String name;
    private Chips [] chip;
    private Card card;
    private Card card1;
    public ComputerPlayer (String name, Chips [] chip, Card card, Card card1)
    {
        super (name, chip, card, card1);
    }
    
    GUI gui = new GUI ();
    

}
