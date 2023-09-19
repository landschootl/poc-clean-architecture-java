package claranet.cdp.adapters.primary.contollers.event.dtos;

import java.util.Set;

/**
 * Object that represents a group of people
 */
public class BandDto {

    private Long id;
    private String name;
    private Set<MemberDto> members;

    public Long getId() {
        return id;
    }

    public BandDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BandDto setName(String name) {
        this.name = name;
        return this;
    }

    public Set<MemberDto> getMembers() {
        return members;
    }

    public BandDto setMembers(Set<MemberDto> members) {
        this.members = members;
        return this;
    }
}
