public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    public Meal(String name, String itemCode, double basePrice, boolean upsized, int extraSides) {
        super(name, itemCode, basePrice);
        setUpsized(upsized);
        setExtraSides(extraSides);
    }

    public boolean isUpsized() { return upsized; }
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    public int getExtraSides() { return extraSides; }
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) this.extraSides = extraSides;
        else {
            System.out.println("Error: extra sides cannot be negative.");
            this.extraSides = 0;
        }
    }

    @Override
    public double computePrice() {
        return basePrice + (upsized ? 20 : 0) + extraSides * 12;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + (upsized ? " Upsized" : " Regular") + ", " + extraSides + " side(s)";
    }
}
