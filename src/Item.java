import java.time.LocalDate;

public class Item {
    private int itemID;
    private String itemName;
    private String itemType;

    private String lentTo;

    private LocalDate lentDate;

    private LocalDate lentTillDate;

    public Item(int itemID, String itemName, String itemType) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public boolean resolved() {
        boolean resolved = true;
        try {
            lentTo = null;
            lentDate = null;
            lentTillDate = null;
        } catch (Exception e) {
            resolved = false;
        }
        return resolved;
    }

    public String getLentTo() {
        return lentTo;
    }

    public void setLentTo(String lentTo, int amountLent) {
        this.lentTo = lentTo;
        lentDate = LocalDate.now();
        this.lentTillDate = lentDate.plusDays(amountLent);
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemType=" + itemType + ", lentTo=" + lentTo
                + ", lentDate=" + lentDate + ", lentTillDate=" + lentTillDate + "]";
    }

}
