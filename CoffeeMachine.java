

import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int disCups;
    private int money;

    private CoffeeMachine() {

        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disCups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {

        CoffeeMachine coffeeMax = new CoffeeMachine();
        coffeeMax.machineActions();
    }

    private static String getUserAction() {

        String userAction = new Scanner(System.in).next();
        return userAction;
    }

    public void machineActions() {

        boolean systemOn = true;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = getUserAction();
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillResources();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    status();
                    break;
                case "exit":
                    System.out.println("The coffee machine is off. Bye!");
                    systemOn = false;
                    break;
                default:
                    System.out.println("Sorry, wrong action. Try again.");
                    machineActions();
                    break;
            }
        } while (systemOn);
    }

    public void fillResources() {

        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(getUserAction());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(getUserAction());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += Integer.parseInt(getUserAction());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disCups += Integer.parseInt(getUserAction());
        System.out.println("Done!");
    }

    public void buyCoffee() {

        int waterCup = 0;
        int milkCup = 0;
        int coffeeBeansCup = 0;
        int moneyCup = 0;
        boolean stopCheckingResources = false;

        System.out.println("What do you want to buy? " +
                "1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = getUserAction();

        switch (buy) {
            case "1":
                waterCup = 250;
                coffeeBeansCup = 16;
                moneyCup = 4;
                break;
            case "2":
                waterCup = 350;
                milkCup = 75;
                coffeeBeansCup = 20;
                moneyCup = 7;
                break;
            case "3":
                waterCup = 200;
                milkCup = 100;
                coffeeBeansCup = 12;
                moneyCup = 6;
                break;
            case "back":
                machineActions();
                stopCheckingResources = true;
                break;
            default:
                System.out.println("Sorry, wrong action. Try again.");
                stopCheckingResources = true;
                break;
        }

        if (stopCheckingResources) {
            // Stops checking resources
        } else if (water < waterCup) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkCup) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans < coffeeBeansCup) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterCup;
            milk -= milkCup;
            coffeeBeans -= coffeeBeansCup;
            disCups--;
            money += moneyCup;
        }
    }

    public void takeMoney() {

        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void status() {

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
