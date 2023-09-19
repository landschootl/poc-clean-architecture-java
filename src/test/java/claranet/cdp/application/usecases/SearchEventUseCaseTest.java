package claranet.cdp.application.usecases;

import claranet.cdp.application.entities.DomainError;
import claranet.cdp.application.entities.event.*;
import claranet.cdp.application.ports.EventRepository;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchEventUseCaseTest {

    EventRepository eventRepository = Mockito.mock(EventRepository.class);;

    SearchEventUseCase searchEventUseCase = new SearchEventUseCase(eventRepository);

    private final Event EVENT = new Event()
            .setId(1L)
            .setComment(new Comment()
                    .setValue("commentValue")
                    .setNbStars(3))
            .setTitle("title")
            .setImgUrl("imgUrl")
            .setBands(Set.of(
                    new Band()
                            .setId(1L)
                            .setName("bandName")
                            .setMembers(Set.of(
                                    new Member()
                                            .setId(1L)
                                            .setName("memberName")
                            ))
            ));

    @Test
    void should_retrieve_one_event_when_search_event() {
        List<Event> events = List.of(EVENT);
        EventSearchCriteria eventSearchCriteria = new EventSearchCriteria().setMemberName("member");
        Mockito.when(eventRepository.search(eventSearchCriteria)).thenReturn(events);

        Either<DomainError, List<Event>> eitherEvent = searchEventUseCase.handle(eventSearchCriteria);

        assertTrue(eitherEvent.isRight());
        assertEquals(events, eitherEvent.get());
    }

    @Test
    void should_retrieve_zero_event_when_get_all_event() {
        List<Event> events = Collections.emptyList();
        EventSearchCriteria eventSearchCriteria = new EventSearchCriteria().setMemberName("NameNotExist");
        Mockito.when(eventRepository.search(eventSearchCriteria)).thenReturn(events);

        Either<DomainError, List<Event>> eitherEvent = searchEventUseCase.handle(eventSearchCriteria);

        assertTrue(eitherEvent.isRight());
        assertEquals(events, eitherEvent.get());
    }
}