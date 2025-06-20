import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addToCart(Product product) {
        cartItems.add(product);
        System.out.println("✅ " + product.getName() + " added to cart.");
    }

    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("🛒 Cart is empty.");
        } else {
            System.out.println("🛒 Your Cart:");
            for (Product p : cartItems) {
                System.out.println(p);
            }
        }
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
