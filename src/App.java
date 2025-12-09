public class App {
    public static void main(String[] args) throws Exception {

        Data.loadDatabase();

        

        Data.closeDatabase();

        while (true)
            UI.showMenu();
    }
}
