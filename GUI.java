import ecs100.*;
/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Cards card; // declare cards instance
    private Card cards; // declare card instance

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cards = new Cards(); // intaniate the cards object
        UI.initiliase(); // Creates the GUI
        UI.addButton("print all", cards::printAll); // calls the printall method
        UI.addButton("Add", this::addCard); // calls 
        UI.addButton("Find", this::findCard);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * Finds cards based on name
     * Prints out name
     */
    public void findCard() {
        String cardName = UI.askString("Name of pokemon");
        if (card.findCard(cardName.toLowerCase())) {
            UI.println("found card");
            card = cards.getCard();
            
        }
    }
        
    }
   
