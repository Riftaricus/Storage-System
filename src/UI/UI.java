package UI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Item.Item;
import Item.ItemController;


public class UI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DIVIDER = "-------------------------------------";

    public static void showMenu() {
        while (true) {
            printDivider();
            System.out.println("Welcome to the Volare system");
            int target = showOption("Please choose from the following options", "Items,Lending");
            printDivider();
            
            switch (target) {
                case 1 -> viewDevices(buildItemListString());
                case 2 -> manageDevicesLending();
            }
            printDivider();
        }
    }

    private static String buildItemListString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Item> items = ItemController.getItemList();
        for (Item item : items) {
            sb.append(String.format("%s (ID:%d) | Type: %s | Lent to: %s,",
                    item.getName(), item.getId(), item.getType(), 
                    item.getBorrowerName(), item.getLendStartDate(), item.getLendEndDate()));
        }
        return sb.toString();
    }

    private static void viewDevices(String deviceListString) {
        int selection = showOption("Please choose which device to view", deviceListString);
        Item item = ItemController.getItemList().get(selection - 1);
        displayItemDetails(item);
    }

    private static void manageDevicesLending() {
        String deviceListString = buildItemListString();
        int target = showOption("Please choose which device to manage", deviceListString);
        Item selectedDevice = ItemController.getItemList().get(target - 1);

        int action = showOption("What would you like to do?", "Lend out,Resolve");

        if (action == 1) {
            String borrower = showStringInput("Please choose who to lend " + selectedDevice.getName() + " to");
            int days = showIntegerInput("Please choose how many days to lend " + selectedDevice.getName() + " to " + borrower);
            selectedDevice.lendTo(borrower, days);
        } else {
            selectedDevice.resetLending();
            System.out.println("Successfully resolved");
        }
        
        displayItemDetails(selectedDevice);
    }

    private static void displayItemDetails(Item item) {
        printDivider();
        System.out.println("Device name: " + item.getName());
        System.out.println("Device type: " + item.getType());
        System.out.println("Device ID: " + item.getId());
        printDivider();
        System.out.println("Lent out to: " + item.getBorrowerName());
        System.out.println("Lent out at: " + item.getLendStartDate());
        System.out.println("Lent out till: " + item.getLendEndDate());
        System.out.println("Current date: " + LocalDate.now());
    }

    private static void printDivider() {
        System.out.println(DIVIDER);
    }

    private static String showStringInput(String header) {
        printDivider();
        System.out.println(header);
        printDivider();
        return scanner.nextLine().trim();
    }

    private static int showIntegerInput(String header) {
        printDivider();
        System.out.println(header);
        printDivider();
        int input = -1;
        while (input == -1) {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input < 1) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                input = -1;
                System.out.println("Invalid input! Please enter a positive number.");
            }
        }
        return input;
    }

    private static int showOption(String header, String options) {
        String[] optionsArray = options.split(",");
        printDivider();
        System.out.println(header);
        printDivider();
        for (int i = 0; i < optionsArray.length; i++) {
            System.out.println((i + 1) + ". " + optionsArray[i]);
        }
        printDivider();
        
        int input = -1;
        while (input == -1) {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input > optionsArray.length || input < 1) {
                    input = -1;
                    System.out.println("Invalid input! Please choose a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return input;
    }
}
