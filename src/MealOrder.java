import java.util.Scanner;

public class MealOrder {

    private Item side;
    private Item drink;
    private Burger burger;

    static Item cheese = new Item("topping", "cheese", "portion", 1.5);
    static Item salad = new Item("topping", "salad", "portion", 1.0);
    static Item sauce = new Item("topping", "sauce", "portion", 0.5);
    static Item chilli = new Item("topping", "chilli", "portion", 2.0);
    static Item[] toppings = {cheese, salad, sauce, chilli};
    static Scanner s = new Scanner(System.in);

    public MealOrder(Item side, Item drink, Burger burger) {
        this.side = side;
        this.drink = drink;
        this.burger = burger;
    }

    public Item getSide() {
        return side;
    }

    public Item getDrink() {
        return drink;
    }

    public Burger getBurger() {
        return burger;
    }

    public void printItemizedList() {
        getSide().printItem();
        getDrink().printItem();
        getBurger().printItem();
    }

    public void addToppings() {
        int selection;
        for (int extraSlot = 1; extraSlot <= 3; extraSlot++) {
            // Print menu
            int enumerator = 1;
            System.out.printf("Would you like any extra? %d/3 %n",  extraSlot);
            for (Item topping : toppings) {
                System.out.printf("%d. %s $%.2f %n", enumerator++, topping.getName(), topping.getPrice());
            };
            System.out.printf("%d. none %n", enumerator);

            // input function
            while (true) {
                try {
                    selection = Integer.parseInt(s.nextLine());
                    if (selection > 0 && selection <= 5) { break; }
                }
                catch (Exception e) { continue; }
            }
            // Break out of the loop if "none" is selected
            if (selection == 5) { break; }
            // Add selected topping to corresponding extra
            getBurger().addToppings(toppings[--selection], extraSlot);
        }
    }

    public void setDrinkSize() {
        for(;;) {
            try {
                System.out.println("""
                        What size of the drink would you like?
                        1. regular
                        2. large
                        """);
                // input
                int selection;
            } catch (Exception e) {}
        }
    }
}
