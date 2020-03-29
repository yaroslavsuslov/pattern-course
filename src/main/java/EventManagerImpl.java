import java.util.*;

public class EventManagerImpl implements EventManager {

    private Map<EventType, Set<EventListener>> listeners;

    public EventManagerImpl() {
        listeners = new HashMap<>();
    }

    @Override
    public void subscribe(EventType eventType, EventListener listener) {
        listeners.computeIfAbsent(eventType, k -> new HashSet<>()).add(listener);
    }

    @Override
    public void unsubscribe(EventType eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    @Override
    public void notify(EventType eventType, Sample sample) {
        for (EventListener listener : listeners.get(eventType)) {
            listener.update(eventType, sample);
        }

    }
}
