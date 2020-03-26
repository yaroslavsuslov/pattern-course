import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<OrderInterface> orders = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public OrderInterface createOrder(List<Sample> samples) {
        OrderProxy proxy = new OrderProxy(new Order(samples, this));
        orders.add(proxy);
        return proxy;
    }
}
