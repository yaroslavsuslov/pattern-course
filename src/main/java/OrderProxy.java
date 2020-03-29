import java.util.List;

public class OrderProxy implements OrderInterface {

    private Order order;

    public OrderProxy(Order order) {
        this.order = order;
    }

    @Override
    public List<Sample> getSamples() {
        System.out.println("do smth important");
        System.out.println(order.getUser() + "trying to get samples");
        return order.getSamples();
    }
}
