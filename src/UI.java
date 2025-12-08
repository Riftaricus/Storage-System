import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        printDivider();
        System.out.println("Welcome to the Volare system");
        int target = showOption("Please choose from the following options", "Items,Lending,Manage");
        printDivider();
        switch (target) {
            case 1:
                StringBuilder combinedString = new StringBuilder();
                ArrayList<Item> itemArray = ItemController.getItemsArrayList();
                for (Item item : itemArray) {
                    combinedString.append(
                            "Name: " + item.getItemName() + " ( ID:" + item.getItemID() + " ) " + "Type:"
                                    + item.getItemType() + " |Lent to: " + item.getLentTo() + " From: "
                                    + item.getLentDate() + " Till: " + item.getLentTillDate() + ",");
                }

                target = showOption("Please choose which device to manage", combinedString.toString());

                System.out.println(itemArray.get(target - 1).getItemName());

                break;
            case 2:

                break;
            case 3:

                break;
        }
        printDivider();
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
        while (input == -1) {
            try {
                input = scanner.nextInt();
                if (input > optionsArray.length || input < 1) {
                    input = -1;
                    System.out.println("Invalid input!");
                }
            } catch (Exception e) {
                input = -1;
                System.out.println("Invalid input!");
                scanner.nextLine();

            }
        }
        return input;
    }
}
