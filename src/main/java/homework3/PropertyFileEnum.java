package homework3;

public enum PropertyFileEnum {
    NATIVE("app.properties"),
    WEB("web.properties");

    public String path;

    PropertyFileEnum(String path) {
        this.path = path;
    }
}
