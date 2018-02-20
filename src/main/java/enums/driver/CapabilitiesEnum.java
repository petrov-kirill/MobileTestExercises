package enums.driver;

public enum CapabilitiesEnum {
    SITE_UNDER_TEST("sut"),
    APPLICATION_UNDER_TEST("aut"),
    APPLICATION("app"),
    CHROME("Chrome"),
    SAFARI("Safari"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    BROWSER_NAME("browserName"),
    DEVICE_NAME("deviceName"),
    PLATFORM_NAME("platformName"),
    EMULATOR_NAME("emulator-5554"),
    ANDROID("Android"),
    IOS("iOS");

    public final String text;

    CapabilitiesEnum(String text) {
        this.text = text;
    }
}
