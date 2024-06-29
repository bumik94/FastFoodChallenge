package com.cypeace.fastfoodchallenge;

public class Main {
    public static void main(String[] args) {

        Item cola = new Item("drink", "cola", "regular", 1.50);
        Burger burger = new Burger("burger", "Hamburger", "regular", 5.0);
        Item fries = new Item("side", "fries", "regular", 2.0);

        MealOrder order = new MealOrder(fries, cola, burger);
        order.addToppings();
        order.printItemizedList();
    }
}
