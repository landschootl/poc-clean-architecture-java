package claranet.cdp.application.usecases;

import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.Band;
import claranet.cdp.application.entities.event.Comment;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.entities.event.Member;
import claranet.cdp.application.ports.EventRepository;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetAllEventUseCaseTest {

    EventRepository eventRepository = Mockito.mock(EventRepository.class);;

    GetAllEventUseCase getAllEventUseCase = new GetAllEventUseCase(eventRepository);

    private final Event EVENT1 = new Event()
            .setId(1L)
            .setComment(new Comment()
                    .setValue("commentValue1")
                    .setNbStars(3))
            .setTitle("title1")
            .setImgUrl("imgUrl1")
            .setBands(Set.of(
                    new Band()
                            .setId(1L)
                            .setName("bandName1")
                            .setMembers(Set.of(
                                    new Member()
                                            .setId(1L)
                                            .setName("memberName1")
                            ))
            ));

    private final Event EVENT2 = new Event()
            .setId(2L)
            .setComment(new Comment()
                    .setValue("commentValue2")
                    .setNbStars(1))
            .setTitle("title2")
            .setImgUrl("imgUrl2")
            .setBands(Set.of());

    @Test
    void should_retrieve_two_events_when_get_all_event() {
        List<Event> events = List.of(EVENT1, EVENT2);
        Mockito.when(eventRepository.getAll()).thenReturn(events);

        Either<DomainError, List<Event>> eitherEvent = getAllEventUseCase.handle();

        assertTrue(eitherEvent.isRight());
        assertEquals(events, eitherEvent.get());
    }

    @Test
    void should_retrieve_zero_event_when_get_all_event() {
        List<Event> events = Collections.emptyList();
        Mockito.when(eventRepository.getAll()).thenReturn(events);

        Either<DomainError, List<Event>> eitherEvent = getAllEventUseCase.handle();

        assertTrue(eitherEvent.isRight());
        assertEquals(events, eitherEvent.get());
    }
}