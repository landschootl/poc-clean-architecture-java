package claranet.cdp.adapters.secondary.restapis.event.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Object that represents a member of a group in database
 */
@Entity(name = "member")
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public MemberModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MemberModel setName(String name) {
        this.name = name;
        return this;
    }
}
