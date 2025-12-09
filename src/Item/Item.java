package Item;
import java.time.LocalDate;

public class Item {
    private int id;
    private String name;
    private String type;

    private String borrowerName;
    private LocalDate lendStartDate;
    private LocalDate lendEndDate;

    public Item(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public LocalDate getLendStartDate() {
        return lendStartDate;
    }

    public void setLendStartDate(LocalDate lendStartDate) {
        this.lendStartDate = lendStartDate;
    }

    public LocalDate getLendEndDate() {
        return lendEndDate;
    }

    public void setLendEndDate(LocalDate lendEndDate) {
        this.lendEndDate = lendEndDate;
    }

    // renamed from resolved()
    public boolean resetLending() {
        borrowerName = null;
        lendStartDate = null;
        lendEndDate = null;
        return true;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    // renamed parameters
    public void lendTo(String borrower, int days) {
        this.borrowerName = borrower;
        this.lendStartDate = LocalDate.now();
        this.lendEndDate = lendStartDate.plusDays(days);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", type=" + type +
                ", borrower=" + borrowerName + ", lendStart=" + lendStartDate +
                ", lendEnd=" + lendEndDate + "]";
    }
}
