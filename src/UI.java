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
                ArrayList<Item> itemArray = ItemController.getItemList();
                for (Item item : itemArray) {
                    combinedString.append(
                            "Name: " + item.getName() + " ( ID:" + item.getId() + " ) " + "Type:"
                                    + item.getType() + " |Lent to: " + item.getBorrowerName() + " From: "
                                    + item.getLendStartDate() + " Till: " + item.getLendEndDate() + ",");
                }

                viewDevices(combinedString.toString());
                break;
            case 2:
                StringBuilder combinedString2 = new StringBuilder();
                ArrayList<Item> itemArray2 = ItemController.getItemList();
                for (Item item : itemArray2) {
                    combinedString2.append(
                            "Name: " + item.getName() + " ( ID:" + item.getId() + " ) " + "Type:"
                                    + item.getType() + " |Lent to: " + item.getBorrowerName() + " From: "
                                    + item.getLendStartDate() + " Till: " + item.getLendEndDate() + ",");
                }

                manageDevicesLending(combinedString2.toString());

                break;

        }
        printDivider();
        scanner.nextLine();
        showMenu();
    }

    private static boolean viewDevices(String deviceListString) {
        int selection = showOption("Please choose which device to view", deviceListString);
        Item item = ItemController.getItemList().get(selection - 1);

        printDivider();
        System.out.println("Device name: " + item.getName());
        System.out.println("Device type: " + item.getType());
        System.out.println("Device ID: " + item.getId());
        printDivider();
        System.out.println("Lent out to: " + item.getBorrowerName());
        printDivider();
        System.out.println("Lent out at: " + item.getLendStartDate());
        System.out.println("Lent out till: " + item.getLendEndDate());
        System.out.println("Current date: " + LocalDate.now());

        return true;
    }

    private static boolean manageDevicesLending(String combinedString) {
        boolean resolved = true;

        int target = showOption("Please choose which device to manage", combinedString.toString());

        Item selectedDevice = ItemController.getItemList().get(target - 1);

        target = showOption("What would you like to do?", "Lend out,Resolve");

        if (target == 1) {

            String stringInput = showStringInput("Please choose who to lend " + selectedDevice.getName() + " to");

            int intInput = showIntegerInput(
                    "Please choose how long to lend " + selectedDevice.getName() + " to " + stringInput);

            selectedDevice.lendTo(stringInput, intInput);
        } else {
            selectedDevice.resetLending();
            System.out.println("Succesfully resolved");
        }

        printDivider();
        System.out.println("Device name: " + selectedDevice.getName());
        System.out.println("Device type: " + selectedDevice.getType());
        System.out.println("Device ID: " + selectedDevice.getId());
        printDivider();
        System.out.println("Lent out to: " + selectedDevice.getBorrowerName());
        printDivider();
        System.out.println("Lent out at: " + selectedDevice.getLendStartDate());
        System.out.println("Lent out till: " + selectedDevice.getLendEndDate());
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
                input = Integer.parseInt(scanner.nextLine());
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
                input = Integer.parseInt(scanner.nextLine());
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
