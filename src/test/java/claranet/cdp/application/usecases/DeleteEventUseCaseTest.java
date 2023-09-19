package claranet.cdp.application.usecases;

import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.Comment;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.ports.EventRepository;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteEventUseCaseTest {

    EventRepository eventRepository = Mockito.mock(EventRepository.class);;

    DeleteEventUseCase deleteEventUseCase = new DeleteEventUseCase(eventRepository);

    private final Event EVENT = new Event()
            .setId(1L)
            .setComment(new Comment()
                    .setValue("commentValue")
                    .setNbStars(3))
            .setTitle("title")
            .setImgUrl("imgUrl")
            .setBands(Set.of());

    @Test
    void should_delete_event_when_delete_event_exist() {
        Mockito.when(eventRepository.getById(EVENT.getId())).thenReturn(Optional.of(EVENT));

        Either<DomainError, Boolean> eitherEvent = deleteEventUseCase.handle(EVENT.getId());

        assertTrue(eitherEvent.isRight());
        assertTrue(eitherEvent.get());
    }

    @Test
    void should_retrieve_not_found_error_when_delete_event_not_exist() {
        Long eventIdNotExist = 2L;
        Mockito.when(eventRepository.getById(eventIdNotExist)).thenReturn(Optional.empty());

        Either<DomainError, Boolean> eitherEvent = deleteEventUseCase.handle(eventIdNotExist);

        assertTrue(eitherEvent.isLeft());
        assertEquals(HttpStatus.NOT_FOUND, eitherEvent.getLeft().getCode());
    }
}