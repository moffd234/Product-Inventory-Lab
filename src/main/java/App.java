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
                case (1):
                    console.handleAddItems();
                    break;
                case(2):
                    console.handleReadItems();
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
}
