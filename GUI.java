import ecs100.*;
/**
 * Code has been taken from my book manager 
 * GUI class
 * Allows to add, print and search for pokemon card
 * Will display details: Name and value
 *
 * @author Korimako
 */
public class GUI
{
    // field
    private Cards cards;     //declare cards instance
    private Card card;      //declare cards instance
    
    /**
     * Constructor for objects of class GUI
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
        //Set up mouse
        //UI.setMouseListener(this::doMouse);

    }
    
    /**
     * Select obj based on where the user clicks
    
    private void doMouse(String action, double x, double y)
    {
        if (action.equals("clicked")){
            // check the loc of the x and y against loc of the obj
            if ((x >= cards.getCard().getLeft()) && (x <= cards.getCard().getRight()) &&
                (y >= cards.getCard().getTop()) && (y <= cards.getCard().getBottom())){
                    cards.getCard().increaseLike();
                    UI.println("Added Likes: " + books.getBook().getLike());
                }
        }
    }
    */
    
    /**
     * main routine
     */
    public static void main(String[] args) {
        new GUI();
    }
    
    }


