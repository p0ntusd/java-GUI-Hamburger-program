/**
 * A FishBurger that extends the abstract class
 * Burger.
 *
 * @Author Pontus Dahlkvist
 * @date 04/01 -25
 */

package se.umu.cs.apjava.maxdonalds.burger;

public class FishBurger extends Burger {

    public FishBurger() {

    }

    /**
     * Returns the total cost for the burger +
     * sauce and vegetables.
     *
     * @return  Total price.
     */
    @Override
    public int getCost() {
        return 13 + (2 * sauces.size()) + (3 * vegetables.size());
    }

    /**
     * Will return a string with a description of
     * what the burger contains, and its price.
     *
     * @return      The string with description and price.
     */
    @Override
    public String getDescription() {
        return "Meat: Fish. Vegetables: " + String.join(", ", vegetables)
                + ". Sauce: "
                + String.join(", ", sauces) + ". Price: " + getCost() + " million dollars.";
    }
}
