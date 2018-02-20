package lesson3.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {

    private static final String WEB_PROPERTY_PATH = "\\src\\main\\resources\\web.properties";
    private static final String NATIVE_PROPERTY_PATH = "\\src\\main\\resources\\native.properties";

    private Properties properties = new Properties();

    private Properties getAnyProperties(String testPropertyPath) {
        File f = new File(testPropertyPath);
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + f)) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    String getProp(String key) throws IOException {
        if (!properties.containsKey(key)) {
            properties = getAnyProperties(WEB_PROPERTY_PATH);
        }
        if (!properties.containsKey(key)) {
            properties = getAnyProperties(NATIVE_PROPERTY_PATH);
        }
        return properties.getProperty(key, null);
    }
}
