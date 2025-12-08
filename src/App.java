public class App {
    public static void main(String[] args) throws Exception {
        ItemController.createItem("VR5", "VR");
        ItemController.createItem("VR6", "VR");

        ItemController.createItem("PC5", "PC");
        ItemController.createItem("PC6", "PC");

        ItemController.createItem("CON5", "Console");
        ItemController.createItem("CON6", "Console");

        ItemController.createItem("AR5", "AR");
        ItemController.createItem("AR6", "AR");

        ItemController.createItem("MOB5", "Mobile");
        ItemController.createItem("MOB6", "Mobile");

        ItemController.createItem("TABLET3", "Tablet");
        ItemController.createItem("TABLET4", "Tablet");

        ItemController.createItem("LAP3", "Laptop");
        ItemController.createItem("LAP4", "Laptop");

        ItemController.createItem("CAM3", "Camera");
        ItemController.createItem("CAM4", "Camera");

        ItemController.createItem("DRONE3", "Drone");
        ItemController.createItem("DRONE4", "Drone");

        ItemController.createItem("TV3", "Television");
        ItemController.createItem("TV4", "Television");

        ItemController.createItem("AUDIO1", "Audio");
        ItemController.createItem("AUDIO2", "Audio");

        ItemController.createItem("PRN1", "Printer");
        ItemController.createItem("PRN2", "Printer");

        ItemController.createItem("HMD1", "Headset");
        ItemController.createItem("HMD2", "Headset");

        ItemController.createItem("WCH1", "Wearable");
        ItemController.createItem("WCH2", "Wearable");

        ItemController.createItem("ROBO1", "Robot");
        ItemController.createItem("ROBO2", "Robot");

        ItemController.getItem(7).setLentTo("Rift", 30);

        UI.showMenu();
    }
}
