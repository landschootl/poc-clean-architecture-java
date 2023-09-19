package claranet.cdp.application.ports;

import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.entities.event.EventSearchCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Repository which allows to retrieve and manipulate events in an external sources
 */
public interface EventRepository {

    Optional<Event> getById(Long id);

    void deleteById(Long eventId);

    List<Event> getAll();

    void update(Event event);

    List<Event> search(EventSearchCriteria eventSearchCriteria);
}
