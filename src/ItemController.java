import java.util.ArrayList;

public class ItemController {
    private static ArrayList<Item> items = new ArrayList<>();

    public static Item createItem(String itemName, String itemType, int itemID) {
        Item item = new Item(itemID, itemName, itemType);
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
            formattedString.append(i.getItemName() + " " + i.getItemType() + " " + i.getItemID() + ", ");
        }

        return formattedString.toString();

    }
}
