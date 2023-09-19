package claranet.cdp.application.entities.event;

/**
 * Object that represents event search criteria
 */
public class EventSearchCriteria {

    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    public EventSearchCriteria setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }
}
