package claranet.cdp.adapters.primary.contollers.event;

import claranet.cdp.adapters.primary.contollers.DomainErrorException;
import claranet.cdp.adapters.primary.contollers.event.dtos.EventDto;
import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.usecases.DeleteEventUseCase;
import claranet.cdp.application.usecases.GetAllEventUseCase;
import claranet.cdp.application.usecases.SearchEventUseCase;
import claranet.cdp.application.usecases.UpdateEventUseCase;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that allows clients to manipulate events
 */
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final GetAllEventUseCase getAllEventUseCase;
    private final DeleteEventUseCase deleteEventUseCase;
    private final UpdateEventUseCase updateEventUseCase;
    private final SearchEventUseCase searchEventUseCase;

    public EventController(@Autowired GetAllEventUseCase eventService,
                           @Autowired DeleteEventUseCase deleteEventUseCase,
                           @Autowired UpdateEventUseCase updateEventUseCase,
                           @Autowired SearchEventUseCase searchEventUseCase) {
        this.getAllEventUseCase = eventService;
        this.deleteEventUseCase = deleteEventUseCase;
        this.updateEventUseCase = updateEventUseCase;
        this.searchEventUseCase = searchEventUseCase;
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> findEvents() throws DomainErrorException {
        return searchEventMethod(getAllEventUseCase.handle());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) throws DomainErrorException {
        Either<DomainError, Boolean> either = deleteEventUseCase.handle(id);
        if (either.isLeft()) {
            throw new DomainErrorException(either.getLeft());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * @deprecated As of release 0.0.1, replaced by {@link #searchEvents}. Will be dropped with release 0.1.0.
     */
    @Deprecated(forRemoval = true)
    @GetMapping(value = "/search/{query}")
    public ResponseEntity<List<EventDto>> findEvents(@PathVariable String query) throws DomainErrorException {
        return searchEventMethod(searchEventUseCase.handle(EventDtoMapper.buildEventSarchCriteria(query)));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<EventDto>> searchEvents(@RequestParam String nameMember) throws DomainErrorException {
        return searchEventMethod(searchEventUseCase.handle(EventDtoMapper.buildEventSarchCriteria(nameMember)));
    }

    private ResponseEntity<List<EventDto>> searchEventMethod(Either<DomainError, List<Event>> searchEventUseCase) throws DomainErrorException {
        Either<DomainError, List<Event>> either = searchEventUseCase;
        if (either.isLeft()) {
            throw new DomainErrorException(either.getLeft());
        }
        return ResponseEntity.status(HttpStatus.OK).body(either.get().stream()
                .map(EventDtoMapper::mapEventEntityToEventDto)
                .toList());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable Long id, @RequestBody EventDto eventDto) throws DomainErrorException {
        eventDto.setId(id);
        Either<DomainError, Boolean> either = updateEventUseCase.handle(EventDtoMapper.mapEventDtoToEventEntity(eventDto));
        if (either.isLeft()) {
            throw new DomainErrorException(either.getLeft());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
