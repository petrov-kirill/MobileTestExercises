package enums.driver;

public enum PropsEnum {
    APPIUM_LOCAL_HOST_URL("http://127.0.0.1:4723/wd/hub"),
    APPLICATION_NAME("ContactManager.apk"),
    APPLICATION_PATH("/src/main/resources"),
    NATIVE_PROPERTY_PATH("/src/main/resources/native.properties"),
    WEB_PROPERTY_PATH("/src/main/resources/web.properties");

    public final String text;

    PropsEnum(String text) {
        this.text = text;
    }
}
