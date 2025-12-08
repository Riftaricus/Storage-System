import java.util.Scanner;

public class UI {
    public static void showMenu() {
        printDivider();
        System.out.println("Welcome to the Volare system");
        showOption("Please choose from the following options", "Items,Lending,Manage");

    }

    private static void printDivider() {
        System.out.println("-------------------------------------");
    }

    private static int showOption(String header, String options) {
        String[] optionsArray = options.split(",");
        int index = 0;
        printDivider();
        System.out.println(header);
        printDivider();
        for (String i : optionsArray) {
            index++;
            System.out.println(index + ". " + i);
        }
        printDivider();
        int input = -1;
        Scanner scanner = new Scanner(System.in);
        while (input == -1) {
            try {
                input = scanner.nextInt();
                if (input > optionsArray.length || input < 1){
                    input = -1;
                    System.out.println("Invalid input!");
                }
            } catch (Exception e) {
                input = -1;
                System.out.println("Invalid input!");
                scanner.nextLine();

            }
        }
        scanner.close();
        return input;
    }
}
