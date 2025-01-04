package se.umu.cs.apjava.maxdonalds;

import se.umu.cs.apjava.maxdonalds.burger.BurgerBuilder;
import se.umu.cs.apjava.maxdonalds.burger.BurgerFactory;


public class BurgerOrderModel {
    private Order currentOrder=new Order();
    private boolean withMayo;
    private boolean withAioli;
    private boolean withLettuce;
    private boolean withTomato;
    private boolean withPickles;
    private boolean withKetchup;
    private BurgerBuilder burgerBuilder;
    private BurgerFactory burgerFactory;

    public BurgerOrderModel() {
        burgerBuilder = new BurgerBuilder();
        burgerFactory = new BurgerFactory();
    }

    String getOrderString() {
        StringBuilder stringBuilder=new StringBuilder();
        currentOrder.printOrder(stringBuilder);
        currentOrder=new Order();
        return stringBuilder.toString();
    }

    public void pickFavorite1() {
        currentOrder.addBurger(burgerFactory.makeFavoriteBurger1());
    }

    public void pickFavorite2() {
        currentOrder.addBurger(burgerFactory.makeFavoriteBurger2());
    }

    public void pickFavorite3() {
        currentOrder.addBurger(burgerFactory.makeFavoriteBurger3());
    }

    public void addBurgerToOrder() {

        if(withKetchup)
            burgerBuilder.addSauce("Ketchup");
        if(withMayo)
            burgerBuilder.addSauce("Mayo");
        if(withAioli)
            burgerBuilder.addSauce("Aioli");
        if(withLettuce)
            burgerBuilder.addVegetable("Lettuce");
        if(withTomato)
            burgerBuilder.addVegetable("Tomato");
        if(withPickles)
            burgerBuilder.addVegetable("Pickles");

        currentOrder.addBurger(burgerBuilder.build());
        burgerBuilder = new BurgerBuilder();
        resetBurger();
    }

    private void resetBurger() {
        withMayo=false;
        withAioli=false;
        withKetchup=false;
        withLettuce=false;
        withTomato=false;
        withPickles =false;
    }

    public void setWithKetchup(boolean selected) {
        withKetchup=selected;
    }

    public void setWithMayo(boolean selected) {
        withMayo=selected;
    }

    public void setWithAioli(boolean selected) {
        withAioli=selected;
    }

    public void setWithLettuce(boolean selected) {
        withLettuce=selected;
    }

    public void setWithTomato(boolean selected) {
        withTomato=selected;
    }

    public void setWithPickles(boolean selected) {
        withPickles =selected;
    }

    public void setType(String type) {
        burgerBuilder.setMeat(type);
    }
}
