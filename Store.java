import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Store() {
        // Initialize with some products
        products.add(new Product(1, "T-Shirt", 499.0));
        products.add(new Product(2, "Bluetooth Speaker", 1299.0));
        products.add(new Product(3, "Laptop Bag", 799.0));
        products.add(new Product(4, "Power Bank", 999.0));
    }

    public void viewProducts() {
        System.out.println("🛍️ Available Products:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserById(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}

