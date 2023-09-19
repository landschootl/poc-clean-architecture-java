package claranet.cdp.application.entities.event;

/**
 * Object that represents a comment of an event
 */
public class Comment {

    private String value;
    private Integer nbStars;

    public String getValue() {
        return value;
    }

    public Comment setValue(String value) {
        this.value = value;
        return this;
    }

    public Integer getNbStars() {
        return nbStars;
    }

    public Comment setNbStars(Integer nbStars) {
        this.nbStars = nbStars;
        return this;
    }

    public boolean isValid() {
        return (nbStars == null || (nbStars >= 0 && nbStars <= 5));
    }
}
