public class App {
    public static void main(String[] args) throws Exception {

        ItemController.createItem("Banana", "Laptop");

        ItemController.getItem(1).lendTo("Daan", 7);

        while (true)
            UI.showMenu();
    }
}
