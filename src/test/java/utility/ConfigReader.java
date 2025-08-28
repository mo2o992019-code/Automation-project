package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String PROPERTY_FILE_PATH = "utils/config.properties";
    static {
        properties = new Properties();
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_PATH)) {
            if (inputStream != null) {
                properties.load(inputStream);}
            else {
                throw new IOException("Property file '" + PROPERTY_FILE_PATH + "' not found in the classpath");}} catch (IOException e) {
            e.printStackTrace();}}
    public static String getProperty(String key) {
        return properties.getProperty(key);}
}