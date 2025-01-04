/**
 * A BeefBurger that extends the abstract class
 * Burger.
 *
 * @Author Pontus Dahlkvist
 * @date 04/01 -25
 */

package se.umu.cs.apjava.maxdonalds.burger;

    public class BeefBurger extends Burger {

        public BeefBurger() {

        }

        /**
         * Returns the total cost for the burger +
         * sauce and vegetables.
         *
         * @return  Total price.
         */
        @Override
        public int getCost() {
            return 11 + (2 * sauces.size()) + (3 * vegetables.size());
        }

        /**
         * Will return a string with a description of
         * what the burger contains, and its price.
         *
         * @return      The string with description and price.
         */
        @Override
        public String getDescription() {
            return "Meat: Beef. Vegetables: " + String.join(", ", vegetables)
                    + ". Sauce: "
                    + String.join(", ", sauces) + ". Price: " + getCost() + " million dollars.";
        }
}