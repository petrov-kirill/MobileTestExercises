package enums.driver;

public enum CommonEnum {
    HOST("host"),
    URL_HTTP_PREFIX("http://"),
    UNCLEAR_TYPE_OF_APP("Unclear type of mobile app"),
    UNKNOWN_PLATFORM_MESSAGE("Unknown platform");

    public final String text;

    CommonEnum(String text) {
        this.text = text;
    }
}
