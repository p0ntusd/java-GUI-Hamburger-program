/**
 * Builder for Burgers, to make it easier
 * to create Burger objects.
 *
 * @Author Pontus Dahlkvist
 * @date 04/01 -25
 */

package se.umu.cs.apjava.maxdonalds.burger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ----------------------------- BurgerBuilder -----------------------
 */
public class BurgerBuilder {
    private Burger burger;
    private String meat;
    private List<String> vegetables;
    private List<String> sauces;

    /**
     * Constructor. Default meat is set to beef.
     */
    public BurgerBuilder() {
        vegetables = new ArrayList<>();
        sauces = new ArrayList<>();
        meat = "Beef";
    }

    /**
     * Sets the type of meat to beef, fish or chicken.
     * If something else is attempted to be set it will
     * print an error message.
     *
     * @param meat  The type of meat to be set.
     */
    public void setMeat(String meat) {
        if(!Objects.equals(meat, "Beef") && !Objects.equals(meat, "Chicken")
                && !Objects.equals(meat, "Fish")) {
            System.out.println("Available: Beef, Chicken or Fish.");
            return;
        }

        this.meat = meat;
    }

    /**
     * Adds a vegetable to the burger.
     *
     * @param vegetable     The vegetable.
     */
    public void addVegetable(String vegetable) {
        vegetables.add(vegetable);
    }

    /**
     * Adds a sauce to the burger.
     *
     * @param sauce The sauce.
     */
    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    /**
     * Creates a Burger object with all the ingrediants
     * decided by the other methods.
     *
     * @return The burger that is created.
     */
    public Burger build() {
        switch(meat) {
            case "Beef":
                burger = new BeefBurger();
                break;
            case "Chicken":
                burger = new ChickenBurger();
                break;
            case "Fish":
                burger = new FishBurger();
                break;
            default:
                System.out.println("Available: Beef, Chicken or Fish.");
                break;
        }

        for(int i = 0 ; i < vegetables.size() ; i++) {
            burger.vegetables.add(vegetables.get(i));
        }

        for(int i = 0 ; i < sauces.size() ; i++) {
            burger.sauces.add(sauces.get(i));
        }

        return burger;
    }
}
