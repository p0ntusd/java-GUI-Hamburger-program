/**
 * Abstract class for burgers. Contains a
 * list of sauces and a list of vegetables currently
 * on the burger.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package se.umu.cs.apjava.maxdonalds.burger;

import java.util.ArrayList;
import java.util.List;

/**
 * ----------------------- Burger -----------------------------
 */
public abstract class Burger {
    protected List<String> vegetables = new ArrayList<>();
    protected List<String> sauces = new ArrayList<>();

    /**
     * Returns the total cost for the burger +
     * sauce and vegetables.
     *
     * @return  Total price.
     */
    public abstract int getCost();

    /**
     * Will return a string with a description of
     * what the burger contains, and its price.
     *
     * @return      The string with description and price.
     */
    public abstract String getDescription();
}
