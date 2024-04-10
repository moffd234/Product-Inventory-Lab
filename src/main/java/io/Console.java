package io;

import models.BottleSize;
import models.KitSize;
import services.KitsService;
import services.VodkaService;

import java.util.Scanner;

public class Console {
    private KitsService kitsService = new KitsService(); // (1)
    private VodkaService vodkaService = new VodkaService();
    Scanner scanner = new Scanner(System.in);
    public static void printWelcome(){
        System.out.println(
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************");
    }

    public static void printMainMenu(){
        System.out.println("1 - Add new product\n" +
                "2 - Read all products\n" +
                "3 - Update products\n" +
                "4 - Delete products\n" +
                "5 - Get reports\n" +
                "6 - Exit");
    }

    public void print(String val, Object... args) {
        System.out.format(val, args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return scanner.nextLine();
    }

    public Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }

    public KitSize getKitInput() {
        KitSize kitSize = null;
        while (kitSize == null) {
            try {
                String kitSizeInput = getStringInput("Enter kit size (SMALL, MEDIUM, LARGE): ");
                kitSize = KitSize.valueOf(kitSizeInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid kit size. Please enter one of SMALL, MEDIUM, or LARGE.");
            }
        }
        return kitSize;
    }

    public BottleSize getBottleSize() {
        BottleSize bottleSize = null;
        while (bottleSize == null) {
            try {
                String bottleSizeInput = getStringInput("Enter bottle size (PINT, FIFTH, LITER, HANDLE): ");
                bottleSize = BottleSize.valueOf(bottleSizeInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid bottle size. Please enter one of PINT, FIFTH, LITER, or HANDLE.");
            }
        }
        return bottleSize;
    }

    public void handleAddItems(){
        String input = getStringInput("Are you adding kits or vodka?").toLowerCase();
        while(!input.equals("kits") && !input.equals("vodka")){
            input = getStringInput("Are you adding kits or vodka?").toLowerCase();
        }
        if(input.equals("kits")){
            int numToAdd = getIntegerInput("How many would you like to add?");
            for(int i = 0; i < numToAdd; i++) {
                addKit();
            }
        }
        else{
            int numToAdd = getIntegerInput("How many would you like to add?");
            for(int i = 0; i < numToAdd; i++) {
                addVodka();
            }
        }
    }

    public void addKit(){
        int kitNum = getIntegerInput("Enter kit number");
        double price = getDoubleInput("Enter kit price");
        int quantity = getIntegerInput("Enter quantity");
        String team = getStringInput("Enter team");
        String brand = getStringInput("Enter the brand");
        String player = getStringInput("Enter the player name");
        KitSize kitSize = getKitInput();
        kitsService.create(kitNum, quantity, price, team, brand, player, kitSize);
    }

    public void addVodka(){
        String brand = getStringInput("Enter brand");
        int proof = getIntegerInput("Enter proof");
        BottleSize bottleSize = getBottleSize();
        double price = getDoubleInput("Enter Vodka price");
        int quantity = getIntegerInput("Enter quantity");
        vodkaService.create(brand, proof, bottleSize, price, quantity);
    }

    public void handleReadItems(){

        String input = getStringInput("Are you reading kits, vodka, or both?").toLowerCase();
        while(!input.equals("kits") && !input.equals("vodka") && !input.equals("both")){
            input = getStringInput("Are you reading kits, vodka, or both??").toLowerCase();
        }
        if(input.equals("kits")){
            System.out.println(kitsService.toString());
        }
        else if(input.equals("vodka")){
            System.out.println(vodkaService.toString());
        }
        else{
            System.out.println(kitsService.toString());
            System.out.println(vodkaService.toString());
        }
    }

}
