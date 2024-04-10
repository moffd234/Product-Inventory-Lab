import io.Console;
import models.BottleSize;
import models.KitSize;
import services.KitsService;
import services.VodkaService;

import java.util.Scanner;

public class App {
    private KitsService kitsService = new KitsService(); // (1)
    private VodkaService vodkaService = new VodkaService();
    private Console console = new Console();

    public static void main(String... args){
        App application = new App();
        application.init();
    }

    public void init(){
        Console.printWelcome();
        handleInput();
    }

    public void handleInput(){
        Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;
        while(!exitFlag){
            Console.printMainMenu();
            int input = scanner.nextInt();
            switch (input) {
                case (1):
                    add();
                    break;
                case(2):
                    System.out.println("Read");
                    break;
                case(3):
                    System.out.println("Update");
                    break;
                case(4):
                    System.out.println("Delete");
                    break;
                case(5):
                    System.out.println("Get reports");
                    break;
                case(6):
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Incorrect choice");
                    Console.printMainMenu();
            }
        }
    }

    public void add(){
        String input = console.getStringInput("Are you adding kits or vodka?").toLowerCase();
        while(!input.equals("kits") && !input.equals("vodka")){
            input = console.getStringInput("Are you adding kits or vodka?").toLowerCase();
        }
        if(input.equals("kits")){
            int numToAdd = console.getIntegerInput("How many would you like to add?");
            for(int i = 0; i < numToAdd; i++) {
                handleKitInput();
            }
        }
        else{
            int numToAdd = console.getIntegerInput("How many would you like to add?");
            for(int i = 0; i < numToAdd; i++) {
                handleVodkaInput();
            }
        }
    }

    public void handleKitInput(){
        int kitNum = console.getIntegerInput("Enter kit number");
        double price = console.getDoubleInput("Enter kit price");
        int quantity = console.getIntegerInput("Enter quantity");
        String team = console.getStringInput("Enter team");
        String brand = console.getStringInput("Enter the brand");
        String player = console.getStringInput("Enter the player name");
        KitSize kitSize = console.getKitInput();
        kitsService.create(kitNum, quantity, price, team, brand, player, kitSize);
    }

    public void handleVodkaInput(){
        String brand = console.getStringInput("Enter brand");
        int proof = console.getIntegerInput("Enter proof");
        BottleSize bottleSize = console.getBottleSize();
        double price = console.getDoubleInput("Enter Vodka price");
        int quantity = console.getIntegerInput("Enter quantity");
        vodkaService.create(brand, proof, bottleSize, price, quantity);
    }
    

}
