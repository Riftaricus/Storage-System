public class App {
    public static void main(String[] args) throws Exception {

        ItemController.addItemToArrayList(ItemController.createItem("Test", "Box", 0));

        ItemController.addItemToArrayList(ItemController.createItem("Test1", "Box", 1));

        ItemController.addItemToArrayList(ItemController.createItem("Test2", "Box", 2));

        System.out.println(ItemController.getFormattedItemsArrayList());
    }
}
