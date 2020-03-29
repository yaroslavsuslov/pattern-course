package observer;

import domain.Sample;

public interface EventManager {

    void subscribe(EventType eventType, EventListener listener);

    void unsubscribe(EventType eventType, EventListener listener);

    void notify(EventType eventType, Sample sample);
}
