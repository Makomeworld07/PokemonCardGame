import java.util.HashMap;
import java.util.Scanner;
import ecs100.*;

/**
 * Code has been taken from my book manager code
 * Holds a collection of pokemon cards in a hashmap
 * Allows a user to add, find, print all from a menu
 * Prevents user from adding a duplicate
 * 
 * @author Korrimako
 */
public class Cards {
    // instance variables
    private HashMap<Integer, Card> pokeBall; // Declaring hashmap
    private int currCardId; // Store the current id of card being added
    private Card currCard; // Store the instance of the current card

    //private Scanner scanner;
    private int checkId;
    /**
     * Constructor for objects of class Books
     */
    public Cards() {
        // innitiliase instance variables
        pokeBall = new HashMap<Integer, Card>(); // Initiliase hashmap
        
        // Creating Cards
        Card c1 = new Card(1, "Pikachu", 3, 1, "pikachu.png");
        Card c2 = new Card(2, "Diglett", 2, 2, "diglett.png");
        
        // Add cards to collection/hashmap
        pokeBall.put(1, c1); 
        pokeBall.put(2, c2);
        
        this.currCardId = 2; // Stores the current
    }

    /**
     * Set cardId
     * Parameter int amount to increase card id by
     */
    public void setCardId() {
        this.currCardId += 1;
        
    }
    
     /**
     * Add card to hashmap
     * name, value, quant
     */
    public void addCard(String name,int value, int qty) {
        this.pokeBall.put(this.currCardId, new Card(this.currCardId, name, value, qty));
    }
    
    /**
     * Add pokemon card to the map and display the cover on canva
     * @param name, value, qty, img
     */
    public void addCard(String name, int value, int qty, String img) {
        this.setCardId();
        this.pokeBall.put(this.currCardId, new Card(this.currCardId, name, value, qty, img));
    }
    
    /**
     * Add card to collection
     */
    public void addCard() {
        final int MAX_QUANTITY = 99;
        int quantity;
        int value;

        String name = UI.askString("Name of pokemon card: ");
        if (this.findCard(name) == true) {
            UI.print("The card exists!");
        } else {
            do {
                quantity = UI.askInt("Quantity: ");
                if ((quantity > 0) && (quantity <= MAX_QUANTITY)) {
                    UI.println("Added");
                } else if (quantity > MAX_QUANTITY) {
                    UI.println("Must be less than 100");
                } else if (quantity < 1) {
                    UI.println("Must be greater than 0");
                } else {
                    UI.println("Must be a number!");
                }
            } while (0 > quantity || quantity > MAX_QUANTITY);
            
            value = UI.askInt("Enter the value of the card: ");
            if (value <= 0) {
                UI.println("Value must be greater than 0.");
                return;  // Exit method if invalid value
            }
            String imgFileName = UIFileChooser.open("Choose Image File: ");
            this.addCard(name, this.getValidNumber(), value, imgFileName);
            UI.println("The book is Added");
        }
    }

    public Integer AskInt(String prompt) {
        String input = UI.askString(prompt);
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Integer getValidNumber() {
        while (true) {
            Integer like = AskInt("What is the likes");
            if (like == null) {
                UI.println("Input was null or invalid. Please enter a number.");
            } else if (like > 0 && like < 100) {
                return like;
            } else {
                UI.println("Not a valid number. Must be between 1 and 99.");
            }
        }
    }

    public Card getCard() {
        return this.currCard;
    }

    /**
     * Find a card based on name
     * Sets the current card instance if found
     * return boolean false if card not found
     */
    public boolean findCard(String name) {
        // Search for card in hasmap
        for (int cardId: pokeBall.keySet()) {
            if (pokeBall.get(cardId).getName().toLowerCase().equals(name)) {
                currCard = pokeBall.get(cardId); // Set the current pokemon card
                pokeBall.get(cardId).displayCard(); // Shows card cover
                return true;
            } else {
                currCard = null;
            }
        }
        return false;
    }
    
    /**
     * Find card based on name 
     * If found will display details
     */
    public void findCard() {
        String cardName = UI.askString("Name of Pokemon Card: ");
        if (this.findCard(cardName.toLowerCase().trim())) {
            UI.println("Pokemon has been found");
            currCard = this.getCard();
            currCard.displayCard();
            UI.println(" Value: $" + currCard.getValue());
        } else {
            UI.println(" Pokemon isn't here");
        }
    }
    
    /**
     * Prints all cards out in a row
     * Value/$ is printed underneath
     */
    public void printAllCards() {
        int x = 50; 
        int y = 100;
        int spacing = 120; // space between each card
    
        for (Card card : this.pokeBall.values()) {
            UI.drawImage(card.getImage(), x, y, 100, 100);
            UI.drawString(card.getName(), x, y + 110);
            UI.drawString("Value :$" + card.getValue(), x, y + 120); // prints value 
            x += spacing; // space increases by each card
        }
    }
    
    /**
         * Hides pokemon card picture and value $
         */
        public void hideCards() {
            UI.clearText();
            UI.clearGraphics();
        }
    }
