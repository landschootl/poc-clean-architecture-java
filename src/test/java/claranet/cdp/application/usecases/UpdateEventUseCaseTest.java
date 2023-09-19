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

class UpdateEventUseCaseTest {

    EventRepository eventRepository = Mockito.mock(EventRepository.class);;

    UpdateEventUseCase updateEventUseCase = new UpdateEventUseCase(eventRepository);

    private final Event EVENT = new Event()
            .setId(1L)
            .setComment(new Comment()
                    .setValue("commentValue")
                    .setNbStars(3))
            .setTitle("title")
            .setImgUrl("imgUrl")
            .setBands(Set.of());

    @Test
    void should_update_event_when_update_event_exist() {
        Mockito.when(eventRepository.getById(EVENT.getId())).thenReturn(Optional.of(EVENT));

        Either<DomainError, Boolean> eitherEvent = updateEventUseCase.handle(EVENT);

        assertTrue(eitherEvent.isRight());
        assertTrue(eitherEvent.get());
    }

    @Test
    void should_retrieve_not_found_error_when_update_event_not_exist() {
        Event eventNotExist = new Event().setId(2L);
        Mockito.when(eventRepository.getById(eventNotExist.getId())).thenReturn(Optional.empty());

        Either<DomainError, Boolean> eitherEvent = updateEventUseCase.handle(eventNotExist);

        assertTrue(eitherEvent.isLeft());
        assertEquals(HttpStatus.NOT_FOUND, eitherEvent.getLeft().getCode());
    }

    @Test
    void should_retrieve_unprocessable_entity_error_when_update_event_with_title_not_valid() {
        Event eventWithTitleTooSmall = new Event().setId(2L).setTitle("char");
        Mockito.when(eventRepository.getById(eventWithTitleTooSmall.getId())).thenReturn(Optional.of(eventWithTitleTooSmall));

        Either<DomainError, Boolean> eitherEventWithTitleTooSmall = updateEventUseCase.handle(eventWithTitleTooSmall);

        assertTrue(eitherEventWithTitleTooSmall.isLeft());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, eitherEventWithTitleTooSmall.getLeft().getCode());

        Event eventWithTitleNull = new Event().setId(2L).setTitle(null);
        Mockito.when(eventRepository.getById(eventWithTitleNull.getId())).thenReturn(Optional.of(eventWithTitleNull));

        Either<DomainError, Boolean> eitherEventWithTitleNull = updateEventUseCase.handle(eventWithTitleNull);

        assertTrue(eitherEventWithTitleNull.isLeft());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, eitherEventWithTitleNull.getLeft().getCode());

        Event eventWithCommentNbStarsLessThan0 = new Event().setId(3L).setTitle("title").setComment(new Comment().setNbStars(-1));
        Mockito.when(eventRepository.getById(eventWithCommentNbStarsLessThan0.getId())).thenReturn(Optional.of(eventWithCommentNbStarsLessThan0));

        Either<DomainError, Boolean> eitherEventWithCommentNbStarsLessThan0 = updateEventUseCase.handle(eventWithCommentNbStarsLessThan0);

        assertTrue(eitherEventWithCommentNbStarsLessThan0.isLeft());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, eitherEventWithCommentNbStarsLessThan0.getLeft().getCode());

        Event eventWithCommentNbStarsGreaterThan5 = new Event().setId(3L).setTitle("title").setComment(new Comment().setNbStars(6));
        Mockito.when(eventRepository.getById(eventWithCommentNbStarsGreaterThan5.getId())).thenReturn(Optional.of(eventWithCommentNbStarsGreaterThan5));

        Either<DomainError, Boolean> eitherEventWithCommentNbStarsGreaterThan5 = updateEventUseCase.handle(eventWithCommentNbStarsGreaterThan5);

        assertTrue(eitherEventWithCommentNbStarsGreaterThan5.isLeft());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, eitherEventWithCommentNbStarsGreaterThan5.getLeft().getCode());
    }
}