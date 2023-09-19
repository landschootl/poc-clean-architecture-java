package claranet.cdp.adapters.secondary.restapis.event;

import claranet.cdp.adapters.secondary.restapis.event.models.BandModel;
import claranet.cdp.adapters.secondary.restapis.event.models.EventModel;
import claranet.cdp.adapters.secondary.restapis.event.models.MemberModel;
import claranet.cdp.application.entities.event.Band;
import claranet.cdp.application.entities.event.Comment;
import claranet.cdp.application.entities.event.Event;
import claranet.cdp.application.entities.event.Member;

import java.util.stream.Collectors;

/**
 * Mapper which allows to transform model events
 */
public class EventModelMapper {

    private EventModelMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Event mapEventModelToEventEntity(EventModel eventModel) {
        return new Event()
                .setId(eventModel.getId())
                .setComment(new Comment()
                        .setValue(eventModel.getComment())
                        .setNbStars(eventModel.getNbStars()))
                .setTitle(eventModel.getTitle())
                .setImgUrl(eventModel.getImgUrl())
                .setBands(eventModel.getBands().stream()
                        .map(EventModelMapper::mapBandModelToBandEntity)
                        .collect(Collectors.toSet()));
    }

    private static Band mapBandModelToBandEntity(BandModel bandModel) {
        return new Band()
                .setId(bandModel.getId())
                .setName(bandModel.getName())
                .setMembers(bandModel.getMembers().stream()
                        .map(EventModelMapper::mapMemberModelToMemberEntity)
                        .collect(Collectors.toSet()));
    }

    private static Member mapMemberModelToMemberEntity(MemberModel memberModel) {
        return new Member()
                .setId(memberModel.getId())
                .setName(memberModel.getName());
    }

    public static EventModel mapEventEntityToEventModel(Event event) {
        return new EventModel()
                .setId(event.getId())
                .setComment(event.getComment() != null ? event.getComment().getValue() : null)
                .setNbStars(event.getComment() != null ? event.getComment().getNbStars() : null)
                .setTitle(event.getTitle())
                .setImgUrl(event.getImgUrl())
                .setBands(event.getBands().stream()
                        .map(EventModelMapper::mapBandEntityToBandModel)
                        .collect(Collectors.toSet()));
    }

    private static BandModel mapBandEntityToBandModel(Band band) {
        return new BandModel()
                .setId(band.getId())
                .setName(band.getName())
                .setMembers(band.getMembers().stream()
                        .map(EventModelMapper::mapMemberEntityToMemberModel)
                        .collect(Collectors.toSet()));
    }

    private static MemberModel mapMemberEntityToMemberModel(Member member) {
        return new MemberModel()
                .setId(member.getId())
                .setName(member.getName());
    }
}
