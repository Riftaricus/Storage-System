import Item.ItemController;
import UI.UI;

public class App {
    public static void main(String[] args) throws Exception {
        ItemController.createItem("PD01", "Play Dough");
        ItemController.createItem("PD02", "Play Dough");
        ItemController.createItem("PD03", "Play Dough");
        ItemController.createItem("PD04", "Play Dough");
        ItemController.createItem("PD05", "Play Dough");
        ItemController.createItem("PD06", "Play Dough");

        ItemController.createItem("LB01", "Lego Box");
        ItemController.createItem("LB02", "Lego Box");
        ItemController.createItem("LB03", "Lego Box");
        ItemController.createItem("LB04", "Lego Box");
        ItemController.createItem("LB05", "Lego Box");
        ItemController.createItem("LB06", "Lego Box");

        ItemController.createItem("BK01", "Building Blocks");
        ItemController.createItem("BK02", "Building Blocks");
        ItemController.createItem("BK03", "Building Blocks");
        ItemController.createItem("BK04", "Building Blocks");

        ItemController.createItem("CR01", "Crayons Set");
        ItemController.createItem("CR02", "Crayons Set");
        ItemController.createItem("CR03", "Crayons Set");
        ItemController.createItem("CR04", "Crayons Set");
        ItemController.createItem("CR05", "Crayons Set");

        ItemController.createItem("PT01", "Puzzle Toy");
        ItemController.createItem("PT02", "Puzzle Toy");
        ItemController.createItem("PT03", "Puzzle Toy");
        ItemController.createItem("PT04", "Puzzle Toy");

        ItemController.createItem("DT01", "Doll Toy");
        ItemController.createItem("DT02", "Doll Toy");
        ItemController.createItem("DT03", "Doll Toy");
        ItemController.createItem("DT04", "Doll Toy");

        ItemController.createItem("CT01", "Coloring Book");
        ItemController.createItem("CT02", "Coloring Book");
        ItemController.createItem("CT03", "Coloring Book");
        ItemController.createItem("CT04", "Coloring Book");
        ItemController.createItem("CT05", "Coloring Book");

        ItemController.createItem("TR01", "Toy Robot");
        ItemController.createItem("TR02", "Toy Robot");
        ItemController.createItem("TR03", "Toy Robot");
        ItemController.createItem("TR04", "Toy Robot");

        ItemController.createItem("ST01", "Stuffed Animal");
        ItemController.createItem("ST02", "Stuffed Animal");
        ItemController.createItem("ST03", "Stuffed Animal");
        ItemController.createItem("ST04", "Stuffed Animal");

        ItemController.createItem("MR01", "Marble Set");
        ItemController.createItem("MR02", "Marble Set");
        ItemController.createItem("MR03", "Marble Set");
        ItemController.createItem("MR04", "Marble Set");

        ItemController.createItem("RC01", "Race Car Toy");
        ItemController.createItem("RC02", "Race Car Toy");
        ItemController.createItem("RC03", "Race Car Toy");
        ItemController.createItem("RC04", "Race Car Toy");

        ItemController.createItem("AN01", "Animal Figures");
        ItemController.createItem("AN02", "Animal Figures");
        ItemController.createItem("AN03", "Animal Figures");
        ItemController.createItem("AN04", "Animal Figures");

        // DataJSON.updateFile();

        // Data.loadDatabase();
        // Data.triggerEditStatement("Query");
        // Data.triggerSelectStatement("Query");
        // Data.updateDatabase();
        // Data.updateItems();
        // Data.closeDatabase();

        while (true)
            UI.showMenu();
    }
}
