public abstract class MenuItem {
    private String name;
    private String itemCode;
    protected double basePrice;

    public MenuItem() {
        this("Unnamed Item", "N/A", 0.0);
    }

    public MenuItem(String name, String itemCode, double basePrice) {
        setName(name);
        setItemCode(itemCode);
        setBasePrice(basePrice);
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name != null && !name.trim().isEmpty() ? name : "Unnamed Item";
    }

    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode != null && !itemCode.trim().isEmpty() ? itemCode : "N/A";
    }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) this.basePrice = basePrice;
        else {
            System.out.println("Error: base price cannot be negative.");
            this.basePrice = 0.0;
        }
    }

    public abstract double computePrice();

    public String getDescription() {
        return name + " [" + itemCode + "]";
    }
}
