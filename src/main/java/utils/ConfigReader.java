package utils;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
        	
        	
        	
            FileInputStream fis = new FileInputStream("src/test/resources/config/common.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("failed to load the properties files");
        }
    }

 // Fetch property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Fetch URL based on the selected environment
    public static String getEnvironmentURL() {
        String env = getProperty("environment");
        return getProperty(env + "_URL");  // Dynamically picks QA_URL, UAT_URL, etc.
    }
}

