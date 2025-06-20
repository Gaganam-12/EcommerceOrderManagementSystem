import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Order> orderHistory;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.orderHistory = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + " | Name: " + name;
    }
}
