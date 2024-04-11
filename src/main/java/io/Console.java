package io;

import models.BottleSize;
import models.Kit;
import models.KitSize;
import models.Vodka;
import services.KitsService;
import services.VodkaService;

import java.util.Scanner;

public class Console {
    private final KitsService kitsService = new KitsService(); // (1)
    private final VodkaService vodkaService = new VodkaService();
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
            return Double.parseDouble(stringInput);
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            return Long.parseLong(stringInput);
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
        String input = getItemTypeInput();
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

        String input = getItemTypeInput("both");

        if(input.equals("kits")){
            System.out.println(kitsService);
        }
        else if(input.equals("vodka")){
            System.out.println(vodkaService);
        }
        else{
            System.out.println(kitsService);
            System.out.println(vodkaService);
        }
    }

    public void handleUpdateItems(){
        String input = getItemTypeInput();

        if(input.equals("kits")){
            int id = getIntegerInput("Which ID did you want to update?");
            if(kitsService.find(id) != null) {
                int kitNum = getIntegerInput("Enter kit number");
                double price = getDoubleInput("Enter kit price");
                int quantity = getIntegerInput("Enter quantity");
                String team = getStringInput("Enter team");
                String brand = getStringInput("Enter the brand");
                String player = getStringInput("Enter the player name");
                KitSize kitSize = getKitInput();
                kitsService.create(kitNum, quantity, price, team, brand, player, kitSize, id);
            }
            else{
                System.out.println("There is no kit item with that id");
            }
        }
        if(input.equals("vodka")){
            int id = getIntegerInput("Which ID did you want to update?");
            if(vodkaService.find(id) != null) {
                String brand = getStringInput("Enter brand");
                int proof = getIntegerInput("Enter proof");
                BottleSize bottleSize = getBottleSize();
                double price = getDoubleInput("Enter Vodka price");
                int quantity = getIntegerInput("Enter quantity");
                vodkaService.create(brand, proof, bottleSize, price, quantity, id);
                System.out.println(vodkaService.toString());
            }
            else{
                System.out.println("There is no vodka item with that id");
            }
        }
    }
    public void handelDelete(){
        String input = getItemTypeInput();
        int id = getIntegerInput("Enter the ID of the item you would like to delete");
        if(input.equals("kits")){
            deleteKitItem(id);
            System.out.println(kitsService);
        }
        else{
            deleteVodkaItem(id);
            System.out.println(vodkaService);
        }
    }

    private void deleteKitItem(int id) {
        if(kitsService.delete(id)){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed: No item with that ID");
        }
    }

    private void deleteVodkaItem(int id) {
        if(vodkaService.delete(id)){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed: No item with that ID");
        }
    }

    public String getItemTypeInput(){
        String input = getStringInput("Are you updating kits, or vodka").toLowerCase();
        while(!input.equals("kits") && !input.equals("vodka")){
            input = getStringInput("Are you updating kits, or vodka").toLowerCase();
        }
        return input;
    }

    public String getItemTypeInput(String str){
        String input = getStringInput("Are you updating kits, vodka or " + str).toLowerCase();
        while(!input.equals("kits") && !input.equals("vodka") && !input.equals(str)){
            input = getStringInput("Are you updating kits, or vodka").toLowerCase();
        }
        return input;
    }

    public void handelReports(){
        String input = getItemTypeInput("both");
        populateInventory();
        if(input.equals("kits")){
            getKitReport();
        }
        else if(input.equals("vodka")){
            getVodkaReport();
        }
        else{
            getKitReport();
            getVodkaReport();
        }
    }

    public void getKitReport(){
        System.out.println("----- KIT REPORT -----");
        for (Kit kit : kitsService.getKitsInventory()) {
            System.out.println("Kit ID: " + kit.getId());
            System.out.println("Kit Number: " + kit.getKitNum());
            System.out.println("Quantity: " + kit.getQuantity());
            System.out.println("Price: $" + kit.getPrice());
            System.out.println("Team: " + kit.getTeam());
            System.out.println("Brand: " + kit.getBrand());
            System.out.println("Player: " + kit.getPlayer());
            System.out.println("Size: " + kit.getSize());
            System.out.println("-----------------------------");
        }
    }

    public void getVodkaReport(){
        System.out.println("----- Vodka Inventory Report -----");
        for (Vodka vodka : vodkaService.getInventory()) {
            System.out.println("ID: " + vodka.getId());
            System.out.println("Brand: " + vodka.getBrand());
            System.out.println("Proof: " + vodka.getProof());
            System.out.println("Bottle Size: " + vodka.getBottleSize());
            System.out.println("Price: $" + vodka.getPrice());
            System.out.println("Quantity: " + vodka.getQuantity());
            System.out.println("-----------------------------");
        }
    }

    private void populateInventory(){
        populateInventoryKits();
        populateInventoryVodka();
    }

    public void populateInventoryKits(){
        for(int i = 0; i < 10; i++){
            kitsService.create(i + 1, i * 10, i * 20,
                    "Barcelona", "Adidas", "Silva", KitSize.MEDIUM);
        }
    }
    public void populateInventoryVodka(){
        for(int i = 0; i < 10; i++){
            vodkaService.create("Smirnoff", i * 18, BottleSize.HANDLE, i * 15, 100);
        }
    }
}
