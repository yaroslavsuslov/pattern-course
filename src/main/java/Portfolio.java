import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Portfolio {

    private final long id;
    private final User owner;
    private final List<Sample> samples;

    private Portfolio(long id, User owner, List<Sample> samples) {
        this.id = id;
        this.owner = owner;
        this.samples = samples;
    }

    public static class PortfolioBuilder {

        private long id;
        private User user;
        private List<Sample> samples;

        public PortfolioBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public PortfolioBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public PortfolioBuilder setSamples(Sample... samples) {
            this.samples = new ArrayList<>(Arrays.asList(samples));
            return this;
        }

        public Portfolio build() {
            return new Portfolio(id, user, samples);
        }
    }
}
