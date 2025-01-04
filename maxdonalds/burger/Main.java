package se.umu.cs.apjava.maxdonalds.burger;

public class Main {
    public static void main(String[] args) {

        BurgerBuilder builder = new BurgerBuilder();
        builder.setMeat("Beef");
        builder.addVegetable("Tomato");
        builder.addVegetable("Lettuce");
        builder.addSauce("Ketchup");
        builder.addSauce("Mayo");
        Burger burger = builder.build();
        System.out.println(burger.getDescription());
    }

}
