public class Pastry extends MenuItem {
    private boolean warmed;

    public Pastry() {
        super();
        warmed = false;
    }

    public Pastry(String name, String itemCode, double basePrice, boolean warmed) {
        super(name, itemCode, basePrice);
        this.warmed = warmed;
    }

    public boolean isWarmed() { return warmed; }
    public void setWarmed(boolean warmed) { this.warmed = warmed; }

    @Override
    public double computePrice() {
        return warmed ? basePrice + 10 : basePrice;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + (warmed ? " (Warmed)" : " (Not warmed)");
    }
}
