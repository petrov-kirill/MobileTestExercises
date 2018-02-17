package lesson3.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    Properties properties = new Properties();


    String getProp(String key) throws IOException {
        if (!properties.containsKey(key)) {
            properties = getNativeProperties();
        }
        if (!properties.containsKey(key)) {
            properties = getWebProperties();
        }
        return properties.getProperty(key, null);
    }

    private Properties getWebProperties() {
        File f = new File("\\src\\main\\resources\\web.properties");
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + f)) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private Properties getNativeProperties() {
        File f = new File("\\src\\main\\resources\\native.properties");
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + f)) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
