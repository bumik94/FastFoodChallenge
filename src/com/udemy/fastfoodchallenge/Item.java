package com.udemy.fastfoodchallenge;

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

    public Item(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
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

    public void setSize(String size) {
        this.size = size;
        setPrice(getAdjustedPrice());
    }

    public void printItem() {
        if (type != null) { System.out.println(type); }
        if (name != null) { System.out.println("\t" + name); }
        if (size != null) { System.out.println("\t" + size); }
        if (price != 0) { System.out.println("\t$" + price); }
    }
}

class Burger extends Item {

    private Item extra1;
    private Item extra2;
    private Item extra3;

    public Burger(String type, String name, String size, double price) {
        super(type, name, size, price);
    }

    public Burger(String type, String name, double price) {
        super(type, name, price);
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
            // When no extra is assigned, NullPointerException is raised
            // and calling procedure is skipped
            if (extra1 != null) {
                System.out.print("\textra: ");
            }
            System.out.print(extra1.getName());
            System.out.print(", " + extra2.getName());
            System.out.print(", " + extra3.getName());
        } catch (Exception NullPointerException) {  }   // skip print
        System.out.println();
    }
}