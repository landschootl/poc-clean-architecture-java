package claranet.cdp.application.entities.event;

import java.util.Set;

/**
 * Object that represents a group of people
 */
public class Band {

    private Long id;
    private String name;
    private Set<Member> members;

    public Long getId() {
        return id;
    }

    public Band setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Band setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public Band setMembers(Set<Member> members) {
        this.members = members;
        return this;
    }
}
