public class CafeApp {
    public static void main(String[] args) {
        Beverage icedLatte = new Beverage("Iced Latte", "B-01", 95.00, "L");
        Pastry ensaymada = new Pastry("Ensaymada", "P-01", 45.00, true);
        Meal chickenAdobo = new Meal("Chicken Adobo", "M-01", 110.00, true, 1);

        Beverage hotChocolate = new Beverage("Hot Chocolate", "B-02", 80.00, "M");
        Meal beefTapa = new Meal("Beef Tapa", "M-02", 130.00, false, 0);

        Customer ana = new Customer("Kian Ortega", true);
        Customer ben = new Customer("Aljun Tacalan");

        MenuItem defaultItem = new Beverage();
        defaultItem.setName("Plain Coffee");
        defaultItem.setItemCode("B-00");
        defaultItem.setBasePrice(50.00);

        Order order1 = new Order(1001, ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);
        order1.addItem(new Pastry("Cookie", "P-02", 30.00, false));
        order1.computeTotal();
        order1.printReceipt();

        Order order2 = new Order(1002, ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.computeTotal(20.00);
        order2.printReceipt();

        icedLatte.setBasePrice(-10.00);
        chickenAdobo.setExtraSides(-1);

        System.out.println();
        System.out.println("Default constructor demonstration: " + defaultItem.getDescription());
    }
}
