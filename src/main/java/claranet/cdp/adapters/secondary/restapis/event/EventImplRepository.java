package claranet.cdp.adapters.secondary.restapis.event;

import claranet.cdp.adapters.secondary.restapis.event.models.EventModel;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.entities.event.EventSearchCriteria;
import claranet.cdp.application.ports.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository which allows to retrieve and manipulate events in an external sources
 */
@Repository
public class EventImplRepository implements EventRepository {

    private final EventJpaWriteRepository eventJpaWriteRepository;
    private final EventJpaReadRepository eventJpaReadRepository;

    public EventImplRepository(@Autowired EventJpaWriteRepository eventJpaWriteRepository,
                               @Autowired EventJpaReadRepository eventJpaReadRepository) {
        this.eventJpaWriteRepository = eventJpaWriteRepository;
        this.eventJpaReadRepository = eventJpaReadRepository;
    }

    @Override
    public Optional<Event> getById(Long id) {
        EventModel eventModel = eventJpaReadRepository.findById(id);
        return eventModel == null
                ? Optional.empty()
                : Optional.of(EventModelMapper.mapEventModelToEventEntity(eventModel));
    }

    @Override
    public void deleteById(Long eventId) {
        eventJpaWriteRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getAll() {
        return eventJpaReadRepository.findAll().stream()
                .map(EventModelMapper::mapEventModelToEventEntity)
                .toList();
    }

    @Override
    public void update(Event event) {
        eventJpaWriteRepository.save(EventModelMapper.mapEventEntityToEventModel(event));
    }

    @Override
    public List<Event> search(EventSearchCriteria eventSearchCriteria) {
        return eventJpaReadRepository.searchAllByBandsContainsMembersWithName(eventSearchCriteria.getMemberName()).stream()
                .map(EventModelMapper::mapEventModelToEventEntity)
                .toList();
    }
}
