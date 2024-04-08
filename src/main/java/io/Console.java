package io;

import models.KitSize;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
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

}
