package core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static File folder = new File("src/main/resources/properties");

    public static String getPropertyValue(String property) {
        Properties prop = new Properties();
        for (File fileEntry : folder.listFiles()) {
            try (InputStream input = new FileInputStream(fileEntry)) {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop.getProperty(property);
    }
}
