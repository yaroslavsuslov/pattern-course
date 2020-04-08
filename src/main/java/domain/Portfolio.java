package domain;

import observer.EventListener;
import observer.EventManager;
import observer.EventManagerImpl;
import observer.EventType;

import java.util.List;

public class Portfolio {

    public EventManager eventManager;

    private final long id;
    private final User owner;
    private final List<Sample> samples;

    private Portfolio(long id, User owner, List<Sample> samples) {
        this.id = id;
        this.owner = owner;
        this.samples = samples;
        eventManager = new EventManagerImpl();
    }

    public void addToPortfolio(Sample sample) {
        samples.add(sample);
        eventManager.notify(EventType.ADD, sample);
    }

    public void removeFromPortfolio(Sample sample) {
        samples.remove(sample);
        eventManager.notify(EventType.REMOVE, sample);
    }

    public void subcribe(EventType eventType, EventListener listener) {
        eventManager.subscribe(eventType, listener);
    }

    public void unsubcribe(EventType eventType, EventListener listener) {
        eventManager.unsubscribe(eventType, listener);
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

        public PortfolioBuilder setSamples(List<Sample> samples) {
            this.samples = samples;
            return this;
        }

        public Portfolio build() {
            return new Portfolio(id, user, samples);
        }
    }
}
