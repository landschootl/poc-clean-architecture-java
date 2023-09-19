package claranet.cdp.adapters.primary.contollers.event;

import claranet.cdp.adapters.primary.contollers.event.dtos.BandDto;
import claranet.cdp.adapters.primary.contollers.event.dtos.EventDto;
import claranet.cdp.adapters.primary.contollers.event.dtos.MemberDto;
import claranet.cdp.application.entities.event.*;

import java.util.stream.Collectors;

/**
 * Mapper which allows to transform dto events
 */
public class EventDtoMapper {

    private EventDtoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Event mapEventDtoToEventEntity(EventDto eventDto) {
        return new Event()
                .setId(eventDto.getId())
                .setComment(new Comment()
                        .setValue(eventDto.getComment())
                        .setNbStars(eventDto.getNbStars()))
                .setTitle(eventDto.getTitle())
                .setImgUrl(eventDto.getImgUrl())
                .setBands(eventDto.getBands().stream()
                        .map(EventDtoMapper::mapBandDtoToBandEntity)
                        .collect(Collectors.toSet()));
    }

    private static Band mapBandDtoToBandEntity(BandDto bandDto) {
        return new Band()
                .setId(bandDto.getId())
                .setName(bandDto.getName())
                .setMembers(bandDto.getMembers().stream()
                        .map(EventDtoMapper::mapMemberDtoToMemberEntity)
                        .collect(Collectors.toSet()));
    }

    private static Member mapMemberDtoToMemberEntity(MemberDto memberDto) {
        return new Member()
                .setId(memberDto.getId())
                .setName(memberDto.getName());
    }

    public static EventDto mapEventEntityToEventDto(Event event) {
        return new EventDto()
                .setId(event.getId())
                .setComment(event.getComment() != null ? event.getComment().getValue() : null)
                .setNbStars(event.getComment() != null ? event.getComment().getNbStars() : null)
                .setTitle(event.getTitle())
                .setImgUrl(event.getImgUrl())
                .setBands(event.getBands().stream()
                        .map(EventDtoMapper::mapBandEntityToBandDto)
                        .collect(Collectors.toSet()));
    }

    private static BandDto mapBandEntityToBandDto(Band band) {
        return new BandDto()
                .setId(band.getId())
                .setName(band.getName())
                .setMembers(band.getMembers().stream()
                        .map(EventDtoMapper::mapMemberEntityToMemberDto)
                        .collect(Collectors.toSet()));
    }

    private static MemberDto mapMemberEntityToMemberDto(Member member) {
        return new MemberDto()
                .setId(member.getId())
                .setName(member.getName());
    }

    public static EventSearchCriteria buildEventSarchCriteria(String memberName) {
        return new EventSearchCriteria().setMemberName(memberName);
    }
}
