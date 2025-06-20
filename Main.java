import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner sc = new Scanner(System.in);
        int mainChoice;

        System.out.println("Welcome to the E-Commerce Order Management System!");

        do {
            System.out.println("\nAre you:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1:
                    adminMenu(store, sc);
                    break;

                case 2:
                    userMenu(store, sc);
                    break;

                case 0:
                    System.out.println("👋 Thank you! Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (mainChoice != 0);

        sc.close();
    }

    // ==================== ADMIN MODE ====================
    public static void adminMenu(Store store, Scanner sc) {
        final String adminPass = "admin123";
        System.out.print("Enter admin password: ");
        String pass = sc.nextLine();

        if (!pass.equals(adminPass)) {
            System.out.println("❌ Incorrect password!");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- Admin Panel ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    store.viewProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    store.addProduct(new Product(id, name, price));
                    System.out.println("✅ Product added.");
                    break;
                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    int remId = sc.nextInt();
                    store.removeProduct(remId);
                    System.out.println("✅ Product removed (if found).");
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // ==================== USER MODE ====================
    public static void userMenu(Store store, Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your user ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        User user = new User(userId, name);
        store.addUser(user);
        Cart cart = new Cart();
        int choice;

        do {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Order History");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    store.viewProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID to add to cart: ");
                    int prodId = sc.nextInt();
                    Product prod = store.findProductById(prodId);
                    if (prod != null) {
                        cart.addToCart(prod);
                    } else {
                        System.out.println("❌ Product not found.");
                    }
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("❗ Your cart is empty.");
                    } else {
                        Order order = new Order(cart.getCartItems());
                        user.addOrder(order);
                        cart.clearCart();
                        System.out.println("✅ Order placed successfully!\n" + order);
                    }
                    break;
                case 5:
                    System.out.println("📦 Order History:");
                    for (Order o : user.getOrderHistory()) {
                        System.out.println(o);
                    }
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);
    }
}
