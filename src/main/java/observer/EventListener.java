package observer;

import domain.Sample;

public interface EventListener {

    void update(EventType eventType, Sample sample);

}
