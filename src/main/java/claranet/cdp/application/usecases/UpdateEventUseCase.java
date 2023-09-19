package claranet.cdp.application.usecases;

import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.ports.EventRepository;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service that modifies an event
 */
@Service
public class UpdateEventUseCase {

    private final EventRepository eventRepository;

    public UpdateEventUseCase(@Autowired EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Either<DomainError, Boolean> handle(Event event) {
        Optional<Event> eventOptional = eventRepository.getById(event.getId());
        if (eventOptional.isEmpty()) {
            return Either.left(new DomainError(HttpStatus.NOT_FOUND, "Event with id " + event.getId() + " does not exist"));
        }
        if (!event.isValid()) {
            return Either.left(new DomainError(HttpStatus.UNPROCESSABLE_ENTITY, "Event with id " + event.getId() + " is invalid"));
        }
        eventRepository.update(event);
        return Either.right(true);
    }
}