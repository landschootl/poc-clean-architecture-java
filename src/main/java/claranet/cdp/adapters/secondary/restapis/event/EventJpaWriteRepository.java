package claranet.cdp.adapters.secondary.restapis.event;

import claranet.cdp.adapters.secondary.restapis.event.models.EventModel;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository which allows you to manipulate events from the database
 */
@Transactional
public interface EventJpaWriteRepository extends Repository<EventModel, Long> {

    void deleteById(Long eventId);

    void save(EventModel event);
}
