import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class User implements EventListener{
    private int id;
    private String name;
    private List<OrderInterface> orders = new ArrayList<>();
    private Portfolio portfolio;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        portfolio = new Portfolio.PortfolioBuilder()
                .setId(ThreadLocalRandom.current().nextInt())
                .setSamples(new ArrayList<>())
                .setUser(this)
                .build();
    }

    public void addSampleToPortfolio(Sample sample) {
        portfolio.addToPortfolio(sample);
    }

    public void removeFromPortfolio(Sample sample) {
        portfolio.removeFromPortfolio(sample);
    }

    public void subscribeToUserAddOperation(User user) {
        user.getPortfolio().subcribe(EventType.ADD, user);
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }


    public OrderInterface createOrder(List<Sample> samples) {
        OrderProxy proxy = new OrderProxy(new Order(samples, this));
        orders.add(proxy);
        return proxy;
    }

    @Override
    public void update(EventType eventType, Sample sample) {
        System.out.println("evenType " + eventType + ": sample " + sample); // какая то логика нотификации
    }
}
