/**
 * Abstract factory to make specific type of
 * burgers.
 *
 * @author Pontus Dahlkvist
 * @date 04/01 -25
 */

package se.umu.cs.apjava.maxdonalds.burger;

public abstract class BurgerAbstractFactory {
    public abstract Burger makeFavoriteBurger1();
    public abstract Burger makeFavoriteBurger2();
    public abstract Burger makeFavoriteBurger3();
}
