import io.Console;

import java.util.Scanner;

public class App {

    private final Console console = new Console();

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
                case (1): // Add
                    console.handleAddItems();
                    break;
                case(2): // Read
                    console.handleReadItems();
                    break;
                case(3): // Update
                    console.handleUpdateItems();

                    break;
                case(4): // Delete
                    System.out.println("Delete");
                    break;
                case(5): // Get Reports
                    System.out.println("Get reports");
                    break;
                case(6): // Exit
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Incorrect choice");
                    Console.printMainMenu();
            }
        }
    }
}
