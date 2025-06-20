import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private static int orderCounter = 1;
    private int orderId;
    private List<Product> items;
    private LocalDateTime orderDate;

    public Order(List<Product> items) {
        this.orderId = orderCounter++;
        this.items = items;
        this.orderDate = LocalDateTime.now();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #" + orderId + " | Date: " + orderDate + "\n");
        for (Product p : items) {
            sb.append(" - ").append(p.getName()).append(" ₹").append(p.getPrice()).append("\n");
        }
        return sb.toString();
    }
}
