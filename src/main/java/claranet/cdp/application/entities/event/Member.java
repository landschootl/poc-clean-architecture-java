package claranet.cdp.application.entities.event;

/**
 * Object that represents a member of a group
 */
public class Member {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public Member setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }
}
