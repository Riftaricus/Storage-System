package Item;
import java.util.ArrayList;

public class ItemController {
    private static ArrayList<Item> itemList = new ArrayList<>();
    private static int nextId = 0;

    public static Item createItem(String name, String type, boolean autoAdd) {
        nextId++;
        Item item = new Item(nextId, name, type);
        if (autoAdd)
            addItem(item);
        return item;
    }

    public static Item createItem(String name, String type) {
        nextId++;
        Item item = new Item(nextId, name, type);
        addItem(item);
        return item;
    }

    public static boolean deleteItem(Item item) {
        item.resetLending();
        item.setName(null);
        return true;
    }

    public static boolean addItem(Item item) {
        itemList.add(item);
        return true;
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public static String getFormattedItemList() {
        StringBuilder sb = new StringBuilder();
        for (Item i : itemList) {
            sb.append("\nName: ").append(i.getName())
                    .append(", Type: ").append(i.getType())
                    .append(", ID: ").append(i.getId()).append("\n");
        }
        return sb.toString();
    }

    public static Item getItem(int id) {
        return itemList.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public static Item getItem(String itemName) {
        return itemList.stream().filter(i -> i.getName().equals(itemName)).findFirst().orElse(null);
    }
}
