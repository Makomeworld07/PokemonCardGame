import ecs100.*;
/**
 * Code has been taken from my books manager.
 * Support class for Cards.
 * A card contains an id, name, quantity, value, image.
 *
 * @author Korimako
 *
 */

public class Card {
    // fields
    private int id; // Each card assigned an id
    private String name; // Name of each card
    private int quantity; // Quant of each card
    private int value; // $ value
    private String image; // Image of card
    static final String DEFAULT_IMAGE = "card.png"; // Set a default image

    private int locX = 100; // Image x start position
    private int locY = 100; // Image y start position
      
    private static final double WIDTH = 100;
    private static final double HEIGHT = 100;

    /**
     * Constructor for obj class card.
     * This constructor sets default image to obj.
     * @param key, nm, auth, qty, img.
     */
    public Card(int key, String nm, int val, int qty, String img)
    {
        id = key;
        name = nm;
        value = val;
        quantity = qty;
        if(img == null){
            this.image = DEFAULT_IMAGE; // Add default img if user clicks cancel
        }else{
            this.image = img;
        }
    }

    /**
     * Sets default image to obj.
     */
    public Card(int key, String nm, int qty, int val)
    {
      this(key, nm, qty, val, DEFAULT_IMAGE);
    }

    /**
     * Display pokemon card on GUI.
     */
    public void displayCard() {
  
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }

    /**
     * Getter for img location X.
     */
    public int getLeft(){
        return locX;
    }

    /**
     * Getter for img location Y.
     */
    public int getTop(){
    return locY;
    }

    public double getRight(){
        double locaX = (double) locX;
        return locaX+WIDTH;
    }

    public double getBottom(){
        double locaY = (double) locY;
        return locaY+HEIGHT;
    }

    /**
     * Getter for id.
     * @return integer id number of card.
     *
     */
    public int getId(){
        return this.id;
    }

    /**
     * Getter for name.
     * @return String card name.
     *
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for value of card.
     * @return int value of pokemon card.
     *
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Getter for quantity.
     * @return integer with quantity of the obj card.
     *
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * Getter for image.
     */
    public String getImage() {
        return this.image;
    }
}