package claranet.cdp.adapters.primary.contollers;

/**
 * Object that represents an exception
 */
public class ExceptionMessage {

    private String date;
    private String path;
    private String className;
    private String message;

    public String getDate() {
        return date;
    }

    public String getPath() {
        return path;
    }

    public String getClassName() {
        return className;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionMessage setDate(String date) {
        this.date = date;
        return this;
    }

    public ExceptionMessage setPath(String path) {
        this.path = path;
        return this;
    }

    public ExceptionMessage setClassName(String className) {
        this.className = className;
        return this;
    }

    public ExceptionMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
