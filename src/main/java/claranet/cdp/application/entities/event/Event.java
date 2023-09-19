package claranet.cdp.application.entities.event;

import java.util.Set;

/**
 * Object that represents an event
 */
public class Event {

    private Long id;
    private String title;
    private String imgUrl;
    private Set<Band> bands;
    private Comment comment = new Comment();

    public Long getId() {
        return id;
    }

    public Event setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Event setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Event setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Set<Band> getBands() {
        return bands;
    }

    public Event setBands(Set<Band> bands) {
        this.bands = bands;
        return this;
    }

    public Comment getComment() {
        return comment;
    }

    public Event setComment(Comment comment) {
        this.comment = comment;
        return this;
    }

    public boolean isValid() {
        return (title != null && title.length() >= 5)
                && comment.isValid();
    }
}
