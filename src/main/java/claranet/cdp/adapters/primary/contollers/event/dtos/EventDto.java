package claranet.cdp.adapters.primary.contollers.event.dtos;

import java.util.Set;

/**
 * Object that represents an event
 */
public class EventDto {

    private Long id;
    private String title;
    private String imgUrl;
    private Set<BandDto> bands;
    private Integer nbStars;
    private String comment;

    public Long getId() {
        return id;
    }

    public EventDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EventDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public EventDto setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Set<BandDto> getBands() {
        return bands;
    }

    public EventDto setBands(Set<BandDto> bands) {
        this.bands = bands;
        return this;
    }

    public Integer getNbStars() {
        return nbStars;
    }

    public EventDto setNbStars(Integer nbStars) {
        this.nbStars = nbStars;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public EventDto setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
