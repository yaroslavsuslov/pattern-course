import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order implements OrderInterface{

    private int id;
    private User user;
    private List<Sample> samples;

    public Order(List<Sample> samples, User user) {
        id = ThreadLocalRandom.current().nextInt(); // replacing logic. we would get id by autoincrement from DB
        this.user = user;
        this.samples = samples;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
