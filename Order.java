public class Order {
    private int orderNumber;
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private double lastVoucher;
    private boolean pointsAwarded;

    public Order(int orderNumber, Customer customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        itemCount = 0;
        lastVoucher = 0.0;
        pointsAwarded = false;
    }

    public void addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return;
        }
        if (itemCount == 0) item1 = item;
        else if (itemCount == 1) item2 = item;
        else if (itemCount == 2) item3 = item;
        else {
            System.out.println("Order is full. Cannot add " + item.getName() + ".");
            return;
        }
        itemCount++;
    }

    public double computeSubtotal() {
        double subtotal = 0.0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    public double computeTotal() {
        double total = computeSubtotal();
        if (customer != null && customer.isStudent()) total *= 0.90;
        lastVoucher = 0.0;
        return Math.max(0.0, total);
    }

    public double computeTotal(double voucher) {
        double total = computeTotal();
        if (voucher < 0) voucher = 0;
        lastVoucher = Math.min(voucher, total);
        return Math.max(0.0, total - lastVoucher);
    }

    public void printReceipt() {
        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0.0;
        double total = Math.max(0.0, subtotal - discount - lastVoucher);

        System.out.println();
        System.out.println("Order #" + orderNumber + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        if (item1 != null) printItem(item1);
        if (item2 != null) printItem(item2);
        if (item3 != null) printItem(item3);
        System.out.printf("  Subtotal: %.2f%n", subtotal);
        if (discount > 0) System.out.printf("  Student discount (10%%): -%.2f%n", discount);
        if (lastVoucher > 0) System.out.printf("  Voucher: -%.2f%n", lastVoucher);
        System.out.printf("  TOTAL: %.2f%n", total);

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
    }

    private void printItem(MenuItem item) {
        System.out.printf("  %-48s %8.2f%n", item.getDescription(), item.computePrice());
    }
}
