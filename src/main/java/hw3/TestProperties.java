package hw3;

import enums.driver.PropsEnum;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static common.Paths.NATIVE_PROPERTY_PATH;
import static enums.driver.PropsEnum.WEB_PROPERTY_PATH;
import static java.lang.System.getProperty;

public class TestProperties {

    private Properties currentProps = new Properties();

    protected String getProp(String key) {
        if (!currentProps.containsKey(key)) {
            currentProps = getCurrentProps(PropsEnum.NATIVE_PROPERTY_PATH.text);
        }
        if (!currentProps.containsKey(key)) {
            currentProps = getCurrentProps(WEB_PROPERTY_PATH.text);
        }
        return currentProps.getProperty(key, null);
    }

    private Properties getCurrentProps(String property){
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + property)) {
            currentProps.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentProps;
    }
}
