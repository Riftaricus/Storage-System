import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        printDivider();
        System.out.println("Welcome to the Volare system");
        int target = showOption("Please choose from the following options", "Items,Lending");
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

                viewDevices(combinedString.toString());
                break;
            case 2:
                StringBuilder combinedString2 = new StringBuilder();
                ArrayList<Item> itemArray2 = ItemController.getItemsArrayList();
                for (Item item : itemArray2) {
                    combinedString2.append(
                            "Name: " + item.getItemName() + " ( ID:" + item.getItemID() + " ) " + "Type:"
                                    + item.getItemType() + " |Lent to: " + item.getLentTo() + " From: "
                                    + item.getLentDate() + " Till: " + item.getLentTillDate() + ",");
                }

                manageDevicesLending(combinedString2.toString());

                break;

        }
        printDivider();
        scanner.nextLine();
        showMenu();
    }

    private static boolean viewDevices(String combinedString) {
        boolean resolved = true;

        int target = showOption("Please choose which device to view", combinedString.toString());

        Item selectedDevice = ItemController.getItemsArrayList().get(target - 1);

        printDivider();
        System.out.println("Device name: " + selectedDevice.getItemName());
        System.out.println("Device type: " + selectedDevice.getItemType());
        System.out.println("Device ID: " + selectedDevice.getItemID());
        printDivider();
        System.out.println("Lent out to: " + selectedDevice.getLentTo());
        printDivider();
        System.out.println("Lent out at: " + selectedDevice.getLentDate());
        System.out.println("Lent out till: " + selectedDevice.getLentTillDate());
        System.out.println("Current date: " + LocalDate.now());

        return resolved;
    }

    private static boolean manageDevicesLending(String combinedString) {
        boolean resolved = true;

        int target = showOption("Please choose which device to manage", combinedString.toString());

        Item selectedDevice = ItemController.getItemsArrayList().get(target - 1);

        target = showOption("What would you like to do?", "Lend out,Resolve");

        if (target == 1) {

            String stringInput = showStringInput("Please choose who to lend " + selectedDevice.getItemName() + " to");

            int intInput = showIntegerInput(
                    "Please choose how long to lend " + selectedDevice.getItemName() + " to " + stringInput);

            selectedDevice.setLentTo(stringInput, intInput);
        } else {
            selectedDevice.resolved();
            System.out.println("Succesfully resolved");
        }

        printDivider();
        System.out.println("Device name: " + selectedDevice.getItemName());
        System.out.println("Device type: " + selectedDevice.getItemType());
        System.out.println("Device ID: " + selectedDevice.getItemID());
        printDivider();
        System.out.println("Lent out to: " + selectedDevice.getLentTo());
        printDivider();
        System.out.println("Lent out at: " + selectedDevice.getLentDate());
        System.out.println("Lent out till: " + selectedDevice.getLentTillDate());
        System.out.println("Current date: " + LocalDate.now());
        return resolved;
    }

    private static void printDivider() {
        System.out.println("-------------------------------------");
    }

    private static String showStringInput(String header) {
        printDivider();
        System.out.println(header);
        printDivider();
        System.out.println("Type here");
        String input = scanner.nextLine();
        return input;
    }

    private static int showIntegerInput(String header) {
        scanner.nextLine();
        printDivider();
        System.out.println(header);
        printDivider();
        System.out.println("Type here");
        int input = -1;
        while (input == -1) {
            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                input = -1;
                System.out.println("Invalid input!");
            }
        }

        return input;
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
