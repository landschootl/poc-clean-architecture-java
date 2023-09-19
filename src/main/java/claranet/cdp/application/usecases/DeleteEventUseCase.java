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
 * Service that deletes an event
 */
@Service
public class DeleteEventUseCase {

    private final EventRepository eventRepository;

    public DeleteEventUseCase(@Autowired EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Either<DomainError, Boolean> handle(Long id) {
        Optional<Event> eventOptional = eventRepository.getById(id);
        if (eventOptional.isEmpty()) {
            return Either.left(new DomainError(HttpStatus.NOT_FOUND, "Event with id " + id + " does not exist"));
        }
        eventRepository.deleteById(id);
        return Either.right(true);
    }
}
