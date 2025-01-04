package se.umu.cs.apjava.maxdonalds.burger;

public class BurgerFactory extends BurgerAbstractFactory {

    @Override
    public Burger makeFavoriteBurger1() {
        BurgerBuilder builder = new BurgerBuilder();
        builder.setMeat("Beef");
        builder.addVegetable("Tomato");
        builder.addVegetable("Lettuce");
        builder.addSauce("Ketchup");
        builder.addSauce("Mayo");
        return builder.build();
    }

    @Override
    public Burger makeFavoriteBurger2() {
        BurgerBuilder builder = new BurgerBuilder();
        builder.setMeat("Beef");
        builder.addSauce("Ketchup");
        builder.addSauce("Mayo");
        builder.addSauce("Aioli");
        return builder.build();
    }

    @Override
    public Burger makeFavoriteBurger3() {
        BurgerBuilder builder = new BurgerBuilder();
        builder.setMeat("Fish");
        return builder.build();
    }
}
