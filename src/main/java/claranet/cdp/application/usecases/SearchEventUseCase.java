package claranet.cdp.application.usecases;

import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.entities.event.EventSearchCriteria;
import claranet.cdp.application.ports.EventRepository;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that searches for events matching the criteria
 */
@Service
public class SearchEventUseCase {

    private final EventRepository eventRepository;

    public SearchEventUseCase(@Autowired EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Either<DomainError, List<Event>> handle(EventSearchCriteria eventSearchCriteria) {
        return Either.right(eventRepository.search(eventSearchCriteria));
    }
}
