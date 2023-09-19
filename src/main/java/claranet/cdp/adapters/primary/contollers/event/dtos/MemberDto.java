package claranet.cdp.adapters.primary.contollers.event.dtos;

/**
 * Object that represents a member of a group
 */
public class MemberDto {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public MemberDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MemberDto setName(String name) {
        this.name = name;
        return this;
    }
}
