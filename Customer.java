public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() { this("Walk-in Customer", false); }
    public Customer(String name) { this(name, false); }

    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name != null && !name.trim().isEmpty() ? name : "Walk-in Customer";
    }

    public boolean isStudent() { return student; }
    public void setStudent(boolean student) { this.student = student; }
    public int getLoyaltyPoints() { return loyaltyPoints; }

    public void addPoints(int points) {
        if (points >= 0) loyaltyPoints += points;
        else System.out.println("Error: loyalty points cannot be negative.");
    }

    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) loyaltyPoints += (int) (amountSpent / 50.0);
        else System.out.println("Error: amount spent cannot be negative.");
    }
}
