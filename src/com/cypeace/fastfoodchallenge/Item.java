package com.cypeace.fastfoodchallenge;

public class Item {

    protected String type;
    protected String name;
    protected String size;
    protected double price;

    public Item(String type, String name, String size, double price) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        if (type.equalsIgnoreCase("drink")) {
            return getAdjustedPrice();
        }
        return price;
    }

    public double getAdjustedPrice() {
        double adjustedPrice = price;
        if (size.equalsIgnoreCase("large")) {
            adjustedPrice += 0.5;
        }
        return adjustedPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printItem() {
        System.out.printf("%s%n %s%n %s%n $%.2f%n", type, name, size, getAdjustedPrice());
    }
}

class Burger extends Item {

    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String type, String name, String size, double price) {
        super(type, name, size, price);
    }

    public void setExtra1(Item extra1) {
        this.extra1 = extra1;
    }

    public void setExtra2(Item extra2) {
        this.extra2 = extra2;
    }

    public void setExtra3(Item extra3) {
        this.extra3 = extra3;
    }

    public void addToppings(Item topping, int extraSlot) {
        switch (extraSlot) {
            case 1 -> {
                // Assign topping
                setExtra1(topping);
                // Adjust price
                super.setPrice(super.getPrice() + topping.getPrice());
        }
            case 2 -> {
                setExtra2(topping);
                super.setPrice(super.getPrice() + topping.getPrice());
            }
            case 3 -> {
                setExtra3(topping);
                super.setPrice(super.getPrice() + topping.getPrice());
            }
        }
    }

    @Override
    public void printItem() {
        super.printItem();
        try {
            if (extra1 != null) {
                System.out.print(" extra: ");
            }
            System.out.print(extra1.getName());
            System.out.print(", " + extra2.getName());
            System.out.print(", " + extra3.getName());
            System.out.println();
        } catch (Exception NullPointerException) {  }   // skip println
    }
}