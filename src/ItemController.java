import java.util.ArrayList;

public class ItemController {
    private static ArrayList<Item> items = new ArrayList<>();

    private static int index = 0;

    public static Item createItem(String itemName, String itemType, boolean autoAddToArray) {
        index++;
        Item item = new Item(index, itemName, itemType);
        if (autoAddToArray)
            ItemController.addItemToArrayList(item);
        return item;
    }

    public static Item createItem(String itemName, String itemType) {
        index++;
        Item item = new Item(index, itemName, itemType);
        ItemController.addItemToArrayList(item);
        return item;
    }

    public static boolean deleteItem(Item item) {
        boolean resolved = true;
        try {
            item.resolved();
            item.setItemName(null);
            item.setLentTo(null, 0);
        } catch (Exception e) {
            resolved = false;
        }
        return resolved;
    }

    public static boolean addItemToArrayList(Item item) {
        boolean resolved = true;
        try {
            items.add(item);
        } catch (Exception e) {
            resolved = false;
        }
        return resolved;
    }

    public static ArrayList<Item> getItemsArrayList() {
        return items;
    }

    public static String getFormattedItemsArrayList() {
        StringBuilder formattedString = new StringBuilder();

        for (Item i : items) {
            formattedString.append(
                    "\n" + "Name: " + i.getItemName() + ", Type: " + i.getItemType() + ", ID: " + i.getItemID() + "\n");
        }

        return formattedString.toString();

    }

    public static Item getItem(int itemID) {
        Item selectedItem = null;
        for (Item i : items) {
            if (i.getItemID() == itemID)
                selectedItem = i;
        }

        if (selectedItem == null) {
            selectedItem = null;
        }

        return selectedItem;
    }
}
