import java.util.Scanner;
public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-Commerce System!");

        // Get customer details
        System.out.println("Please enter your id");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Please enter your name");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your address");
        String customerAddress = scanner.nextLine();

        // Create customer
        Customer customer = new Customer(customerId, customerName, customerAddress);

        // Get number of products
        System.out.println("How many products you want to add to your cart?");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create cart
        Cart cart = new Cart(customer.getCustomerId(), numProducts);

        // Add products to cart
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Which product would you like to add?");
            System.out.println("1- Smartphone 2- T-Shirt 3- OOP");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Product product = null;
            switch (choice) {
                case 1:
                    product = new ElectronicProduct(1, "Smartphone", 599.9f, "Samsung", 1);
                    break;
                case 2:
                    product = new ClothingProduct(2, "T-Shirt", 19.99f, "Medium", "Cotton");
                    break;
                case 3:
                    product = new BookProduct(3, "OOP", 39.99f, "O'Reilly", "X Publications");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            cart.addProduct(i, product);
        }

        // Calculate total price
        float totalPrice = cart.calculatePrice();
        System.out.println("Your total is $" + totalPrice + ". Would you like to place the order? 1- Yes 2- No");
        int placeOrderChoice = scanner.nextInt();
        if (placeOrderChoice == 1) {
            // Place order
            // Here you would implement the logic to place the order, for now, let's just print order info
            Product[] products = cart.getProducts();
            Order order = new Order(customer.getCustomerId(), 1, products);
            System.out.println("Here's your order's summary:");
            order.printOrderInfo();
        } else {
            System.out.println("Order not placed."); }
    }
}
