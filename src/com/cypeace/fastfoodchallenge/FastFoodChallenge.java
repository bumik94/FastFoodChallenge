package com.cypeace.fastfoodchallenge;

public class FastFoodChallenge {
    public static void main(String[] args) {

        Item cola = new Item("drink", "cola", 1.50);
        Burger burger = new Burger("burger", "Hamburger", 5.0);
        Item fries = new Item("side", "fries", 2.0);

        MealOrder order = new MealOrder(fries, cola, burger);
        order.setDrinkSize();
        order.addToppings();
        order.printItemizedList();
        order.printTotal();
    }
}
