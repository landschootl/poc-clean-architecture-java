package claranet.cdp.application.usecases;

import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.ports.EventRepository;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service that retrieves all the events
 */
@Service
public class GetAllEventUseCase {

    private final EventRepository eventRepository;

    public GetAllEventUseCase(@Autowired EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Either<DomainError, List<Event>> handle() {
        return Either.right(eventRepository.getAll());
    }
}
