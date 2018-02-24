package homework3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static homework3.PropertyFileEnum.WEB;

public class SetupProps {

    Properties currentProps = new Properties();

    Properties getCurrentProps() throws IOException {
        //   String current = NATIVE.path;
        String current = WEB.path;
        try (FileInputStream fis = new FileInputStream(current)) {
            currentProps.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentProps;
    }

    String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }
}
