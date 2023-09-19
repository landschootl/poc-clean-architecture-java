package claranet.cdp.adapters.secondary.restapis.event.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Object that represents an event in database
 */
@Entity(name = "Event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String imgUrl;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<BandModel> bands;

    private Integer nbStars;

    private String comment;

    public Long getId() {
        return id;
    }

    public EventModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EventModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public EventModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Set<BandModel> getBands() {
        return bands;
    }

    public EventModel setBands(Set<BandModel> bands) {
        this.bands = bands;
        return this;
    }

    public Integer getNbStars() {
        return nbStars;
    }

    public EventModel setNbStars(Integer nbStars) {
        this.nbStars = nbStars;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public EventModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
