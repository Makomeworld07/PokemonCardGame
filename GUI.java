import ecs100.*;
/**
 * GUI class.
 * Code has been taken from my book manager. 
 * Allows to add, print all, search, hide pokemon card.
 * Will display details: Name and value.
 *
 * @author Korimako
 */
public class GUI{
    // field
    private Cards cards;     //declare cards instance
    private Card card;      //declare cards instance

    /**
     * Constructor for objects of class GUI.
     */
    public GUI()
    {
        // initialise instance variables
        cards = new Cards();           //instantiate the cards
        
        // Set up GUI
        UI.initialise();
        UI.addButton("Print All", cards::printAllCards);
        UI.addButton("Add", cards::addCard);
        UI.addButton("Find", cards::findCard);
        UI.addButton("Hide",cards::hideCards);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Main routine.
     */
    public static void main(String[] args){
        new GUI();
    }
    }